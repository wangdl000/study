package com.commodity.entity.dto;

import java.util.Date;

public class MWebLogin extends MWebLoginKey {
    private String catalogId;

    private String loginId;

    private String password;

    private String kikanJyutyuSts;

    private String kikanMukouFlg;

    private String webMukouFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId == null ? null : catalogId.trim();
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getKikanJyutyuSts() {
        return kikanJyutyuSts;
    }

    public void setKikanJyutyuSts(String kikanJyutyuSts) {
        this.kikanJyutyuSts = kikanJyutyuSts == null ? null : kikanJyutyuSts.trim();
    }

    public String getKikanMukouFlg() {
        return kikanMukouFlg;
    }

    public void setKikanMukouFlg(String kikanMukouFlg) {
        this.kikanMukouFlg = kikanMukouFlg == null ? null : kikanMukouFlg.trim();
    }

    public String getWebMukouFlg() {
        return webMukouFlg;
    }

    public void setWebMukouFlg(String webMukouFlg) {
        this.webMukouFlg = webMukouFlg == null ? null : webMukouFlg.trim();
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