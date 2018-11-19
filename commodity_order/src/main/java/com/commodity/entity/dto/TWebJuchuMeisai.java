package com.commodity.entity.dto;

import java.util.Date;

public class TWebJuchuMeisai extends TWebJuchuMeisaiKey {
    private String hagakiSyouhinCd;

    private Date todokeBi;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getHagakiSyouhinCd() {
        return hagakiSyouhinCd;
    }

    public void setHagakiSyouhinCd(String hagakiSyouhinCd) {
        this.hagakiSyouhinCd = hagakiSyouhinCd == null ? null : hagakiSyouhinCd.trim();
    }

    public Date getTodokeBi() {
        return todokeBi;
    }

    public void setTodokeBi(Date todokeBi) {
        this.todokeBi = todokeBi;
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