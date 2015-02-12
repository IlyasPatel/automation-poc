package com.efinancialcareers.myefc.qa.api;

/**
 * Created by ilyas.patel on 08/04/14.
 */
public class LatestJobDateResponse {

    private Previews[] previews;

    public long getJobRefreshDate() {
        return previews[0].getRefreshDt();
    }

    /**
     * Inner class
     */
    public class Previews {
        private long refreshDt;

        public long getRefreshDt() {
            return refreshDt;
        }
    }

}
