package com.commodity.gift_order.service.dto;

import java.util.Map;

public class CodeOutputDto extends BaseOutputDto {

	private Map<String, Map<String, String>> codeMap;

	/**
	 * @return codeMap
	 */
	public Map<String, Map<String, String>> getCodeMap() {
		return codeMap;
	}

	/**
	 * @param codeMap
	 *            セットする codeMap
	 */
	public void setCodeMap(Map<String, Map<String, String>> codeMap) {
		this.codeMap = codeMap;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CodeOutputDto [codeMap=" + codeMap + "]";
	}

}
