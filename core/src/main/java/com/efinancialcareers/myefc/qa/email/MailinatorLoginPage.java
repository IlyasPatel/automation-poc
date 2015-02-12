package com.efinancialcareers.myefc.qa.email;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ilyas.patel on 24/09/2014.
 */
public class MailinatorLoginPage extends PageObject {

    private String textToWaitForWhenLoggedIn = "Storage Usage";

    @FindBy(id = "loginusername")
    private WebElementFacade username;

    @FindBy(id = "loginpassword")
    private WebElementFacade password;

    @FindBy(css = "btn.btn-success")
    private WebElementFacade submit;

    /**
     * Login to Mailinator
     */
    public void login() {
        if (!alreadyLoggedIn()) {
            typeInto(this.username, "eFCDevMailBox");
            typeInto(this.password, "DevEValPa88");
            clickOn(submit);

            waitABit(3000); // TODO. i.patel. temporary here to see if it is a waiting issue

            waitForTextToAppear(textToWaitForWhenLoggedIn);
        }
    }

    private boolean alreadyLoggedIn() {
        waitABit(5000); // TODO. i.patel. See if this works on CI but needs to change to something better
        return this.containsText(textToWaitForWhenLoggedIn);
    }
}
