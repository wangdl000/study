package com.commodity.entity.dto;

import java.util.Date;

public class MSyouhin extends MSyouhinKey {
    private Date todokebiYuukouFrom;

    private Date todokebiYuukouTo;

    private String hanbaiSyuuryouFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public Date getTodokebiYuukouFrom() {
        return todokebiYuukouFrom;
    }

    public void setTodokebiYuukouFrom(Date todokebiYuukouFrom) {
        this.todokebiYuukouFrom = todokebiYuukouFrom;
    }

    public Date getTodokebiYuukouTo() {
        return todokebiYuukouTo;
    }

    public void setTodokebiYuukouTo(Date todokebiYuukouTo) {
        this.todokebiYuukouTo = todokebiYuukouTo;
    }

    public String getHanbaiSyuuryouFlg() {
        return hanbaiSyuuryouFlg;
    }

    public void setHanbaiSyuuryouFlg(String hanbaiSyuuryouFlg) {
        this.hanbaiSyuuryouFlg = hanbaiSyuuryouFlg == null ? null : hanbaiSyuuryouFlg.trim();
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