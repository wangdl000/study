package com.commodity.entity.dto;

public class MSyouhinReadDetailKey {
    private Long readPattern;

    private String syouhinCd;

    public Long getReadPattern() {
        return readPattern;
    }

    public void setReadPattern(Long readPattern) {
        this.readPattern = readPattern;
    }

    public String getSyouhinCd() {
        return syouhinCd;
    }

    public void setSyouhinCd(String syouhinCd) {
        this.syouhinCd = syouhinCd == null ? null : syouhinCd.trim();
    }
}