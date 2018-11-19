package com.commodity.entity.dto;

public class MKanrisyaUserKikakuKey {
    private String kikakuCd;

    private String kanriUserId;

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
    }

    public String getKanriUserId() {
        return kanriUserId;
    }

    public void setKanriUserId(String kanriUserId) {
        this.kanriUserId = kanriUserId == null ? null : kanriUserId.trim();
    }
}