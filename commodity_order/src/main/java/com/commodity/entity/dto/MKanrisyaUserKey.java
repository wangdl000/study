package com.commodity.entity.dto;

public class MKanrisyaUserKey {
    private String kanriUserId;

    public String getKanriUserId() {
        return kanriUserId;
    }

    public void setKanriUserId(String kanriUserId) {
        this.kanriUserId = kanriUserId == null ? null : kanriUserId.trim();
    }
}