package com.commodity.entity.dto;

import java.util.Date;

public class TWebJuchu extends TWebJuchuKey {
    private String postNo;

    private String jyuusyo1;

    private String jyuusyo2;

    private String jyuusyo3;

    private String kname1;

    private String kname2;

    private String kananame1;

    private String kananame2;

    private String knameHoujin;

    private String telNo;

    private String mailAddress;

    private String renkeiFlg;

    private Integer acceptMailId;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo == null ? null : postNo.trim();
    }

    public String getJyuusyo1() {
        return jyuusyo1;
    }

    public void setJyuusyo1(String jyuusyo1) {
        this.jyuusyo1 = jyuusyo1 == null ? null : jyuusyo1.trim();
    }

    public String getJyuusyo2() {
        return jyuusyo2;
    }

    public void setJyuusyo2(String jyuusyo2) {
        this.jyuusyo2 = jyuusyo2 == null ? null : jyuusyo2.trim();
    }

    public String getJyuusyo3() {
        return jyuusyo3;
    }

    public void setJyuusyo3(String jyuusyo3) {
        this.jyuusyo3 = jyuusyo3 == null ? null : jyuusyo3.trim();
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

    public String getRenkeiFlg() {
        return renkeiFlg;
    }

    public void setRenkeiFlg(String renkeiFlg) {
        this.renkeiFlg = renkeiFlg == null ? null : renkeiFlg.trim();
    }

    public Integer getAcceptMailId() {
        return acceptMailId;
    }

    public void setAcceptMailId(Integer acceptMailId) {
        this.acceptMailId = acceptMailId;
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