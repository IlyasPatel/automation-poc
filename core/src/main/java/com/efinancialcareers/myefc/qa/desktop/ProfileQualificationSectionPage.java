package com.efinancialcareers.myefc.qa.desktop;

import com.efinancialcareers.myefc.qa.utils.fo.WaitFor;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ilyas.patel on 04/08/2014.
 */
public class ProfileQualificationSectionPage extends BasePage {

    private final String editLinkSelector = "#QUALIFICATIONS a.edit";
    private String currentQualification = "0";

    @FindBy(id = "addExperienceqa")
    private WebElementFacade addQualification;

    @FindBy(css = "#QUALIFICATIONS form a.save")
    private WebElementFacade saveLink;

    @FindBy(css = "#QUALIFICATIONS form #qualContainer div.qual")
    private List<WebElement> qualifications;

    @FindBy(css = editLinkSelector)
    private WebElementFacade editLink;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public ProfileQualificationSectionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select graduation year
     * @param graduationDate Graduation Date
     */
    public void selectGraduationYear(DateTime graduationDate) {
        if (graduationDate != null) {
            String str = "jobSeekerQualificationForms[" + currentQualification + "].graduationYear";
            super.selectFromDropdownByHTMLValueAttribute(find(By.name(str)), graduationDate.toString("yyyy"));
        }
    }

    /**
     * Check if currently studying
     * @param toPresent toPresent
     */
    public void checkCurrentlyStudying(boolean toPresent) {
        if (toPresent) {
            String str = "jobSeekerQualificationForms[" + currentQualification + "].toPresent";
            clickOn(find(By.name(str)));
        }
    }

    /**
     * Click add qualification
     */
    public void clickAddQualification() {
        clickOn(addQualification);
    }

    protected void waitForTypeAHeadResponse() {
        List<WebElement> autoCompleteList =
                (new WebDriverWait(getDriver(), WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds()))
                        .until(new ExpectedCondition<List<WebElement>>() {
                            public List<WebElement> apply(WebDriver driver) {
                                return driver.findElements(By.cssSelector("body.profile ul.ui-autocomplete"));
                            }
                        });

        new FluentWait<List<WebElement>>(autoCompleteList).
                withTimeout(WaitFor.SLA_LOCATION_TYPEAHEAD.getSeconds(), TimeUnit.SECONDS).
                until(new Function<List<WebElement>, WebElement>() {
                          @Override
                          public WebElement apply(List<WebElement> elements) {
                              for (WebElement element : elements) {
                                  if (element.getCssValue("display").contains("block")) {
                                      return element;
                                  }
                              }
                              return null; //TODO i.patel. Throw error if null is returned
                          }
                      }
                );
    }

    public void saveQualificationsDetails() {
        scrollUntilElementIsVisible(saveLink);
        clickOn(saveLink);

        waitFor(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(editLinkSelector))
        );
    }

    public void edit() {
        if (findAll(editLinkSelector).size() != 0) {
            scrollUntilElementIsVisible(editLink);
            clickOn(editLink);
        }
    }
}
