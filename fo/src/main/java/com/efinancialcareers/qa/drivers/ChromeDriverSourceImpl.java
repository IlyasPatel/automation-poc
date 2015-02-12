package com.efinancialcareers.qa.drivers;

import com.efinancialcareers.qa.utils.ValidationUtils;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverSourceImpl implements DriverSource {

    @Override
    public WebDriver newDriver() {

        //String remoteDriverUrl = FoPropertiesLoader.getInstance().getStrProperty("remoteDriverUrl");
        String remoteDriverUrl = "";

        if (!ValidationUtils.isEmpty(remoteDriverUrl)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
            MyRemoteWebDriver remoteWebDriver = null;

            try {
                remoteWebDriver = new MyRemoteWebDriver(new URL(remoteDriverUrl), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(remoteWebDriver);

            //AnalyticsEventListener eventListener = new AnalyticsEventListener(remoteWebDriver);
            //eventFiringWebDriver.register(eventListener);

            return eventFiringWebDriver;
        } else {
            ChromeDriver chromeDriver = new ChromeDriver();
            EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(chromeDriver);

            //AnalyticsEventListener analyticsEventListener = new AnalyticsEventListener(chromeDriver);
            //eventFiringWebDriver.register(analyticsEventListener);

            Serenity.initializeTestSession();

            return eventFiringWebDriver;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
