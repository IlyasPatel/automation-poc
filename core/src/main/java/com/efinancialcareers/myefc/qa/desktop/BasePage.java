package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.html5.JavaScriptSessionStorage;
import com.efinancialcareers.myefc.qa.javascript.AutomationJS;
import com.efinancialcareers.myefc.qa.utils.ErrorMessages;
import com.efinancialcareers.myefc.qa.utils.ValidationUtils;
import com.efinancialcareers.myefc.qa.utils.fo.TranslationFacade;
import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.apache.commons.lang.NullArgumentException;
import org.openqa.selenium.InvalidCookieDomainException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage extends PageObject {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    /** Default explicit timeout in seconds */
    public static final String REGEX_REMOVE_NUMBER_OF_JOBS = "\\(\\d+\\)";
    public static final String DATE_REG_EXP_PATTERN = "\\d{1,2} \\D{3,5} \\d{1,2}";

    /** Used for randomisation */
    private static final int RANDOMISE = 10;

    /** Used for randomisation */
    private static final int SPLIT = 5;

    protected SessionStorage sessionStorage;

    protected static final String CLASS_NAME_DISABLED = "disabled";
    protected static final String CLASS_NAME_PREV = "prev";
    protected static final String CLASS_NAME_NEXT = "next";
    private String mainWindowHandle;

    protected final TranslationFacade translationFacade = TranslationFacade.getInstance();

    private AutomationJS automationJS;

    @FindBy(css = "#content #pageMessages div.pageMessage p")
    WebElementFacade pageMessage;

    @FindBy(css = "#pageMessages div.pageMessage p")
    private List<WebElement> pageMessages;

    @FindBy(css = "#popupContent .close")
    WebElementFacade modelBoxCloseButton;

    @FindBy(css = "#content .loginPageMessageWrapper .infoMessages")
    private WebElementFacade infoMessages;

    /**
     * Constructor
     * @param driver Webdriver
     */
    public BasePage(WebDriver driver) {
        super(driver);

        sessionStorage = new JavaScriptSessionStorage(driver);
        automationJS = new AutomationJS(driver);
    }

    /**
     * Makes browser window Full screen
     */
    @WhenPageOpens
    public void makeBrowserWindowFullScreen() {
        //getDriver().manage().window().maximize();
    }

    /**
     * Removes PagePeel - required for ChromeDriver
     */
    protected void waitForPagePeel() {
        try {
            Wait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(WaitFor.FIVE_SECONDS.getSeconds(), TimeUnit.SECONDS)
                    .pollingEvery(WaitFor.QUARTER_SECOND.getMilliseconds(), TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("dfp-jcornerBig")).getCssValue("top").equals("-1000px");
                }
            });
        } catch (TimeoutException e) {
            LOGGER.info("Page Peel already removed");
        }
    }

    /**
     * Closes company lightbox if it appears
     */
    protected void waitForCountryLightBoxToAppearAndClose() {
        try {
            Wait<WebDriver> wait = new FluentWait<>(getDriver())
                    .withTimeout(WaitFor.FIVE_SECONDS.getSeconds(), TimeUnit.SECONDS)
                    .pollingEvery(WaitFor.QUARTER_SECOND.getMilliseconds(), TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);

            Boolean isVisible = wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.cssSelector("div.popupLauncher"))
                            .getCssValue("display").equalsIgnoreCase("block");
                }
            });

            if (isVisible) {
                clickOn(find(By.cssSelector("div.popupLauncher button")));
            }

        } catch (TimeoutException e) {
            LOGGER.info("Country lightbox did not appear");
        }
    }

    /**
     * A custom click method to mainly deal with clicking on elements in the Chrome Browser
     * @param webElement WebElement
     */
    public void clickOnCustom(final WebElement webElement) {
        waitForPagePeel();

        clickOn(webElement);
    }

    /**
     * Scroll element into view and then click on it
     * @param webElement WebElement
     */
    public void clickOnWhenVisible(WebElementFacade webElement) {
        scrollUntilElementIsVisible(webElement);
        waitUntilElementHasStoppedMoving(webElement);

        clickOn(webElement);
    }

    public Object evaluateJavascript(final String script) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(script);
    }

    public Object evaluateJavascript(final String script, final Object... params) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(script, params);
    }

    /**
     * Method is here to figure out why some longer running tests sometimes work and sometimes don't.
     * Uploading several resumes is one example.
     */
    protected void naughtyWait() {
        waitABit(WaitFor.ONE_SECOND.getMilliseconds());
    }

    /**
     * Select value from dropdown box by its html value attribute.
     * @param dropdown WebElement
     * @param htmlValueAttribute HTML Value Attribute
     */
    public void selectFromDropdownByHTMLValueAttribute(final WebElement dropdown, final String htmlValueAttribute) {
        new Select(dropdown).selectByValue(htmlValueAttribute);
    }

    /**
     * Wait until more than one window open.
     */
    public void waitUntilMoreThanOneWindowOpen() {
        (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds())).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return getDriver().getWindowHandles().size() != 1;
            }
        });
    }

    /**
     * Wait until Title appears.
     */
    public void waitForTitleToAppear() {
        (new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds())).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !ValidationUtils.isEmpty(getTitle());
            }
        });
    }

    /**
     * Helper method to get all options from a select box
     * @param selectWebElement A select web element
     * @return of option elements
     */
    protected List<WebElement> getOptionFrom(WebElement selectWebElement) {
        Select select = new Select(selectWebElement);

        return select.getOptions();
    }

    /**
     * Waits until element has stopped moving
     * @param element WebElement
     */
    public void waitUntilElementHasStoppedMoving(final WebElement element) {
        waitUntilElementHasStoppedMoving(element, WaitFor.SLA_WEB_ELEMENTS_QUICK.getMilliseconds());
    }

    /**
     * Waits until element has stopped moving
     * @param element WebElement
     * @param pauseInMilliseconds Pause length before comparison in milliseconds
     */
    public void waitUntilElementHasStoppedMoving(final WebElement element, final long pauseInMilliseconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {

                Point initialLocation = ((Locatable) element).getCoordinates().inViewPort();

                waitABit(pauseInMilliseconds);

                Point finalLocation = ((Locatable) element).getCoordinates().inViewPort();

                return initialLocation.equals(finalLocation);
            }
        });
    }

    /**
     * Highlight a specified element - If you want something to stand out in reports
     * @param element WebElement
     */
    public void highlightElement(final WebElement element) {
            evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: yellow; border: 2px solid yellow;");
    }

    /**
     * Remove Highlight from a specified element
     * @param element WebElement
     */
    public void unHighlightElement(final WebElement element) {
        evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", element, "");
    }

    /**
     * Refresh page
     */
    public void refreshPage() {
        getDriver().navigate().refresh();
        waitForAJAXToComplete();
    }

    /**
     * Delete all cookies
     */
    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    /**
     * Delete session storage
     */
    public void deleteSessionStorage() {
        sessionStorage.clear();
    }

    /**
     * Scroll until element provided has stopped moving
     * @param element WebElement
     */
    public void scrollUntilElementIsVisible(final WebElement element) {

        automationJS.injectAutomationObject();

        evaluateJavascript("$(arguments[0]).automation(arguments[1]);", element, "scroll");

        waitFor(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean isVisible = (Boolean) evaluateJavascript("return automation.scrollComplete;");

                if (isVisible) {
                    return true;
                }

                return isVisible;
            }
        });
    }

    /**
     * Scroll to the top of the page
     */
    public void scrollTop() {
        scrollUntilElementIsVisible(find(By.tagName("body")));
    }

    /**
     * Scroll down a page until element has stopped moving
     */
    public void scrollBottom() {
        scrollUntilElementIsVisible(find(By.tagName("footer")));
        waitABit(WaitFor.ONE_SECOND.getMilliseconds());
    }

    /**
     * Print text to console
     * @param anything Any object
     */
    public void print(Object anything) {
        System.out.println(anything);
    }

    /**
     * Wait for AJAX to complete
     */
    public void waitForAJAXToComplete() {
        WebDriverWait wait = new WebDriverWait(getDriver(), WaitFor.SLA_WEB_ELEMENTS.getSeconds());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) evaluateJavascript("return jQuery.active == 0");
            }
        });
    }

    /**
     * Wait for JainRain to appear
     */
    public void waitForJanrain() {
        waitABit(3000L);
        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("janrainEngageEmbed")));
    }

    /**
     * Wait for SRP Overlay to disappear
     */
    public void waitForSRPOverlayToComplete() {

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(WaitFor.SLA_WEB_ELEMENTS.getSeconds(), TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            WebElement blockedOverlay = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.className("blockOverlay"));
                }
            });

            Wait<WebDriver> wait2 = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(WaitFor.SLA_WEB_ELEMENTS.getSeconds(), TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait2.until(ExpectedConditions.stalenessOf(blockedOverlay));
        } catch (TimeoutException e) {
            System.out.println("SRP Overlay error - do nothing. TimeoutException cannot be suppressed");
        }
    }

    /**
     * Used for decision making to choose between buttons, links which perform the same action
     * @return true or false
     */
    public boolean fiftyFifty() {

        Random random = new Random();

        return random.nextInt(RANDOMISE) < SPLIT;
    }

    /**
     * Get all cookies
     * @return Set of Cookies
     */
    public Set<Cookie> getCookies() {
        waitABit(WaitFor.FOUR_SECONDS.getSeconds());
        // TODO i.patel. Find a better way to wait for cookies to initialise
        return getDriver().manage().getCookies();
    }

    /**
     * Get current URL
     * @return Current URL
     */
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    /**
     * Get site preference from session storage
     * @return Site preference value
     */
    public String getSitePreferenceFromSessionStorage() {
        return sessionStorage.getItem("countrySelectorModalShown");
    }

    /**
     * Get apply for job sentence
     * @return job title sentence during applying for a job flow and user is not logged in
     */
    public String getApplyForJobSentence() {
        return infoMessages.getTextValue();
    }

    /**
     * Explicit wait for a single element using By selector
     * @param timeOutInSeconds Timeout in seconds
     * @param by Any By element
     * @return A WebElement
     */
    protected WebElement explicitlyWaitForElementBy(long timeOutInSeconds, final By by) {
        return (new WebDriverWait(getDriver(), timeOutInSeconds))
            .until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
    }

    /**
     * Explicit wait for a several elements using By selector
     * @param timeOutInSeconds Timeout in seconds
     * @param by Any By element
     * @return A WebElement
     */
    protected List<WebElement> explicitlyWaitForElementsBy(long timeOutInSeconds, final By by) {
        return (new WebDriverWait(getDriver(), timeOutInSeconds))
            .until(new ExpectedCondition<List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(by);
                }
            });
    }

    /**
     * Return one of elements from the list
     * @param webElements list of Webelements
     * @return A WebElement
     */
    protected WebElement getRandomWebElementFromList(List<WebElement> webElements){
        int random = (int) (Math.random() * webElements.size());

        return webElements.get(random);
    }

    /**
     * Explicit wait for an element
     * @param timeSec Timeout in seconds
     * @return A WebElementFacade
     */
    protected WebElementFacade explicitWaitElement(long timeSec, WebElementFacade element) {
        return $((new WebDriverWait(getDriver(), timeSec)).ignoring(
                WebDriverException.class).until(
                ExpectedConditions.visibilityOf(element)));
    }

    /**
     * POC click event for Chrome. "Element not clickable at point" issue. Use as a last resort.
     * @param element WebElement
     */
    public void clickChrome(final WebElement element) {

        evaluateJavascript("var evt = document.createEvent('MouseEvents');"
                + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                + "arguments[0].dispatchEvent(evt);", element);

        withAction().click(element).perform();
    }

    /**
     * Clicks hyperlink by partial Text
     * @param partialText Text to much by
     */
    public void clickLinkByPartialText(String partialText) {
        String xpathLocator = String.format("(//a[contains(text(), '%s')])[1]",
                partialText);
        WebElementFacade partialLinkElement = find(By.xpath(xpathLocator));
        (new Actions(getDriver())).moveToElement(partialLinkElement).click().perform();
    }

    /**
     * Clicks hyperlink by link Text
     * @param text text
     */
    public void clickLinkByText(String text) {
        clickOn(find(By.linkText(text)));
    }

    /**
     * Check if link is available
     * @param linkText linkText
     * @return true false
     */
    public boolean isLinkTextDisplayed(String linkText) {
        return find(By.linkText(linkText)).isPresent();
    }

    public String getPageMessage() {
        return pageMessage.getText().trim();
    }

    protected void switchToFrame(String nameOrId) {
        getDriver().switchTo().frame(nameOrId);
    }

    protected void switchToFrame(WebElement element) {
        getDriver().switchTo().frame(element);
    }

    /**
     * Switch to new opened window
     */
    public void switchToCurrentWindow() {
        mainWindowHandle = getDriver().getWindowHandle();
        waitUntilMoreThanOneWindowOpen();
        Set<String> windowHandles = getDriver().getWindowHandles();

        getDriver().switchTo().window(
                Iterables.getLast(windowHandles)
        );
    }

    /**
     * When using switchToCurrentWindow in some cases you may want to switch back to parent window e.g. openId Login
     */
    public void switchToPreviousWindow() {
        try {
            getDriver().switchTo().window(mainWindowHandle);
        } catch (NoSuchWindowException e) {
            System.out.println("NoSuchWindowException when switching windows.");
        }

    }

    /**
     * Return Description meta tag value
     * @return formatted String
     */
    public String getDescriptionMetaTag() {
        return (String) evaluateJavascript("return $('meta[name=description]').attr('content');");
    }

    /**
     * Close browser and go back to url (no previous cookies)
     */
    public void closeBrowserAndGoBackToUrlWithCookiesCleared() {
        String currentBrowserUrl = getCurrentUrl();
        getDriver().close();
        openAt(currentBrowserUrl);
        deleteAllCookies();
        refreshPage();
    }

    /**
     * Close browser
     */
    public void closeBrowser() {
        getDriver().close();
    }

    /**
     * Inject cookies into browser
     * @param cookies Cookies
     */
    public void injectCookies(Set<Cookie> cookies) {
        deleteAllCookies();
        for (Cookie loadedCookie : cookies) {
            if (shouldInjectCookie(loadedCookie)) {
                try {
                    getDriver().manage().addCookie(loadedCookie);
                } catch (InvalidCookieDomainException e) {
                    System.out.println("InvalidCookieDomainException == "
                            + loadedCookie.getName() + " " + loadedCookie.getDomain());
                }
            }
        }
        refreshPage();
    }

    private boolean shouldInjectCookie(Cookie loadedCookie) {
        return !loadedCookie.getName().equalsIgnoreCase("JSESSIONID")
                && loadedCookie.getExpiry() != null;
    }

    /**
     * Close model box
     */
    public void closeUploadCVForBurningGlassModalBox() {

        naughtyWait();

        if (super.isElementVisible(By.id("popupContent"))) {
            clickOn(modelBoxCloseButton);
        }

        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.id("popupContent")));
        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("modal")));

        naughtyWait();
    }

    /**
     * Get all messages from MyEfc, for example when creating a cover letter or deleting a saved job
     * @return Page messages
     */
    public List<String> getAllPageMessages() {
        scrollTop();
        waitForAJAXToComplete();
        //TODO message is not always displayed in time add wait
        naughtyWait();
        List<String> myEfcpageMessages = new ArrayList<String>();

        for (WebElement element : pageMessages) {
             myEfcpageMessages.add(element.getText());
        }

        return myEfcpageMessages;
    }

    /**
     * Wait for URL to change to provided URL
     * @param url URL
     */
    public void waitForUrlToBe(final String url) {
        (new WebDriverWait(getDriver(), WaitFor.THIRTY_SECONDS.getSeconds()))
            .until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return driver.getCurrentUrl().equalsIgnoreCase(url);
                }
            });
    }
}
