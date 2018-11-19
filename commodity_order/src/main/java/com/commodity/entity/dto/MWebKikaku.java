package com.commodity.entity.dto;

import java.util.Date;

public class MWebKikaku extends MWebKikakuKey {
    private String baseDirectory;

    private String hagakiSyouhinCdSplit;

    private String hagakiSyouhinCdFormat;

    private String toiawaseYuukouFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getBaseDirectory() {
        return baseDirectory;
    }

    public void setBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory == null ? null : baseDirectory.trim();
    }

    public String getHagakiSyouhinCdSplit() {
        return hagakiSyouhinCdSplit;
    }

    public void setHagakiSyouhinCdSplit(String hagakiSyouhinCdSplit) {
        this.hagakiSyouhinCdSplit = hagakiSyouhinCdSplit == null ? null : hagakiSyouhinCdSplit.trim();
    }

    public String getHagakiSyouhinCdFormat() {
        return hagakiSyouhinCdFormat;
    }

    public void setHagakiSyouhinCdFormat(String hagakiSyouhinCdFormat) {
        this.hagakiSyouhinCdFormat = hagakiSyouhinCdFormat == null ? null : hagakiSyouhinCdFormat.trim();
    }

    public String getToiawaseYuukouFlg() {
        return toiawaseYuukouFlg;
    }

    public void setToiawaseYuukouFlg(String toiawaseYuukouFlg) {
        this.toiawaseYuukouFlg = toiawaseYuukouFlg == null ? null : toiawaseYuukouFlg.trim();
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