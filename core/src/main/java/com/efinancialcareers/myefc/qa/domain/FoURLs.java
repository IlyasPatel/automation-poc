package com.efinancialcareers.myefc.qa.domain;

public enum FoURLs {

    SAVED_JOBS("myefc/jobs"),

    APPLICATION_HISTORY("myefc/application-history"),

    LINK_ACCOUNTS_REGISTRATION("login/link-accounts/new"),

    PROFILE("myefc/profile"),

    NEWSLETTERS("myefc/newsletters"),

    ACCOUNT_SETTINGS("myefc/account"),

    REGISTRATION("login/register"),

    DOCUMENT_LIBRARY("myefc/docs/cvs"),

    SITE_MAP("sitemap/html");

    private String path;

    FoURLs(final String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
