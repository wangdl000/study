package com.commodity.entity.dto;

public class MCodeKey {
    private String sikibetsuCd;

    private String code;

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