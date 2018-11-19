package com.commodity.gift_order.service.dto;

/**
 * <B>CatalogGenreSearchInputDto</B><BR>
 * <P>CatalogGenreSearch入力Dto</P><BR>
 * @date  2010/12/08
 * @author  DTT li-t
 */
public class CatalogGenreSearchInputDto extends BaseInputDto {
	/** カタログID */
	private String catalogId;
	/** メニュー表示フラグ */
	private String menuHyoujiFlg;

	/**
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}



	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}



	/**
	 * @return the menuHyoujiFlg
	 */
	public String getMenuHyoujiFlg() {
		return menuHyoujiFlg;
	}



	/**
	 * @param menuHyoujiFlg the menuHyoujiFlg to set
	 */
	public void setMenuHyoujiFlg(String menuHyoujiFlg) {
		this.menuHyoujiFlg = menuHyoujiFlg;
	}



	@Override
	public String toString() {
		return "CatalogGenreSearchInputDto [catalogId=" + catalogId + ", menuHyoujiFlg=" + menuHyoujiFlg + "]";
	}

}
