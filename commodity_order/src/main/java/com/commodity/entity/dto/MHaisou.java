package com.commodity.entity.dto;

import java.util.Date;

public class MHaisou extends MHaisouKey {
    private String haisouName;

    private String haisouStatusUrl;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getHaisouName() {
        return haisouName;
    }

    public void setHaisouName(String haisouName) {
        this.haisouName = haisouName == null ? null : haisouName.trim();
    }

    public String getHaisouStatusUrl() {
        return haisouStatusUrl;
    }

    public void setHaisouStatusUrl(String haisouStatusUrl) {
        this.haisouStatusUrl = haisouStatusUrl == null ? null : haisouStatusUrl.trim();
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