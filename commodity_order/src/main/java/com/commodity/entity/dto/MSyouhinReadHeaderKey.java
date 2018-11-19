package com.commodity.entity.dto;

import java.util.Date;

public class MSyouhinReadHeaderKey {
    private Long readPattern;

    private Date syoriBi;

    public Long getReadPattern() {
        return readPattern;
    }

    public void setReadPattern(Long readPattern) {
        this.readPattern = readPattern;
    }

    public Date getSyoriBi() {
        return syoriBi;
    }

    public void setSyoriBi(Date syoriBi) {
        this.syoriBi = syoriBi;
    }
}