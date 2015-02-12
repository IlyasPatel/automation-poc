package com.efinancialcareers.qa.listeners;

public class AnalyticsData {

    private String json;
    private String url;

    public AnalyticsData(String json) {
        this.json = json;
    }

    public AnalyticsData(String json, String url) {
        this.json = json;
        this.url = url;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnalyticsData that = (AnalyticsData) o;

        if (json != null ? !json.equals(that.json) : that.json != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return json != null ? json.hashCode() : 0;
    }
}
