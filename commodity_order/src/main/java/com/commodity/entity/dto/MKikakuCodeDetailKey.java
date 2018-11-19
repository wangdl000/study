package com.commodity.entity.dto;

public class MKikakuCodeDetailKey {
    private String kikakuCd;

    private String sikibetsuCd;

    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}