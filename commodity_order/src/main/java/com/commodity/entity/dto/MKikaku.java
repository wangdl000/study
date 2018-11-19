package com.commodity.entity.dto;

import java.util.Date;

public class MKikaku extends MKikakuKey {
    private String kikakuName;

    private String webKaisiNendo;

    private String webKaisiCyuugenSeiboKbn;

    private String webSyuryoFlg;

    private Date koushinBi;

    private String koushinUserid;

    private Date tourokuBi;

    private String tourokuUserid;

    public String getKikakuName() {
        return kikakuName;
    }

    public void setKikakuName(String kikakuName) {
        this.kikakuName = kikakuName == null ? null : kikakuName.trim();
    }

    public String getWebKaisiNendo() {
        return webKaisiNendo;
    }

    public void setWebKaisiNendo(String webKaisiNendo) {
        this.webKaisiNendo = webKaisiNendo == null ? null : webKaisiNendo.trim();
    }

    public String getWebKaisiCyuugenSeiboKbn() {
        return webKaisiCyuugenSeiboKbn;
    }

    public void setWebKaisiCyuugenSeiboKbn(String webKaisiCyuugenSeiboKbn) {
        this.webKaisiCyuugenSeiboKbn = webKaisiCyuugenSeiboKbn == null ? null : webKaisiCyuugenSeiboKbn.trim();
    }

    public String getWebSyuryoFlg() {
        return webSyuryoFlg;
    }

    public void setWebSyuryoFlg(String webSyuryoFlg) {
        this.webSyuryoFlg = webSyuryoFlg == null ? null : webSyuryoFlg.trim();
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