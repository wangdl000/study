package nablarch.core.repository.component;

import nablarch.core.repository.initialization.Initializable;

public class Component1 implements Initializable {
	private String prop1;
	private boolean boolProp;
	private Boolean wrapBoolProp;
	private int intProp;
	private Integer wrapIntProp;
	private long longProp;
	private Long wrapLongProp;
	private String[] arrayProp1;
	private String[] arrayProp2;
	private int[] intArrayProp;
	private Integer[] integerArrayProp;
	private long[] longArrayProp;

	private String initValue;

	/**
	 * arrayProp2を取得する。
	 * @return arrayProp2
	 */
	public String[] getArrayProp2() {
		return arrayProp2;
	}

	/**
	 * arrayProp2をセットする。
	 * @param arrayProp2 セットするarrayProp2。
	 */
	public void setArrayProp2(String[] arrayProp2) {
		this.arrayProp2 = arrayProp2;
	}

	/**
	 * wrapBoolPropを取得する。
	 * @return wrapBoolProp
	 */
	public Boolean getWrapBoolProp() {
		return wrapBoolProp;
	}

	/**
	 * wrapBoolPropをセットする。
	 * @param wrapBoolProp セットするwrapBoolProp。
	 */
	public void setWrapBoolProp(Boolean wrapBoolProp) {
		this.wrapBoolProp = wrapBoolProp;
	}

	/**
	 * wrapIntPropを取得する。
	 * @return wrapIntProp
	 */
	public Integer getWrapIntProp() {
		return wrapIntProp;
	}

	/**
	 * wrapIntPropをセットする。
	 * @param wrapIntProp セットするwrapIntProp。
	 */
	public void setWrapIntProp(Integer wrapIntProp) {
		this.wrapIntProp = wrapIntProp;
	}

	/**
	 * wrapLongPropを取得する。
	 * @return wrapLongProp
	 */
	public Long getWrapLongProp() {
		return wrapLongProp;
	}

	/**
	 * wrapLongPropをセットする。
	 * @param wrapLongProp セットするwrapLongProp。
	 */
	public void setWrapLongProp(Long wrapLongProp) {
		this.wrapLongProp = wrapLongProp;
	}

	private Component2 component2;

	/**
	 * prop1を取得する。
	 * @return prop1
	 */
	public String getProp1() {
		return prop1;
	}

	/**
	 * prop1をセットする。
	 * @param prop1 セットするprop1。
	 */
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	/**
	 * boolPropを取得する。
	 * @return boolProp
	 */
	public boolean isBoolProp() {
		return boolProp;
	}

	/**
	 * boolPropをセットする。
	 * @param boolProp セットするboolProp。
	 */
	public void setBoolProp(boolean boolProp) {
		this.boolProp = boolProp;
	}

	/**
	 * intPropを取得する。
	 * @return intProp
	 */
	public int getIntProp() {
		return intProp;
	}

	/**
	 * intPropをセットする。
	 * @param intProp セットするintProp。
	 */
	public void setIntProp(int intProp) {
		this.intProp = intProp;
	}

	/**
	 * longPropを取得する。
	 * @return longProp
	 */
	public long getLongProp() {
		return longProp;
	}

	/**
	 * longPropをセットする。
	 * @param longProp セットするlongProp。
	 */
	public void setLongProp(long longProp) {
		this.longProp = longProp;
	}

	/**
	 * arrayPropを取得する。
	 * @return arrayProp
	 */
	public String[] getArrayProp1() {
		return arrayProp1;
	}

	/**
	 * arrayPropをセットする。
	 * @param arrayProp セットするarrayProp。
	 */
	public void setArrayProp1(String[] arrayProp) {
		this.arrayProp1 = arrayProp;
	}

	public void setIntArrayProp(int[] intArrayProp) {
		this.intArrayProp = intArrayProp;
	}

	public int[] getIntArrayProp() {
		return intArrayProp;
	}

	public void setIntegerArrayProp(Integer[] integerArrayProp) {
		this.integerArrayProp = integerArrayProp;
	}

	public Integer[] getIntegerArrayProp() {
		return integerArrayProp;
	}

	/**
	 * component2を取得する。
	 * @return component2
	 */
	public Component2 getComponent2() {
		return component2;
	}

	/**
	 * component2をセットする。
	 * @param component2 セットするcomponent2。
	 */
	public void setComponent2(Component2 component2) {
		this.component2 = component2;
	}

	public String getInitValue() {
		return initValue;
	}

	/**
	 * 初期化処理
	 */
	public void initialize() {
		initValue = "init";
	}

	/**
	 * longArrayPropを取得する。
	 * 
	 * @return longArrayProp
	 */
	public long[] getLongArrayProp() {
		return longArrayProp;
	}

	/**
	 * longArrayPropを設定する。
	 *
	 * @param longArrayProp longArrayProp 
	 */
	public void setLongArrayProp(long[] longArrayProp) {
		this.longArrayProp = longArrayProp;
	}

}
