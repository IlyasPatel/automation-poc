package com.efinancialcareers.myefc.qa.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: d.zakutalin
 * Date: 25.03.14
 * Time: 11:23
 */

public class SrpResponse {

    private Response response;

    public Long getNumberOfRecordsFound() {
        return response.getNumberOfRecordsFound();
    }

    public List<Response.Doc> getDocs(){
        return Arrays.asList(response.getDocs());
    }

    /**
     * Return List of JobTitles
     *
     * @return List of JobTitles
     */
    public List<String> getJobTitlesFromSrp(){
        List<String> result = new ArrayList<String>();
        for (Response.Doc iterator : getDocs()){
            if (iterator.title_en != null){
                result.add(iterator.title_en);
            }
            if (iterator.title_de != null){
                result.add(iterator.title_de);
            }
            if (iterator.title_fr != null){
                result.add(iterator.title_fr);
            }
        }
        return result;
    }

        /**
         * Inner class
         */
    public class Response {
        private Long numFound;
        private Doc[] docs;

        private class Doc {
            // CHECKSTYLE:OFF
            private Long id;
            private String language;
            private String title_fr;
            private String title_de;
            private String title_en;
            // CHECKSTYLE:ON
        }

        public Long getNumberOfRecordsFound() {
            return numFound;
        }

        public Doc[] getDocs(){
            return docs;
        }

    }

}
