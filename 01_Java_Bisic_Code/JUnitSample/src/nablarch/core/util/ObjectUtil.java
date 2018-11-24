package nablarch.core.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import nablarch.core.exception.IllegalConfigurationException;
import nablarch.core.util.annotation.Published;

/**
 * フレームワークで使用する、オブジェクトの取り扱いを助けるユーティリティクラス。
 *
 * @author Kiyohito Itoh
 */
@Published(tag = "architect")
public final class ObjectUtil {

	/**
	 * プリミティブ型のマップ。
	 */
	private static final Map<Class<?>, Class<?>> PRIMITIVE_TYPE_MAP;

	/**
	 * 隠蔽コンストラクタ。
	 */
	private ObjectUtil() {
		// NOP
	}

	static {
		Map<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>();
		primitiveMap.put(Boolean.TYPE, Boolean.class);
		primitiveMap.put(Character.TYPE, Character.class);
		primitiveMap.put(Byte.TYPE, Byte.class);
		primitiveMap.put(Short.TYPE, Short.class);
		primitiveMap.put(Integer.TYPE, Integer.class);
		primitiveMap.put(Long.TYPE, Long.class);
		primitiveMap.put(Float.TYPE, Float.class);
		primitiveMap.put(Double.TYPE, Double.class);
		PRIMITIVE_TYPE_MAP = Collections.unmodifiableMap(primitiveMap);
	}

	/**
	 * クラス名からインスタンスを生成する。
	 *
	 * @param <T> 型引数
	 * @param className 完全修飾クラス名
	 * @return インスタンス
	 * @throws IllegalArgumentException インスタンスの生成に失敗した場合
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createInstance(String className) {
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException(
					String.format(
							"It failed to instantiate the class[%s].", className),
					e);
		}
	}

	/**
	 * オブジェクトのプロパティに値を設定する。
	 *
	 * 本メソッドでは、対象プロパティがstaticの場合でも値は設定される。
	 *
	 * @param obj 対象のオブジェクト
	 * @param propertyName プロパティ名
	 * @param value 設定する値(NOT {@code null})
	 * @throws RuntimeException
	 *   対象プロパティにsetterが定義されていない場合か、
	 *   対象プロパティのsetterが対象プロパティの型かそのサブクラスを引数にとらない場合
	 */
	public static void setProperty(Object obj, String propertyName, Object value) {
		setProperty(obj, propertyName, value, true);
	}

	/**
	 * オブジェクトのプロパティに値を設定する。
	 *
	 * 本メソッドでは、対象プロパティがstaticの場合に値を設定するかどうかを引数で制御できる。
	 * 引数allowStaticが{@code false}（許容しない）かつ対象プロパティがstaticである場合、
	 * 例外が発生する。
	 *
	 * @param obj 対象のオブジェクト
	 * @param propertyName プロパティ名
	 * @param value 設定する値(NOT {@code null})
	 * @param allowStatic staticなプロパティに対する値の設定を許容するかどうか
	 * @throws RuntimeException
	 *   対象プロパティにsetterが定義されていない場合か、
	 *   対象プロパティのsetterが対象プロパティの型かそのサブクラスを引数にとらない場合
	 * @throws IllegalConfigurationException
	 *   引数allowStaticが{@code false}（許容しない）かつ対象プロパティがstaticである場合。
	 *   (システムプロパティやweb.xml等の設定誤り)
	 */
	public static void setProperty(Object obj, String propertyName, Object value, boolean allowStatic) {

		String setterName = getSetterMethodName(propertyName);
		Class<?> targetClass = obj.getClass();
		Class<?> valueClass = value.getClass();
		Method method = findMatchMethod(targetClass, setterName, valueClass);
		if (method == null) {
			throw new RuntimeException("can't find method [" + setterName + "] in class " + targetClass.getName());
		}
		if (!allowStatic && Modifier.isStatic(method.getModifiers())) {
			throw new IllegalConfigurationException("static property injection not allowed. " +
					"class=[" + targetClass.getName() + "] property=[" + propertyName + "]");
		}
		try {
			method.invoke(obj, value);
		} catch (Exception e) {
			throw new RuntimeException("can't set property [" + propertyName + "]", e);
		}
	}

	/**
	 * プロパティ名からsetterメソッド名を取得する。
	 *
	 * @param propertyName プロパティ名
	 * @return setterメソッド名
	 */
	public static String getSetterMethodName(String propertyName) {
		String setterName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
		return setterName;
	}

	/**
	 * 指定したシグネチャにマッチするメソッドを検索する。
	 * <p/>
	 * マッチするメソッドが見つからなかった場合は{@code null}を返す。
	 * <p/>
	 * マッチング条件は以下である。
	 * <ul>
	 *     <li>{@code methodName}とメソッド名が一致していること</li>
	 *     <li>{@code valueTypes}と引数の数が一致していること</li>
	 *     <li>{@code valueTypes}と引数の型が一致していること。ただし、以下の場合は「同一の型」と見なす。
	 *         <ul>
	 *             <li>プリミティブ型とそのラッパー型とを比較した場合</li>
	 *             <li>{@code valueTypes}で指定した型とそのスーパークラスとを比較した場合</li>
	 *         </ul>
	 *     </li>
	 * </ul>
	 *
	 * @param objectClass 検索対象のクラス
	 * @param methodName メソッド名
	 * @param valueTypes 引数の型リスト(NOT {@code null})。
	 *                   引数の型の他、そのサブクラスでもマッチする。
	 *                   引数を取らないメソッドを検索する場合は、空の配列を引き渡す。
	 * @return 検索されたメソッド
	 */
	public static Method findMatchMethod(Class<?> objectClass, String methodName, Class<?>... valueTypes) {

		for (Method m : objectClass.getMethods()) {
			if (m.getName().equals(methodName)) {
				Class<?>[] parameterTypes = m.getParameterTypes();
				if (valueTypes.length == parameterTypes.length) {
					boolean allMatch = true;
					for (int i = 0; i < valueTypes.length; i++) {

						Class<?> paramType = parameterTypes[i];
						Class<?> valueType = valueTypes[i];
						if (paramType.isPrimitive()) {
							paramType = PRIMITIVE_TYPE_MAP.get(paramType);
						}
						if (valueType.isPrimitive()) {
							valueType = PRIMITIVE_TYPE_MAP.get(valueType);
						}
						if (!paramType.isAssignableFrom(valueType)) {
							allMatch = false;
							break;
						}
					}
					if (allMatch) {
						return m;
					}
				}
			}
		}

		return null;
	}

	/**
	 * クラスの全ての祖先を取得する。
	 * <p/>
	 * 祖先のリストの並び順は、{@code clazz}からの近さ順となる。
	 * <p/>
	 * {@link Object}は取得結果リストに含まれない。<br/>
	 * そのため、{@code clazz}が{@link Object}以外を継承していないクラスである場合、空のリストを返す。
	 *
	 * @param clazz 祖先を取得するクラス
	 * @return クラスの全ての祖先のリスト
	 */
	public static List<Class<?>> getAncestorClasses(Class<?> clazz) {
		List<Class<?>> ancestors = new ArrayList<Class<?>>();
		if (clazz.getSuperclass() != null) {
			for (Class<?> current = clazz.getSuperclass(); current != Object.class; current = current.getSuperclass()) {
				ancestors.add(current);
			}
		}
		return ancestors;
	}

	/**
	 * プロパティの型を取得する。
	 * <p/>
	 * setterが定義されているプロパティのみ取得可能である。
	 * <p/>
	 * 該当するプロパティが見つからない場合は{@code null}を返す。
	 *
	 * @param clazz プロパティの型を取得するクラス
	 * @param propertyName プロパティ名
	 * @return プロパティの型
	 */
	public static Class<?> getPropertyType(Class<?> clazz, String propertyName) {
		String methodName = getSetterMethodName(propertyName);
		for (Method m : clazz.getMethods()) {
			if (m.getName().equals(methodName)) {
				Class<?>[] paramTypes = m.getParameterTypes();
				if (paramTypes.length == 1) {
					return paramTypes[0];
				}
			}
		}
		return null;
	}

	/**
	 * {@code clazz}に定義されたプロパティの名称リストを取得する。
	 * setterが定義されているプロパティのみが対象となる。
	 * <p/>
	 * {@code clazz}にsetterが定義されたプロパティがない場合、空のリストを返す。
	 *
	 * @param clazz 取得対象のクラス
	 * @return {@code clazz}に定義されたプロパティの名称リスト(setterが定義されているプロパティのみ取得する)
	 */
	public static List<String> getWritablePropertyNames(Class<?> clazz) {
		List<String> props = new ArrayList<String>();
		for (Method method : getSetterMethods(clazz)) {
			String propertyName = getPropertyNameFromSetter(method);
			props.add(propertyName);
		}

		return props;
	}

	/**
	 * setterメソッドからプロパティ名を取得する。
	 *
	 * @param method セッタメソッド
	 * @return プロパティ名
	 * @throws IllegalArgumentException {@code method}の名称が"set"で開始していない場合
	 */
	public static String getPropertyNameFromSetter(Method method) {
		String methodName = method.getName();
		if (!methodName.startsWith("set")) {
			throw new IllegalArgumentException("Method is not setter. \n"
					+ " method = " + method + ".");
		}
		String propertyName = methodName.substring("set".length());
		propertyName = propertyName.substring(0, 1).toLowerCase()
				+ propertyName.substring(1);
		return propertyName;
	}

	/**
	 * setterメソッドのメソッド名パターン。
	 */
	private static final Pattern SETTER_METHOD_NAME_PATTERN = Pattern.compile("^set[A-Z]");

	/**
	 * {@code clazz}に定義されたsetterのリストを取得する。
	 * <p/>
	 * setterが一つも定義されていない場合は空のリストを返す。
	 *
	 * @param clazz 取得対象のクラス
	 * @return {@code clazz}に定義されたセッタのリスト
	 */
	public static List<Method> getSetterMethods(Class<?> clazz) {
		List<Method> props = new ArrayList<Method>();
		for (Method method : clazz.getMethods()) {
			String methodName = method.getName();
			if (SETTER_METHOD_NAME_PATTERN.matcher(methodName).find()
					&& method.getParameterTypes().length == 1) {
				props.add(method);
			}
		}

		return props;
	}

	/**
	 * setterメソッドを検索する。
	 *
	 * @param targetClass ターゲットのクラス
	 * @param propertyName プロパティ名
	 * @return setterメソッド
	 * @throws RuntimeException {@code propertyName}に対応するsetterがない場合
	 */
	public static Method getSetterMethod(Class<?> targetClass, String propertyName) {
		Class<?> type = getPropertyType(targetClass, propertyName);
		String setterMethodName = getSetterMethodName(propertyName);
		Method method = findMatchMethod(targetClass, setterMethodName, type);
		if (method == null) {
			throw new RuntimeException(
					"can't find method [" + setterMethodName + "] in class " + targetClass.getName());
		}
		return method;
	}

	/**
	 * getterメソッドを検索する。
	 *
	 * @param targetClass ターゲットのクラス
	 * @param propertyName プロパティ名
	 * @return getterメソッド
	 * @throws RuntimeException {@code propertyName}に対応するgetterがない場合
	 */
	public static Method getGetterMethod(Class<?> targetClass, String propertyName) {
		String getterMethodName = getGetterMethodName(propertyName);
		Method method = findMatchMethod(targetClass, getterMethodName);
		if (method == null) {
			throw new RuntimeException(
					"can't find method [" + getterMethodName + "] in class " + targetClass.getName());
		}
		return method;
	}

	/**
	 * プロパティ名からgetterメソッド名を取得する。
	 *
	 * @param propertyName プロパティ名
	 * @return getterメソッド名
	 * @throws IllegalArgumentException {@code propertyName}が{@code null}か空文字である場合
	 */
	public static String getGetterMethodName(String propertyName) {
		if (StringUtil.isNullOrEmpty(propertyName)) {
			throw new IllegalArgumentException(
					"propertyName must not null or empty.");
		}
		return "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
	}

	/**
	 * getterメソッドからプロパティ名を取得する。
	 * <p/>
	 *
	 * @param method getterメソッド
	 * @return プロパティ名
	 * @throws IllegalArgumentException {@code method}の名前が"get"で開始していない場合
	 */
	public static String getPropertyNameFromGetter(Method method) {
		String methodName = method.getName();
		if (!methodName.startsWith("get")) {
			throw new IllegalArgumentException("Method is not getter. \n"
					+ " method = " + method + ".");
		}
		String propertyName = methodName.substring("get".length());
		propertyName = propertyName.substring(0, 1).toLowerCase()
				+ propertyName.substring(1);
		return propertyName;
	}

	/**
	 * getterメソッドのメソッド名パターン。
	 */
	private static final Pattern GETTER_METHOD_NAME_PATTERN = Pattern.compile("^get[A-Z]");

	/**
	 * クラスにあるgetterのリストを取得する。
	 * <p/>
	 * {@link Object#getClass()}は取得対象から除く。
	 * <p/>
	 * getterが一つも定義されていない場合は空のリストを返す。
	 *
	 * @param clazz 取得対象のクラス
	 * @return クラスにあるgetterのリスト
	 */
	public static List<Method> getGetterMethods(Class<?> clazz) {
		List<Method> props = new ArrayList<Method>();
		for (Method method : clazz.getMethods()) {
			String methodName = method.getName();
			if (!methodName.equals("getClass") && GETTER_METHOD_NAME_PATTERN.matcher(methodName).find()) {
				props.add(method);
			}
		}
		return props;
	}

	/**
	 * オブジェクトからプロパティの値を取得する。
	 * @param object {@link Map}、またはプロパティ名のgetterを備えたオブジェクト
	 * @param propertyName プロパティ名
	 * @return プロパティの値
	 * @throws IllegalArgumentException
	 * <ul>
	 *     <li>{@code object}がnullである場合</li>
	 *     <li>{@code propertyName}がnullか空文字である場合</li>
	 *     <li>{@code propertyName}に対応する、getterメソッドが定義されたプロパティがない場合</li>
	 * </ul>
	 *
	 */
	public static Object getProperty(Object object, String propertyName) {
		return getProperty(object, propertyName, true);
	}

	/**
	 * オブジェクトに、指定したプロパティが存在する場合に値を取得する。
	 * <br />
	 * プロパティが存在しなかった場合は{@code null}を返す。
	 *
	 * @param object {@link Map}またはプロパティ名のgetterを備えたオブジェクト
	 * @param propertyName プロパティ名
	 * @return プロパティの値
	 * <ul>
	 *     <li>{@code object}がnullである場合</li>
	 *     <li>{@code propertyName}が{@code null}か空文字である場合</li>
	 * </ul>
	 */
	public static Object getPropertyIfExists(Object object, String propertyName) {
		return getProperty(object, propertyName, false);
	}

	/**
	 * オブジェクトからプロパティの値を取得する。
	 * <br />
	 * throwException が false の場合、プロパティが存在しなかった場合に{@code null}を返す。 <br />
	 * throwException が true の場合、そうでなかった場合には IllegalArgumentException を送出する。
	 * @param object オブジェクト。Mapまたはプロパティ名のgetterを備えたオブジェクト
	 * @param propertyName プロパティ名
	 * @param throwException プロパティが存在しなかった場合に例外を送出するか否かを指定するフラグ
	 * @return プロパティの値
	 */
	private static Object getProperty(Object object, String propertyName, boolean throwException) {

		if (object == null) {
			throw new IllegalArgumentException("object is null.");
		}
		if (propertyName == null) {
			throw new IllegalArgumentException("propertyName is null.");
		}
		if (object instanceof Map<?, ?>) {
			return ((Map<?, ?>) object).get(propertyName);
		} else {
			String methodName = ObjectUtil.getGetterMethodName(propertyName);
			Method method = null;
			try {
				method = object.getClass().getMethod(methodName);
			} catch (Exception e) {
				if (throwException) {
					throw new IllegalArgumentException("property "
							+ propertyName + " not found on class "
							+ object.getClass().getName(), e);
				}
			}
			if (method == null) {
				return null;
			}
			try {
				return method.invoke(object);
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

	/**
	 * 例外の名称のリストから例外クラスのリストを生成する。
	 * <p/>
	 * 指定された{@literal List<String>}の各要素を
	 * {@literal Class<? extends RuntimeException>}に変換し返却する。
	 * <p/>
	 * 例外クラスは、{@code originalExceptions}の文字列クラス名の格納順にリストに格納されて返される。
	 * <p/>
	 * {@code originalExceptions}が空の場合は、空のリストを返す。
	 *
	 * @param originalExceptions 例外クラス名リスト。({@literal List<String>})
	 * @return 例外クラスリスト。({@literal List<Class<? extends RuntimeException>>})
	 * @throws RuntimeException 要素内の文字列クラス名が、RuntimeExceptionのサブクラス以外の場合
	 */
	@SuppressWarnings("unchecked")
	public static List<Class<? extends RuntimeException>> createExceptionsClassList(
			List<String> originalExceptions) {

		List<Class<? extends RuntimeException>> result = new ArrayList<Class<? extends RuntimeException>>(
				originalExceptions.size());

		for (String exception : originalExceptions) {
			Class<? extends RuntimeException> clazz;
			try {
				clazz = (Class<? extends RuntimeException>) Class.forName(
						exception);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			if (!RuntimeException.class.isAssignableFrom(clazz)) {
				throw new RuntimeException(
						"this class isn't a subclass of java.lang.RuntimeException.: "
								+ clazz.getName());
			}
			result.add(clazz);
		}
		return result;
	}
}
