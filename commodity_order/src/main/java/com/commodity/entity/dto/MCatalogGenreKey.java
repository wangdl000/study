package com.commodity.entity.dto;

public class MCatalogGenreKey {
    private String catalogId;

    private String genreNo;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    public String getGenreNo() {
        return genreNo;
    }

    public void setGenreNo(String genreNo) {
        this.genreNo = genreNo == null ? null : genreNo.trim();
    }
}