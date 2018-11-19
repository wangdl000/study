package com.commodity.entity.dto;

import java.util.Date;

public class MKikakuCode extends MKikakuCodeKey {
    private String sikibetsuNm;

    private String codeMemo;

    private String tuikaKahiFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getSikibetsuNm() {
        return sikibetsuNm;
    }

    public void setSikibetsuNm(String sikibetsuNm) {
        this.sikibetsuNm = sikibetsuNm == null ? null : sikibetsuNm.trim();
    }

    public String getCodeMemo() {
        return codeMemo;
    }

    public void setCodeMemo(String codeMemo) {
        this.codeMemo = codeMemo == null ? null : codeMemo.trim();
    }

    public String getTuikaKahiFlg() {
        return tuikaKahiFlg;
    }

    public void setTuikaKahiFlg(String tuikaKahiFlg) {
        this.tuikaKahiFlg = tuikaKahiFlg == null ? null : tuikaKahiFlg.trim();
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