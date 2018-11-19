package com.commodity.entity.dto;

import java.util.Date;

public class MKikakuGenre extends MKikakuGenreKey {
    private String genreName;

    private Long sortOrder;

    private String genreHeaderImageUrl;

    private String genreLinkImageUrl;

    private String menuHyoujiFlg;

    private String genreIconHyoujiFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName == null ? null : genreName.trim();
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getGenreHeaderImageUrl() {
        return genreHeaderImageUrl;
    }

    public void setGenreHeaderImageUrl(String genreHeaderImageUrl) {
        this.genreHeaderImageUrl = genreHeaderImageUrl == null ? null : genreHeaderImageUrl.trim();
    }

    public String getGenreLinkImageUrl() {
        return genreLinkImageUrl;
    }

    public void setGenreLinkImageUrl(String genreLinkImageUrl) {
        this.genreLinkImageUrl = genreLinkImageUrl == null ? null : genreLinkImageUrl.trim();
    }

    public String getMenuHyoujiFlg() {
        return menuHyoujiFlg;
    }

    public void setMenuHyoujiFlg(String menuHyoujiFlg) {
        this.menuHyoujiFlg = menuHyoujiFlg == null ? null : menuHyoujiFlg.trim();
    }

    public String getGenreIconHyoujiFlg() {
        return genreIconHyoujiFlg;
    }

    public void setGenreIconHyoujiFlg(String genreIconHyoujiFlg) {
        this.genreIconHyoujiFlg = genreIconHyoujiFlg == null ? null : genreIconHyoujiFlg.trim();
    }

    public Date getKoushinBi() {
        return koushinBi;
    }

    public void setKoushinBi(Date koushinBi) {
        this.koushinBi = koushinBi;
    }

    public String getKoushinUserid() {
        return koushinUserid;
    }

    public void setKoushinUserid(String koushinUserid) {
        this.koushinUserid = koushinUserid == null ? null : koushinUserid.trim();
    }

    public Date getTourokuBi() {
        return tourokuBi;
    }

    public void setTourokuBi(Date tourokuBi) {
        this.tourokuBi = tourokuBi;
    }

    public String getTourokuUserid() {
        return tourokuUserid;
    }

    public void setTourokuUserid(String tourokuUserid) {
        this.tourokuUserid = tourokuUserid == null ? null : tourokuUserid.trim();
    }
}