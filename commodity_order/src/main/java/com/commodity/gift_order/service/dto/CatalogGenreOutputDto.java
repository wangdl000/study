package com.commodity.gift_order.service.dto;

import java.util.List;

import com.commodity.gift_order.bean.GenreBean;

public class CatalogGenreOutputDto extends BaseOutputDto {

	List<GenreBean> genreList;

	public List<GenreBean> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<GenreBean> genreList) {
		this.genreList = genreList;
	}

	@Override
	public String toString() {
		return "CatalogGenreOutputDto [genreList=" + genreList + "]";
	}

}
