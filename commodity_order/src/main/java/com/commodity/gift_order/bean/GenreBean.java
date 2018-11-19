package com.commodity.gift_order.bean;

public class GenreBean extends BaseBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String catalogId;
	private String genreNo;
	private Long sortOrder;
	private String genreName;
	private String genreHeaderImageUrl;
	private String genreLinkImageUrl;
	private String menuHyoujiFlg;
	private String genreIconHyoujiFlg;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getGenreNo() {
		return genreNo;
	}

	public void setGenreNo(String genreNo) {
		this.genreNo = genreNo;
	}

	public Long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getGenreHeaderImageUrl() {
		return genreHeaderImageUrl;
	}

	public void setGenreHeaderImageUrl(String genreHeaderImageUrl) {
		this.genreHeaderImageUrl = genreHeaderImageUrl;
	}

	public String getGenreLinkImageUrl() {
		return genreLinkImageUrl;
	}

	public void setGenreLinkImageUrl(String genreLinkImageUrl) {
		this.genreLinkImageUrl = genreLinkImageUrl;
	}

	public String getMenuHyoujiFlg() {
		return menuHyoujiFlg;
	}

	public void setMenuHyoujiFlg(String menuHyoujiFlg) {
		this.menuHyoujiFlg = menuHyoujiFlg;
	}

	public String getGenreIconHyoujiFlg() {
		return genreIconHyoujiFlg;
	}

	public void setGenreIconHyoujiFlg(String genreIconHyoujiFlg) {
		this.genreIconHyoujiFlg = genreIconHyoujiFlg;
	}

	@Override
	public String toString() {
		return "GenreBean [catalogId=" + catalogId + ", genreNo=" + genreNo + ", sortOrder=" + sortOrder
				+ ", genreName=" + genreName + ", genreHeaderImageUrl=" + genreHeaderImageUrl + ", genreLinkImageUrl="
				+ genreLinkImageUrl + ", menuHyoujiFlg=" + menuHyoujiFlg + ", genreIconHyoujiFlg=" + genreIconHyoujiFlg
				+ "]";
	}

}
