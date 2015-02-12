package com.efinancialcareers.myefc.qa.desktop;

import java.util.HashMap;
import java.util.Map;

public enum FlashContext {

    /**
     * Singleton
     */
    INSTANCE;

    private Map<String, String> flash = new HashMap<>();

    public Map<String, String> getFlash() {
        return flash;
    }

    public void setFlash(Map<String, String> flash) {
        this.flash = flash;
    }

    public String getFlashValue(String key) {
        return flash.get(key);
    }

    public void setData(String key, String value) {
        flash.put(key, value);
    }

    public void clearFlash() {
        flash.clear();
    }
}
