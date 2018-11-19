package com.commodity.gift_order.util;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.commodity.gift_order.bean.GenreBean;
import com.commodity.gift_order.constant.CostInfo;

public class GellibUtils {

	public static String testStr() {
		return "test string.";
	}

	public static String ifNull(Object arg1, Object arg2) {

		Object localArg1 = arg1;
		Object localArg2 = arg2;

		if (localArg2 == null) {
			localArg2 = "";
		}

		if (localArg1 != null) {
			return String.valueOf(localArg1);
		} else {
			return String.valueOf(localArg2);
		}
	}

	public static String ifNullBlank(Object arg1) {
		return ifNull(arg1, "");
	}

	public static boolean isEmpty(Object obj) {

		if (obj == null) {
			return true;
		} else if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		} else if (java.util.Collection.class.isAssignableFrom(obj.getClass())) {
			return ((Collection<?>) obj).isEmpty();
		} else if (java.util.Map.class.isAssignableFrom(obj.getClass())) {
			return ((Map<?, ?>) obj).isEmpty();
		} else if (obj instanceof String) {
			return obj.toString().trim().length() == 0;
		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(Object o) {

		return !isEmpty(o);

	}

	public static boolean isGenreIconView(String genreNo, GenreBean genre) {

		if (isEmpty(genreNo) || genre == null) {
			return false;
		}

		if (genreNo.equals(genre.getGenreNo())) {

			if ("1".equals(genre.getGenreIconHyoujiFlg())) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isGenreIconView(String genreNo, List<GenreBean> genreList) {

		for (GenreBean genre : genreList) {

			if (isGenreIconView(genreNo, genre)) {
				return true;
			}

		}

		return false;

	}

	public static List<String> getGenreIconViewList(List<String> genreList, List<GenreBean> genreBeanList) {

		List<String> iconList = new ArrayList<String>();

		for (String genre : genreList) {
			if (isGenreIconView(genre, genreBeanList)) {
				iconList.add(genre);
			}
		}

		return iconList;
	}

	/**
	 *
	 * @param cd
	 * @param splitFormat
	 * @param formatStr
	 * @return
	 */
	public static String formatCd(String cd, String splitFormat, String formatStr) {

		if (isEmpty(cd) || isEmpty(splitFormat) || isEmpty(formatStr)) {
			return cd;
		}

		String[] splitFormatStrArr = splitFormat.split(",");

		Integer[] splitFormatIntArr = new Integer[splitFormatStrArr.length];

		for (int i = 0; splitFormatStrArr.length > i; i++) {
			splitFormatIntArr[i] = new Integer(splitFormatStrArr[i]);
		}

		String formatArgStr[] = new String[splitFormatStrArr.length];

		int beginIndex = 0;
		for (int i = 0; splitFormatIntArr.length > i; i++) {

			formatArgStr[i] = cd.substring(beginIndex, beginIndex + splitFormatIntArr[i]);
			beginIndex = beginIndex + splitFormatIntArr[i];

		}

		return MessageFormat.format(formatStr, (Object[]) formatArgStr);

	}

	/**
	 * <B>formatDate</B><BR>
	 * <P>
	 * 指定された日付をフォーマットする。
	 * </P>
	 * <BR>
	 *
	 * @param date
	 * @return strFormatDate
	 */
	public static String formatDate(Date date, String formatStyle) {
		String strFormatDate = "";
		if (GellibUtils.isNotEmpty(date)) {
			strFormatDate = new SimpleDateFormat(formatStyle).format(date);
		}
		return strFormatDate;
	}

	/**
	 * <B>toDate</B><BR>
	 * <P>
	 * 指定された日付をＤａｔｅタイプに変換する。
	 * </P>
	 * <BR>
	 *
	 * @param strDate
	 * @return date
	 * @throws ParseException
	 */
	public static Date toDate(String strDate) throws ParseException {
		Date date = null;
		if (GellibUtils.isNotEmpty(strDate)) {
			date = new SimpleDateFormat(CostInfo.DATE_STYLE_2).parse(strDate.replace("/", "-"));
		}
		return date;
	}

	/**
	 * <B>toDateTime</B><BR>
	 * <P>
	 * 指定された日付をＤａｔｅTimeタイプに変換する。
	 * </P>
	 * <BR>
	 *
	 * @param strDate
	 * @return date
	 * @throws ParseException
	 */
	public static Date toDateTime(String strDate) throws ParseException {
		Date dateTime = null;
		if (GellibUtils.isNotEmpty(strDate)) {
			dateTime = new SimpleDateFormat(CostInfo.DATE_STYLE_3).parse(strDate);
		}
		return dateTime;
	}

	/**
	 * <B>convertEscapeChar</B><BR>
	 * <P>
	 * データベースの検索条件のESCAPE文字に変換する。
	 * </P>
	 * <BR>
	 *
	 * @param argOptStr 処理対象
	 * @return String 処理結果
	 * @throws なし
	 */
	public static String convertEscapeChar(String argOptStr) {
		if (GellibUtils.isEmpty(argOptStr)) {
			return argOptStr;
		} else {
			// 特別文字変更する
			argOptStr = argOptStr.replaceAll("\\\\", "\\\\\\\\");
			argOptStr = argOptStr.replaceAll("%", "\\\\%");
			argOptStr = argOptStr.replaceAll("_", "\\\\_");
			argOptStr = argOptStr.replaceAll("\uFF05", "\\\\\uFF05");
			argOptStr = argOptStr.replaceAll("\uFF3F", "\\\\\uFF3F");
			return argOptStr;
		}
	}
}
