package com.efinancialcareers.myefc.qa.domain;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: d.zakutalin
 * Date: 04.03.14
 * Time: 13:12
 */
public class LinkedIn extends OpenIdProvider implements OpenIdProviderInterface {

    /**
     * Constructor
     * @param webDriver Webdriver
     */
    public LinkedIn(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void click() {
        clickOn(find(By.cssSelector("#janrain-linkedin a")));
    }

    @Override
    public void enterEmail(String email) {
        waitABit(WaitFor.FIVE_SECONDS.getSeconds());
        typeInto(find(By.name("session_key")), email);
    }

    @Override
    public void enterPassword(String password) {
        typeInto(find(By.name("session_password")), password);
    }

    @Override
    public void submit() {
        find(By.name("session_password")).sendKeys(Keys.RETURN);
    }

    @Override
    public String getProviderName() {
        return "LinkedIn";
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
        super.waitForLoginModalDialogToAppear(By.id("session_key-oauthAuthorizeForm"));
    }
}
