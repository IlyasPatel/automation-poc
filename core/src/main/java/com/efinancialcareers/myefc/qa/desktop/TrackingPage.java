package com.efinancialcareers.myefc.qa.desktop;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ilyas.patel on 24/10/2014.
 */
public class TrackingPage extends BasePage {

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public TrackingPage(WebDriver driver) {
        super(driver);
    }

    public void getTrackingData() {
        /*verifyDataLayerObjects(Arrays.asList(
                buildExpectedDataLayer("DataLayer-Push", "page", "/myefc/login/logged-in.html", "", "", ""),
                buildExpectedDataLayer("Rda5gy3SXCu0EwNYJ2Bp", "LOGGED_IN")
        ), false);*/

        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println(evaluateJavascript("return JSON.stringify(dataLayer)"));
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");

        /*String json = (String) evaluateJavascript("return JSON.stringify(dataLayer)");

        Gson gson = new Gson();
        AnalyticsDataLayer[] gtm = gson.fromJson(json, AnalyticsDataLayer[].class);

        String toJson = gson.toJson(gtm);
        System.out.println(toJson);*/
    }

    private void verifyDataLayerObjects(List<Map<String, Object>> expectations, boolean resetDataLayer) {
        List<Map<String, String>> dataLayer = (ArrayList<Map<String, String>>) evaluateJavascript("return dataLayer");

        boolean found;
        for (int i = 0; i < expectations.size(); i++) {
            found = false;
            for (int j = 0; j < dataLayer.size(); j++) {
                if (expectations.get(i).equals(dataLayer.get(j))) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("*** NOT ALL EXPEFCTATIONS MET ***");
            }
        }

        if (resetDataLayer) {
            evaluateJavascript("dataLayer=[];");
        }
    }

    private Map<String, Object> buildExpectedDataLayer(String userId, String registrationType) {
        Map<String, Object> ret = new HashMap<>();

        if (!userId.isEmpty()) {
            ret.put("LOGGED_IN_USER_ID", userId);
        }
        if (!registrationType.isEmpty()) {
            Map<String, Object> ret2 = new HashMap<>();
            ret2.put("TYPE", registrationType);
            ret.put("REGISTRATION_DATA", ret2);
        }

        return ret;
    }

    private Map<String, Object> buildExpectedDataLayer(String event, String type, String page, String category, String action, String label) {
        Map<String, Object> ret = new HashMap<>();

        if (!event.isEmpty()) {
            ret.put("event", event);
        }
        if (!type.isEmpty()) {
            ret.put("hit.type", type);
        }
        if (!page.isEmpty()) {
            ret.put("hit.page", page);
        }
        if (!category.isEmpty()) {
            ret.put("category", category);
        }
        if (!action.isEmpty()) {
            ret.put("hit.action", action);
        }
        if (!label.isEmpty()) {
            ret.put("hit.label", label);
        }

        return ret;
    }
}
