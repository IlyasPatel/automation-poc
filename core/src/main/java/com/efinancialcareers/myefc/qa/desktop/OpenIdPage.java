package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.domain.OpenIdProviderInterface;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: jon.neville
 * Date: 22/09/13
 * Time: 15:29
 */
public class OpenIdPage extends BasePage {

    private OpenIdProviderInterface openIdProvider;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public OpenIdPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select openId provider
     * @param provider provider
     * @return  OpenIdProviderInterface particular provider
     * @throws ClassNotFoundException ClassNotFoundException
     * @throws IllegalAccessException IllegalAccessException
     * @throws InstantiationException InstantiationException
     * @throws NoSuchMethodException NoSuchMethodException
     * @throws InvocationTargetException InvocationTargetException
    */
    public OpenIdProviderInterface selectProvider(String provider)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {

        String openIdClassPath = "com.efinancialcareers.myefc.qa.domain." + provider;

        Constructor constructor = Class.forName(openIdClassPath).getConstructor(WebDriver.class);
        waitForJanrain();
        openIdProvider = (OpenIdProviderInterface) constructor.newInstance(getDriver());
        openIdProvider.click();
        return openIdProvider;
    }

    /**
     * Enter openId login details.
     * @param email email
     * @param password password
     */
    public void loginWith(String email, String password) {
        // Switch to modal
        switchToCurrentWindow();
        openIdProvider.waitForLoginModalDialogToAppear();
        openIdProvider.enterEmail(email);
        openIdProvider.enterPassword(password);

        Serenity.takeScreenshot();

        openIdProvider.submit();
        openIdProvider = null;

        // Switch back to parent window
        switchToPreviousWindow();
    }
}
