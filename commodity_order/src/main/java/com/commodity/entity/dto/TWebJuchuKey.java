package com.commodity.entity.dto;

public class TWebJuchuKey {
    private String toiawaseNo;

    public String getToiawaseNo() {
        return toiawaseNo;
    }

    public void setToiawaseNo(String toiawaseNo) {
        this.toiawaseNo = toiawaseNo == null ? null : toiawaseNo.trim();
    }
}