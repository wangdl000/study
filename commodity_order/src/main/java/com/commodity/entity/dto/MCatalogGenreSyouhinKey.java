package com.commodity.entity.dto;

public class MCatalogGenreSyouhinKey {
    private String catalogId;

    private String genreNo;

    private String hagakiSyouhinCd;

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

    public String getHagakiSyouhinCd() {
        return hagakiSyouhinCd;
    }

    public void setHagakiSyouhinCd(String hagakiSyouhinCd) {
        this.hagakiSyouhinCd = hagakiSyouhinCd == null ? null : hagakiSyouhinCd.trim();
    }
}