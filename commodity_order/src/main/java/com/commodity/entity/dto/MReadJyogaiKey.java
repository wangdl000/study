package com.commodity.entity.dto;

import java.util.Date;

public class MReadJyogaiKey {
    private String syouhinCd;

    private Date todokeFukabi;

    public String getSyouhinCd() {
        return syouhinCd;
    }

    public void setSyouhinCd(String syouhinCd) {
        this.syouhinCd = syouhinCd == null ? null : syouhinCd.trim();
    }

    public Date getTodokeFukabi() {
        return todokeFukabi;
    }

    public void setTodokeFukabi(Date todokeFukabi) {
        this.todokeFukabi = todokeFukabi;
    }
}