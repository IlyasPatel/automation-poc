package com.efinancialcareers.myefc.qa.utils.fo;

import java.util.concurrent.TimeUnit;

/**
 * User: ilyas.patel
 * Date: 30/07/13
 * Time: 11:11
 */
public enum WaitFor {
    SLA_WEB_ELEMENTS_QUICK(Long.parseLong(
            FoPropertiesLoader.getInstance().getStrProperty("SLA.web.elements.quick.in.seconds")), TimeUnit.SECONDS),
    SLA_WEB_ELEMENTS(Long.parseLong(
            FoPropertiesLoader.getInstance().getStrProperty("SLA.web.elements.in.seconds")), TimeUnit.SECONDS),
    SLA_LOCATION_TYPEAHEAD(Long.parseLong(
            FoPropertiesLoader.getInstance().getStrProperty("SLA.location.typeahead.in.seconds")), TimeUnit.SECONDS),
    SLA_RESUME_UPLOAD(Long.parseLong(
            FoPropertiesLoader.getInstance().getStrProperty("SLA.resume.upload.in.seconds")), TimeUnit.SECONDS),
    QUARTER_SECOND(250, TimeUnit.MILLISECONDS),
    HALF_SECOND(500, TimeUnit.MILLISECONDS),
    THREE_QUARTERS_SECOND(750, TimeUnit.MILLISECONDS),
    ONE_SECOND(1, TimeUnit.SECONDS),
    TWO_SECONDS(2, TimeUnit.SECONDS),
    THREE_SECONDS(3, TimeUnit.SECONDS),
    FOUR_SECONDS(4, TimeUnit.SECONDS),
    FIVE_SECONDS(5, TimeUnit.SECONDS),
    TEN_SECONDS(10, TimeUnit.SECONDS),
    THIRTY_SECONDS(30, TimeUnit.SECONDS),
    ONE_MINUTE(1, TimeUnit.MINUTES),
    TWO_MINUTES(2, TimeUnit.MINUTES),
    THREE_MINUTES(3, TimeUnit.MINUTES);

    private final long timePeriod;
    private final TimeUnit timeUnit;

    WaitFor(long timeout, TimeUnit timeUnit) {
        this.timePeriod = timeout;
        this.timeUnit = timeUnit;
    }

    private long getTimePeriod() {
        return timePeriod;
    }

    private TimeUnit getTimeUnit() {
        return timeUnit;
    }

    /**
     * Performs conversion to required TimeUnit
     * @param timeUnit TimeUnit
     * @return time
     */
    public long getTimeUnitFor(TimeUnit timeUnit) {
        return timeUnit.convert(getTimePeriod(), getTimeUnit());
    }

    public long getMilliseconds() {
        return getTimeUnitFor(TimeUnit.MILLISECONDS);
    }

    public long getSeconds() {
        return getTimeUnitFor(TimeUnit.SECONDS);
    }
}
