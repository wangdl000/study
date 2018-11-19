package com.commodity.entity.dto;

import java.util.Date;

public class MKikakuCodeDetail extends MKikakuCodeDetailKey {
    private String value;

    private String bikou;

    private Long sortOrder;

    private String siyouKahiFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou == null ? null : bikou.trim();
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
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