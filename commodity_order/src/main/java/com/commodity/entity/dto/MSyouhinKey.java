package com.commodity.entity.dto;

public class MSyouhinKey {
    private String syouhinCd;

    public String getSyouhinCd() {
        return syouhinCd;
    }

    public void setSyouhinCd(String syouhinCd) {
        this.syouhinCd = syouhinCd == null ? null : syouhinCd.trim();
    }
}