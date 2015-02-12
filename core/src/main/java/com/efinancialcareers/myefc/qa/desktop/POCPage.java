package com.efinancialcareers.myefc.qa.desktop;

import net.thucydides.core.pages.PageObject;

/**
 * Created by ilyas.patel on 28/05/2014.
 */
public class POCPage extends PageObject {

    /**
     * Go to a URL
     * @param url url
     */
    public void goTo(String url) {
        getDriver().get(url);
    }
}
