package com.commodity.gift_order.service.dto;

import java.util.LinkedHashMap;

/**
 * <B>CatalogListOutputDto</B><BR>
 * <P>CatalogListService出力Dto</P><BR>
 * @date  2010.12.08
 * @author  DTT wang-pf
 */
public class CatalogListOutputDto extends BaseOutputDto {
	/** 出力戻る値 */
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
		return "CatalogListOutputDto [returnMap=" + returnMap + "]";
	}

}
