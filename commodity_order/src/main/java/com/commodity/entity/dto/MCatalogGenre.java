package com.commodity.entity.dto;

import java.util.Date;

public class MCatalogGenre extends MCatalogGenreKey {
    private String kikakuCd;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
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