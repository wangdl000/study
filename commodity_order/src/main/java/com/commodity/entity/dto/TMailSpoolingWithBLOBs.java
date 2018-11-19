package com.commodity.entity.dto;

public class TMailSpoolingWithBLOBs extends TMailSpooling {
    private String mailTitle;

    private String mailContent;

    private String mailCcAddress;

    private String mailBccAddress;

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle == null ? null : mailTitle.trim();
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent == null ? null : mailContent.trim();
    }

    public String getMailCcAddress() {
        return mailCcAddress;
    }

    public void setMailCcAddress(String mailCcAddress) {
        this.mailCcAddress = mailCcAddress == null ? null : mailCcAddress.trim();
    }

    public String getMailBccAddress() {
        return mailBccAddress;
    }

    public void setMailBccAddress(String mailBccAddress) {
        this.mailBccAddress = mailBccAddress == null ? null : mailBccAddress.trim();
    }
}