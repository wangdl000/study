package com.commodity.entity.dto;

import java.util.Date;

public class MMsg extends MMsgKey {
    private String msgKeisaiKbn;

    private Date keisaiFrom;

    private Date keisaiTo;

    private String msgHeader;

    private String msgNaiyou;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getMsgKeisaiKbn() {
        return msgKeisaiKbn;
    }

    public void setMsgKeisaiKbn(String msgKeisaiKbn) {
        this.msgKeisaiKbn = msgKeisaiKbn == null ? null : msgKeisaiKbn.trim();
    }

    public Date getKeisaiFrom() {
        return keisaiFrom;
    }

    public void setKeisaiFrom(Date keisaiFrom) {
        this.keisaiFrom = keisaiFrom;
    }

    public Date getKeisaiTo() {
        return keisaiTo;
    }

    public void setKeisaiTo(Date keisaiTo) {
        this.keisaiTo = keisaiTo;
    }

    public String getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(String msgHeader) {
        this.msgHeader = msgHeader == null ? null : msgHeader.trim();
    }

    public String getMsgNaiyou() {
        return msgNaiyou;
    }

    public void setMsgNaiyou(String msgNaiyou) {
        this.msgNaiyou = msgNaiyou == null ? null : msgNaiyou.trim();
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