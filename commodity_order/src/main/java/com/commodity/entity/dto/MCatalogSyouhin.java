package com.commodity.entity.dto;

import java.util.Date;

public class MCatalogSyouhin extends MCatalogSyouhinKey {
    private String syouhinCd;

    private String hagakiSyouhinKigou;

    private String choiceSu;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getSyouhinCd() {
        return syouhinCd;
    }

    public void setSyouhinCd(String syouhinCd) {
        this.syouhinCd = syouhinCd == null ? null : syouhinCd.trim();
    }

    public String getHagakiSyouhinKigou() {
        return hagakiSyouhinKigou;
    }

    public void setHagakiSyouhinKigou(String hagakiSyouhinKigou) {
        this.hagakiSyouhinKigou = hagakiSyouhinKigou == null ? null : hagakiSyouhinKigou.trim();
    }

    public String getChoiceSu() {
        return choiceSu;
    }

    public void setChoiceSu(String choiceSu) {
        this.choiceSu = choiceSu == null ? null : choiceSu.trim();
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