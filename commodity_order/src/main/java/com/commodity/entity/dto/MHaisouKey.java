package com.commodity.entity.dto;

public class MHaisouKey {
    private String haisouCd;

    public String getHaisouCd() {
        return haisouCd;
    }

    public void setHaisouCd(String haisouCd) {
        this.haisouCd = haisouCd == null ? null : haisouCd.trim();
    }
}