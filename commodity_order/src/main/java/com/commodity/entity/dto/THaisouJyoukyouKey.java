package com.commodity.entity.dto;

public class THaisouJyoukyouKey {
    private String toiawaseNo;

    private String meisaiNo;

    public String getToiawaseNo() {
        return toiawaseNo;
    }

    public void setToiawaseNo(String toiawaseNo) {
        this.toiawaseNo = toiawaseNo == null ? null : toiawaseNo.trim();
    }

    public String getMeisaiNo() {
        return meisaiNo;
    }

    public void setMeisaiNo(String meisaiNo) {
        this.meisaiNo = meisaiNo == null ? null : meisaiNo.trim();
    }
}