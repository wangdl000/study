package com.commodity.entity.dto;

public class MCatalogKey {
    private String catalogId;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }
}