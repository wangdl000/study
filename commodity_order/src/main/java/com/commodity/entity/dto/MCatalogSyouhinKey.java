package com.commodity.entity.dto;

public class MCatalogSyouhinKey {
    private String catalogId;

    private String hagakiSyouhinCd;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    public String getHagakiSyouhinCd() {
        return hagakiSyouhinCd;
    }

    public void setHagakiSyouhinCd(String hagakiSyouhinCd) {
        this.hagakiSyouhinCd = hagakiSyouhinCd == null ? null : hagakiSyouhinCd.trim();
    }
}