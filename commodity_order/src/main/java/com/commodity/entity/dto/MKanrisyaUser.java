package com.commodity.entity.dto;

import java.util.Date;

public class MKanrisyaUser extends MKanrisyaUserKey {
    private String kanriUserPassword;

    private String kanriUserNm;

    private String svFlg;

    private String siyouKahiFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getKanriUserPassword() {
        return kanriUserPassword;
    }

    public void setKanriUserPassword(String kanriUserPassword) {
        this.kanriUserPassword = kanriUserPassword == null ? null : kanriUserPassword.trim();
    }

    public String getKanriUserNm() {
        return kanriUserNm;
    }

    public void setKanriUserNm(String kanriUserNm) {
        this.kanriUserNm = kanriUserNm == null ? null : kanriUserNm.trim();
    }

    public String getSvFlg() {
        return svFlg;
    }

    public void setSvFlg(String svFlg) {
        this.svFlg = svFlg == null ? null : svFlg.trim();
    }

    public String getSiyouKahiFlg() {
        return siyouKahiFlg;
    }

    public void setSiyouKahiFlg(String siyouKahiFlg) {
        this.siyouKahiFlg = siyouKahiFlg == null ? null : siyouKahiFlg.trim();
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