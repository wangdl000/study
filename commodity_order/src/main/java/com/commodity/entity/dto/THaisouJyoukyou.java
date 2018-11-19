package com.commodity.entity.dto;

import java.util.Date;

public class THaisouJyoukyou extends THaisouJyoukyouKey {
    private String hagakiSyouhinCd;

    private String syouhinName;

    private Date todokeBi;

    private String todokeSts;

    private String syouhinHaisouCd;

    private String haisouDenpyouNo;

    private String haidenBikou;

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

    public String getSyouhinName() {
        return syouhinName;
    }

    public void setSyouhinName(String syouhinName) {
        this.syouhinName = syouhinName == null ? null : syouhinName.trim();
    }

    public Date getTodokeBi() {
        return todokeBi;
    }

    public void setTodokeBi(Date todokeBi) {
        this.todokeBi = todokeBi;
    }

    public String getTodokeSts() {
        return todokeSts;
    }

    public void setTodokeSts(String todokeSts) {
        this.todokeSts = todokeSts == null ? null : todokeSts.trim();
    }

    public String getSyouhinHaisouCd() {
        return syouhinHaisouCd;
    }

    public void setSyouhinHaisouCd(String syouhinHaisouCd) {
        this.syouhinHaisouCd = syouhinHaisouCd == null ? null : syouhinHaisouCd.trim();
    }

    public String getHaisouDenpyouNo() {
        return haisouDenpyouNo;
    }

    public void setHaisouDenpyouNo(String haisouDenpyouNo) {
        this.haisouDenpyouNo = haisouDenpyouNo == null ? null : haisouDenpyouNo.trim();
    }

    public String getHaidenBikou() {
        return haidenBikou;
    }

    public void setHaidenBikou(String haidenBikou) {
        this.haidenBikou = haidenBikou == null ? null : haidenBikou.trim();
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