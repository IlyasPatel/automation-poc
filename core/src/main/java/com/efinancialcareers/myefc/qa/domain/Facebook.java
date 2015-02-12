package com.efinancialcareers.myefc.qa.domain;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: ilyas.patel
 * Date: 11/09/13
 * Time: 12:48
 */
public class Facebook extends OpenIdProvider implements OpenIdProviderInterface {

    /**
     * Constructor
     * @param webDriver Webdriver
     */
    public Facebook(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void click() {
        clickOn(find(By.cssSelector("#janrain-facebook a")));
    }

    @Override
    public void enterEmail(String email) {
        waitABit(WaitFor.FIVE_SECONDS.getSeconds());
        typeInto(find(By.name("email")), email);
    }

    @Override
    public void enterPassword(String password) {
        typeInto(find(By.name("pass")), password);
    }

    @Override
    public void submit() {
        find(By.name("login")).click();
    }

    @Override
    public String getProviderName() {
        return "Facebook";
    }

    @Override
    public Boolean isLinkedPasswordRequired() {
        return null;
    }

    @Override
    public Boolean isLinkedEmailRequired() {
        return null;
    }

    @Override
    public void waitForLoginModalDialogToAppear() {
        super.waitForLoginModalDialogToAppear(By.name("login"));
    }
}
