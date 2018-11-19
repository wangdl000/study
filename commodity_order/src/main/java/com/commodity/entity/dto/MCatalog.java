package com.commodity.entity.dto;

import java.util.Date;

public class MCatalog extends MCatalogKey {
    private String catalogName;

    private String kikakuCd;

    private String courseCd;

    private Date catalogYuukouFrom;

    private Date catalogYuukouTo;

    private String catalogShiyouNen;

    private String cyuugenSeiboKbn;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getKikakuCd() {
        return kikakuCd;
    }

    public void setKikakuCd(String kikakuCd) {
        this.kikakuCd = kikakuCd == null ? null : kikakuCd.trim();
    }

    public String getCourseCd() {
        return courseCd;
    }

    public void setCourseCd(String courseCd) {
        this.courseCd = courseCd == null ? null : courseCd.trim();
    }

    public Date getCatalogYuukouFrom() {
        return catalogYuukouFrom;
    }

    public void setCatalogYuukouFrom(Date catalogYuukouFrom) {
        this.catalogYuukouFrom = catalogYuukouFrom;
    }

    public Date getCatalogYuukouTo() {
        return catalogYuukouTo;
    }

    public void setCatalogYuukouTo(Date catalogYuukouTo) {
        this.catalogYuukouTo = catalogYuukouTo;
    }

    public String getCatalogShiyouNen() {
        return catalogShiyouNen;
    }

    public void setCatalogShiyouNen(String catalogShiyouNen) {
        this.catalogShiyouNen = catalogShiyouNen == null ? null : catalogShiyouNen.trim();
    }

    public String getCyuugenSeiboKbn() {
        return cyuugenSeiboKbn;
    }

    public void setCyuugenSeiboKbn(String cyuugenSeiboKbn) {
        this.cyuugenSeiboKbn = cyuugenSeiboKbn == null ? null : cyuugenSeiboKbn.trim();
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