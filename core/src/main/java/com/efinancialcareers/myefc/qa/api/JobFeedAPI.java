package com.efinancialcareers.myefc.qa.api;

import com.efinancialcareers.myefc.qa.utils.fo.FoPropertiesLoader;
import net.thucydides.core.pages.PageObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: ilyas.patel
 * Date: 15/08/13
 * Time: 11:19
 */
public class JobFeedAPI extends PageObject {

    Pattern p = Pattern.compile("<ns2:refId>(.*?)</ns2:refId>");
    Pattern e = Pattern.compile("<ns2:errorType>(.*?)</ns2:errorType>");
    String jobFeedURL = FoPropertiesLoader.getInstance().getStrProperty("jobfeed.api.url");

    String jobFeedXML = "<jobFeed xsi:schemaLocation=\"http://efinancialcareers.com/schema jobfeed.xsd\" "
            + "xmlns=\"http://efinancialcareers.com/schema\" "
            + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
            + "<header>"
            + "<providerLogin>"
            + "<apiKey>eFC-e30-4c30-ba5f-294d75298dc1</apiKey>"
            + "<trustedAccountApiKey>eFC-d25-4b3c-8b04-93e54700aa7a</trustedAccountApiKey>"
            + "<password>ehcsYuMs98</password>"
            + "</providerLogin>"
            + "<allocationMethod>default</allocationMethod>"
            + "<deactivateAllJobsFirst>false</deactivateAllJobsFirst>"
            + "</header>"
            + "<jobOperations>"
            + "<jobOperation>"
            + "<operationType>POST</operationType>"
            + "<job>"
            + "<defaultDescription lang=\"EN\">"
            + "<title>{0}</title>"
            + "<description>This is a test job. Please do not apply</description>"
            + "<summary>This is a test job. Summary.</summary>"
            + "<salaryDescription>Good</salaryDescription>"
            + "<workPermitRequirements>UK Work Permit</workPermitRequirements>"
            + "</defaultDescription>"
            + "<positionType>PERMANENT</positionType>"
            + "<employmentType>FULL_TIME</employmentType>"
            + "<yearsExperience>SEVEN_TEN_YEARS_EXPERIENCE</yearsExperience>"
            + "<salaryBand>SIXTH_TIER</salaryBand>"
            + "<salaryCurrency>GBP</salaryCurrency>"
            + "<jobReference>Testjob Ref</jobReference>"
            + "<originalLocation>"
            + "<latitude>49.214169</latitude>"
            + "<longitude>-2.131237</longitude>"
            + "<locationName>Jersey, Channel Isles</locationName>"
            + "<isoCityCode/>"
            + "<isoCountryCode>GB</isoCountryCode>"
            + "<zip>JE2 4TD</zip>"
            + "</originalLocation>"
            + "<brand>"
            + "<refId>75</refId>"
            + "</brand>"
            + "<team>"
            + "<refId>92</refId>"
            + "</team>"
            + "<primarySector>"
            + "<sectorCode>DEBT_FIXED_INCOME</sectorCode>"
            + "<subSectorCode>DEBT_FIXED_INCOME__SALES_TRADING</subSectorCode>"
            + "</primarySector>"
            + "<secondarySector>"
            + "<sectorCode>CONSULTANCY</sectorCode>"
            + "<subSectorCode>CONSULTANCY__N_A</subSectorCode>"
            + "</secondarySector>"
            + "<applicationMethod>EMAIL</applicationMethod>"
            + "<autoReply>false</autoReply>"
            + "<screenQuestionnaire>false</screenQuestionnaire>"
            + "<contactDetails>"
            + "<contactFirstName>Test firstname</contactFirstName>"
            + "<contactLastName>Test lastname</contactLastName>"
            + "<contactEmail>jneville@efinancialcareers.com</contactEmail>"
            + "<contactPhone>1234566</contactPhone>"
            + "<contactFax>45353453</contactFax>"
            + "<contactCompanyName>Company JN</contactCompanyName>"
            + "<contactAddress1>12 SThree</contactAddress1>"
            + "<contactAddress2>London Road</contactAddress2>"
            + "<contactAddress3>London Street</contactAddress3>"
            + "<contactCity>London</contactCity>"
            + "<contactRegion>South East</contactRegion>"
            + "<contactPostCode>E3 4NL</contactPostCode>"
            + "<contactCountry>England</contactCountry>"
            + "<displayBrandImage>true</displayBrandImage>"
            + "</contactDetails>"
            + "</job>"
            + "</jobOperation>"
            + "</jobOperations>"
            +" </jobFeed>";


    String jobId = "";
    String jobFeedError = "";
    String jobFeedResponse = "";

    /**
     * Post job via feeds
     * @param jobTitle jobTitle
     */
    public void postJobViaFeeds(String jobTitle) {
        String output;
        StringBuilder postJobResponseBuilder = new StringBuilder();
        DefaultHttpClient httpClient1 = new DefaultHttpClient();

        String randomJobFeedXML = MessageFormat.format(jobFeedXML, jobTitle);

        try {
            HttpPost httpPostJob = new HttpPost(jobFeedURL);
            httpPostJob.setHeader("Content-Type", "application/xml");

            StringEntity input = new StringEntity(randomJobFeedXML);
            httpPostJob.setEntity(input);

            HttpResponse response = httpClient1.execute(httpPostJob);

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            while ((output = br.readLine()) != null) {
                postJobResponseBuilder.append(output);
            }

            String jobFeedsResponseResponse = postJobResponseBuilder.toString();

            Matcher m = p.matcher(jobFeedsResponseResponse);

            //JobId captured from response. Might be useful for other tests
            if (m.find()) {
                jobId = m.group(1);
            }

        } catch (UnsupportedEncodingException e) {
            Assert.fail(e.getMessage());
        } catch (ClientProtocolException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        } finally {
            httpClient1.getConnectionManager().shutdown();
        }
    }

    /**
     * Post job via feeds
     * @param jobFeedXML xml request
     * @return response message summary
     */
    public String postJobUsingFeed(String jobFeedXML) {
        String output;
        StringBuilder postJobResponseBuilder = new StringBuilder();
        DefaultHttpClient httpClient1 = new DefaultHttpClient();

        try {
            HttpPost httpPostJob = new HttpPost(jobFeedURL);
            httpPostJob.setHeader("Content-Type", "application/xml");

            StringEntity input = new StringEntity(jobFeedXML);
            httpPostJob.setEntity(input);

            HttpResponse response = httpClient1.execute(httpPostJob);

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

            while ((output = br.readLine()) != null) {
                postJobResponseBuilder.append(output);
            }

            String jobFeedsResponseResponse = postJobResponseBuilder.toString();

            Matcher m = p.matcher(jobFeedsResponseResponse);
            Matcher n = e.matcher(jobFeedsResponseResponse);

            //JobId captured or error code captured from response
            if (m.find()) {
                jobFeedResponse = m.group(1);
            } else if (n.find()) {
                jobFeedResponse = n.group(1);
            }

        } catch (UnsupportedEncodingException e) {
            Assert.fail(e.getMessage());
        } catch (ClientProtocolException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        } finally {
            httpClient1.getConnectionManager().shutdown();
        }

        return jobFeedResponse;
    }
}
