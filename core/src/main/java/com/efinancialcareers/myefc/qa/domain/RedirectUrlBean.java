package com.efinancialcareers.myefc.qa.domain;

/**
 * User: ilyas.patel
 * Date: 01/11/13
 * Time: 22:22
 */
public class RedirectUrlBean {

    private String legacyUrl;
    private String expectedNewUrl;
    private String returnedNewUrl;
    private int returnedIntermediateHttpStatusCode;
    private int finalHttpStatusCode;
    private String contentLength;

    /**
     * Constructor
     */
    public RedirectUrlBean() {}

    /**
     * Constructor
     * @param legacyUrl legacyUrl
     * @param expectedNewUrl expectedNewUrl
     */
    public RedirectUrlBean(String legacyUrl, String expectedNewUrl) {
        this.legacyUrl = legacyUrl;
        this.expectedNewUrl = expectedNewUrl;
    }

    public String getLegacyUrl() {
        return legacyUrl;
    }

    public void setLegacyUrl(String legacyUrl) {
        this.legacyUrl = legacyUrl;
    }

    public String getExpectedNewUrl() {
        return expectedNewUrl;
    }

    public void setExpectedNewUrl(String expectedNewUrl) {
        this.expectedNewUrl = expectedNewUrl;
    }

    public String getReturnedNewUrl() {
        return returnedNewUrl;
    }

    public void setReturnedNewUrl(String returnedNewUrl) {
        this.returnedNewUrl = returnedNewUrl;
    }

    public int getReturnedIntermediateHttpStatusCode() {
        return returnedIntermediateHttpStatusCode;
    }

    public void setReturnedIntermediateHttpStatusCode(int returnedIntermediateHttpStatusCode) {
        this.returnedIntermediateHttpStatusCode = returnedIntermediateHttpStatusCode;
    }

    public int getFinalHttpStatusCode() {
        return finalHttpStatusCode;
    }

    public void setFinalHttpStatusCode(int finalHttpStatusCode) {
        this.finalHttpStatusCode = finalHttpStatusCode;
    }

    public String getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }
}
