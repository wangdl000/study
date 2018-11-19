package com.commodity.entity.dto;

public class VWebKikaku {
    private String kikakuCd;

    private String baseDirectory;

    private String kikakuName;

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
    }

    public String getBaseDirectory() {
        return baseDirectory;
    }

    public void setBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory == null ? null : baseDirectory.trim();
    }

    public String getKikakuName() {
        return kikakuName;
    }

    public void setKikakuName(String kikakuName) {
        this.kikakuName = kikakuName == null ? null : kikakuName.trim();
    }
}