package com.efinancialcareers.myefc.qa.domain;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: ilyas.patel
 * Date: 11/09/13
 * Time: 11:25
 */
public class Twitter extends OpenIdProvider implements OpenIdProviderInterface {

    /**
     * Constructor
     * @param webDriver Webdriver
     */
    public Twitter(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void click() {
        clickOn(find(By.cssSelector("#janrain-twitter a")));
    }

    @Override
    public void enterEmail(String email) {
        waitABit(WaitFor.FIVE_SECONDS.getSeconds());
        typeInto(find(By.id("username_or_email")), email);
    }

    @Override
    public void enterPassword(String password) {
        typeInto(find(By.id("password")), password);
    }

    @Override
    public void submit() {
        find(By.id("password")).submit();
    }

    @Override
    public String getProviderName() {
        return "Twitter";
    }

    @Override
    public Boolean isLinkedPasswordRequired() {
        return false;
    }

    @Override
    public Boolean isLinkedEmailRequired() {
        return true;
    }

    @Override
    public void waitForLoginModalDialogToAppear() {
        super.waitForLoginModalDialogToAppear(By.id("username_or_email"));
    }
}
