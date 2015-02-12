package com.efinancialcareers.myefc.qa.domain.enums;

/**
 * Created by ilyas.patel on 04/07/2014.
 */
public enum ContactDetails {

    CONTINENTAL_EUROPE("Europe", "sales@efinancialcareers.com", "help@efinancialcareers.com", "+ 44 (0) 207 997 7900 "),
    MIDDLE_EAST("MiddleEast", "sales@efinancialcareers.com", "help@efinancialcareers.com", "+ 44 (0) 207 997 7900 "),
    NEW_YORK("NewYork", "sales@efinancialcareers.com", "help-usa@efinancialcareers.com", "+1 866-333-4095 "),
    SINGAPORE("Singapore", "sales@efinancialcareers.com", "help@efinancialcareers.sg", "+65 6579 8000 "),
    SYDNEY("Sydney", "sales@efinancialcareers.com", "help@efinancialcareers.com.au", "(+612) 9216 7606 "),
    SHANGHAI("Shanghai", "sales@efinancialcareers.com", "help@efinancialcareers.cn", "+86 21 6032 3566 "),
    HONG_KONG("HongKong", "sales@efinancialcareers.com", "help@efinancialcareers.hk", "+852 3975 2712 "),
    LONDON("London", "sales@efinancialcareers.com", "help@efinancialcareers.com", "+44 (0)20 7997 7900 ");

    private String locationValue;
    private String salesEmail;
    private String helpDeskEmail;
    private String switchboard;

    private ContactDetails(String locationValue, String salesEmail, String helpDeskEmail, String switchboard) {
        this.locationValue = locationValue;
        this.salesEmail = salesEmail;
        this.helpDeskEmail = helpDeskEmail;
        this.switchboard = switchboard;
    }

    public String getLocationValue() {
        return locationValue;
    }

    public String getSalesEmail() {
        return salesEmail;
    }

    public String getHelpDeskEmail() {
        return helpDeskEmail;
    }

    public String getSwitchboard() {
        return switchboard;
    }
}
