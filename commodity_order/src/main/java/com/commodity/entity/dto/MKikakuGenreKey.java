package com.commodity.entity.dto;

public class MKikakuGenreKey {
    private String kikakuCd;

    private String genreNo;

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
    }

    public String getGenreNo() {
        return genreNo;
    }

    public void setGenreNo(String genreNo) {
        this.genreNo = genreNo == null ? null : genreNo.trim();
    }
}