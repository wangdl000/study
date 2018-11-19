package com.commodity.entity.dto;

import java.util.Date;

public class MCourse extends MCourseKey {
    private String twoChoiceFlg;

    private String threeChoiceFlg;

    private String webCourseHyoujiName;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getTwoChoiceFlg() {
        return twoChoiceFlg;
    }

    public void setTwoChoiceFlg(String twoChoiceFlg) {
        this.twoChoiceFlg = twoChoiceFlg == null ? null : twoChoiceFlg.trim();
    }

    public String getThreeChoiceFlg() {
        return threeChoiceFlg;
    }

    public void setThreeChoiceFlg(String threeChoiceFlg) {
        this.threeChoiceFlg = threeChoiceFlg == null ? null : threeChoiceFlg.trim();
    }

    public String getWebCourseHyoujiName() {
        return webCourseHyoujiName;
    }

    public void setWebCourseHyoujiName(String webCourseHyoujiName) {
        this.webCourseHyoujiName = webCourseHyoujiName == null ? null : webCourseHyoujiName.trim();
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