package com.commodity.entity.dto;

public class MKikakuKey {
    private String kikakuCd;

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
    }
}