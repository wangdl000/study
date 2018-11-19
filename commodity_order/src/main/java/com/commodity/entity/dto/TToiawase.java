package com.commodity.entity.dto;

import java.util.Date;

public class TToiawase extends TToiawaseKey {
    private String toiawaseKbn;

    private String toiawaseNaiyo;

    private String kname1;

    private String kname2;

    private String kananame1;

    private String kananame2;

    private String knameHoujin;

    private String telNo;

    private String mailAddress;

    private String toiawaseNo;

    private Integer responseMailId;

    private Integer notifyMailId;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getToiawaseKbn() {
        return toiawaseKbn;
    }

    public void setToiawaseKbn(String toiawaseKbn) {
        this.toiawaseKbn = toiawaseKbn == null ? null : toiawaseKbn.trim();
    }

    public String getToiawaseNaiyo() {
        return toiawaseNaiyo;
    }

    public void setToiawaseNaiyo(String toiawaseNaiyo) {
        this.toiawaseNaiyo = toiawaseNaiyo == null ? null : toiawaseNaiyo.trim();
    }

    public String getKname1() {
        return kname1;
    }

    public void setKname1(String kname1) {
        this.kname1 = kname1 == null ? null : kname1.trim();
    }

    public String getKname2() {
        return kname2;
    }

    public void setKname2(String kname2) {
        this.kname2 = kname2 == null ? null : kname2.trim();
    }

    public String getKananame1() {
        return kananame1;
    }

    public void setKananame1(String kananame1) {
        this.kananame1 = kananame1 == null ? null : kananame1.trim();
    }

    public String getKananame2() {
        return kananame2;
    }

    public void setKananame2(String kananame2) {
        this.kananame2 = kananame2 == null ? null : kananame2.trim();
    }

    public String getKnameHoujin() {
        return knameHoujin;
    }

    public void setKnameHoujin(String knameHoujin) {
        this.knameHoujin = knameHoujin == null ? null : knameHoujin.trim();
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress == null ? null : mailAddress.trim();
    }

    public String getToiawaseNo() {
        return toiawaseNo;
    }

    public void setToiawaseNo(String toiawaseNo) {
        this.toiawaseNo = toiawaseNo == null ? null : toiawaseNo.trim();
    }

    public Integer getResponseMailId() {
        return responseMailId;
    }

    public void setResponseMailId(Integer responseMailId) {
        this.responseMailId = responseMailId;
    }

    public Integer getNotifyMailId() {
        return notifyMailId;
    }

    public void setNotifyMailId(Integer notifyMailId) {
        this.notifyMailId = notifyMailId;
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