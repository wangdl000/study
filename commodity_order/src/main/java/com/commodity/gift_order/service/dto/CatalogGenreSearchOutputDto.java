package com.commodity.gift_order.service.dto;

import java.util.LinkedHashMap;

/**
 * <B>CatalogGenreSearchOutputDto</B><BR>
 * <p>説明：共通ソフトウェア部品(Service)04処理アクションクラス</p>
 * @date  2010.12.08
 * @author  DTT li-t
 */
public class CatalogGenreSearchOutputDto extends BaseOutputDto {

	/**出力戻る値*/
	private LinkedHashMap<String, LinkedHashMap<String, String>> returnMap;

	/**
	 * @return the returnMap
	 */
	public LinkedHashMap<String, LinkedHashMap<String, String>> getReturnMap() {
		return returnMap;
	}

	/**
	 * @param returnMap the returnMap to set
	 */
	public void setReturnMap(LinkedHashMap<String, LinkedHashMap<String, String>> returnMap) {
		this.returnMap = returnMap;
	}

	@Override
	public String toString() {
		return "CatalogGenreSearchOutputDto [returnMap=" + returnMap + "]";
	}

}
