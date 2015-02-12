package com.efinancialcareers.myefc.qa.domain;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * User: ilyas.patel
 * Date: 11/09/13
 * Time: 12:28
 */
public class Google extends OpenIdProvider implements OpenIdProviderInterface {

    /**
     * Constructor
     * @param webDriver Webdriver
     */
    public Google(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void click() {
        clickOn(find(By.cssSelector("#janrain-google a")));
    }

    @Override
    public void enterEmail(String email) {
        waitABit(WaitFor.FIVE_SECONDS.getSeconds());
        typeInto(find(By.id("Email")), email);
    }

    @Override
    public void enterPassword(String password) {
        typeInto(find(By.id("Passwd")), password);
    }

    @Override
    public void submit() {
        find(By.id("Passwd")).sendKeys(Keys.RETURN);
    }

    @Override
    public String getProviderName() {
        return "Google";
    }

    @Override
    public Boolean isLinkedPasswordRequired() {
        return false;
    }

    @Override
    public Boolean isLinkedEmailRequired() {
        return false;
    }

    @Override
    public void waitForLoginModalDialogToAppear() {
        super.waitForLoginModalDialogToAppear(By.id("signIn"));
    }
}
