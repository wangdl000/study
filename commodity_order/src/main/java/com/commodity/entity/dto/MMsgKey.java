package com.commodity.entity.dto;

public class MMsgKey {
    private String catalogId;

    private Long msgNo;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    public Long getMsgNo() {
        return msgNo;
    }

    public void setMsgNo(Long msgNo) {
        this.msgNo = msgNo;
    }
}