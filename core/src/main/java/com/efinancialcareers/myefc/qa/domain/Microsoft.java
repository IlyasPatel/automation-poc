package com.efinancialcareers.myefc.qa.domain;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: ilyas.patel
 * Date: 11/09/13
 * Time: 12:47
 */
public class Microsoft extends OpenIdProvider implements OpenIdProviderInterface {

    /**
     * Constructor
     * @param webDriver Webdriver
     */
    public Microsoft(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void click() {
        clickOn(find(By.cssSelector("#janrain-live_id a")));
    }

    @Override
    public void enterEmail(String email) {
        waitABit(WaitFor.FIVE_SECONDS.getSeconds());
        typeInto(find(By.name("login")), email);
    }

    @Override
    public void enterPassword(String password) {
        typeInto(find(By.name("passwd")), password);
    }

    @Override
    public void submit() {
        find(By.name("passwd")).submit();
    }

    @Override
    public String getProviderName() {
        return "Windows Live";
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
        super.waitForLoginModalDialogToAppear(By.id("idSIButton9"));
    }
}
