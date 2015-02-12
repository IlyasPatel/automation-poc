package com.efinancialcareers.jbehave.qa;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

/**
 * Created by ilyas.patel on 20/02/14.
 */
public class AppiumTest {

    private WebDriver driver;

    @FindBy(css = "#quickSearchPage .mainContent ul.three li .login")
    private WebElementFacade loginTab;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "iPhone Simulator");
        capabilities.setCapability("version", "7.0");
        capabilities.setCapability("app", "safari");

        //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new FirefoxDriver();
    }

    @Test
    public void run() throws InterruptedException {
        driver.get("https://m.efinancialcareers.com/us/");

        selectSignInTab();
        enterUsername();
        enterPassword();

        selectPanel();

        logout();
    }

    private void logout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.ignoreConfirm=true;");

        WebElement logoutLink = driver.findElement(By.cssSelector("#panel .logout"));

        logoutLink.click();
    }

    private void selectSignInTab() throws InterruptedException {
        driver.findElement(By.cssSelector("#quickSearchPage .mainContent ul.three li .login")).click();
        Thread.sleep(5000L);
        //waitForOverlayToFinish();
    }

    private void enterUsername() {
        driver.findElement(By.id("email")).sendKeys("ipatel@dice.com");
    }

    private void enterPassword() {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("testing123");
        password.submit();
    }

    public void selectPanel() throws InterruptedException {
        //waitForRenderedElements(By.name("keywords"));
        Thread.sleep(6000L);
        driver.findElement(By.cssSelector("header a[rel='panel']")).click();
    }

    @After
    public void tearDown() {
        //driver.close();
       // driver.quit();
    }
}
