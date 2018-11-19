package com.commodity.entity.dto;

public class MKikakuCodeKey {
    private String kikakuCd;

    private String sikibetsuCd;

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
    }

    public String getSikibetsuCd() {
        return sikibetsuCd;
    }

    public void setSikibetsuCd(String sikibetsuCd) {
        this.sikibetsuCd = sikibetsuCd == null ? null : sikibetsuCd.trim();
    }
}