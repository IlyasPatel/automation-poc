package com.efinancialcareers.myefc.qa.html5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.SessionStorage;

import java.util.Set;

/**
 * User: ilyas.patel
 * Date: 05/12/13
 * Time: 12:02
 */
public class JavaScriptSessionStorage implements SessionStorage {

    private JavascriptExecutor js;

    /**
     * Constructor
     * @param driver WebDriver
     */
    public JavaScriptSessionStorage(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    @Override
    public String getItem(String key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", key));
    }

    @Override
    public Set<String> keySet() {
        // TODO. i.patel. Requires implementation
        return null;
    }

    @Override
    public void setItem(String key, String value) {
        js.executeScript(String.format(
                "window.sessionStorage.setItem('%s','%s');", key, value));
    }

    @Override
    public String removeItem(String key) {
        js.executeScript(String.format(
                "window.sessionStorage.removeItem('%s');", key));

        return "";
    }

    @Override
    public void clear() {
        js.executeScript(String.format("window.sessionStorage.clear();"));
    }

    @Override
    public int size() {
        return (Integer) js.executeScript("return window.sessionStorage.length;");
    }
}
