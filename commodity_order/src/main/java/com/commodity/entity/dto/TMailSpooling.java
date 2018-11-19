package com.commodity.entity.dto;

import java.util.Date;

public class TMailSpooling extends TMailSpoolingKey {
    private String mailAddress;

    private String mailFromAddress;

    private String mailFromName;

    private String mailReplytoAddress;

    private String mailErrortoAddress;

    private String nowSending;

    private String sended;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress == null ? null : mailAddress.trim();
    }

    public String getMailFromAddress() {
        return mailFromAddress;
    }

    public void setMailFromAddress(String mailFromAddress) {
        this.mailFromAddress = mailFromAddress == null ? null : mailFromAddress.trim();
    }

    public String getMailFromName() {
        return mailFromName;
    }

    public void setMailFromName(String mailFromName) {
        this.mailFromName = mailFromName == null ? null : mailFromName.trim();
    }

    public String getMailReplytoAddress() {
        return mailReplytoAddress;
    }

    public void setMailReplytoAddress(String mailReplytoAddress) {
        this.mailReplytoAddress = mailReplytoAddress == null ? null : mailReplytoAddress.trim();
    }

    public String getMailErrortoAddress() {
        return mailErrortoAddress;
    }

    public void setMailErrortoAddress(String mailErrortoAddress) {
        this.mailErrortoAddress = mailErrortoAddress == null ? null : mailErrortoAddress.trim();
    }

    public String getNowSending() {
        return nowSending;
    }

    public void setNowSending(String nowSending) {
        this.nowSending = nowSending == null ? null : nowSending.trim();
    }

    public String getSended() {
        return sended;
    }

    public void setSended(String sended) {
        this.sended = sended == null ? null : sended.trim();
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