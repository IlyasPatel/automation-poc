package com.efinancialcareers.qa.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Dmitry.Zakutalin
 */
public final class PatternsToMatch {
    /**
     * Constructor
     */
    private PatternsToMatch() {}

    /**
     * getPatternToMatchByLanguageForSectorCountryBreadcrumb
     * @param sector Sector
     * @param language Language
     * @param country Country
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForSectorCountryBreadcrumb(
            String sector, String language, String country) {
        if ((language.equalsIgnoreCase("en")
                || language.equalsIgnoreCase("us"))) {
            return String.format("jobs %s %s", sector, country);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("Jobs %s %s", sector, country);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("offres %s %s", sector, country);
        }
        throw new RuntimeException("No Such language: " + language);
    }

    /**
     * getPatternToMatchByLanguageForJobBreadcrumb
     * @param sector Sector
     * @param language Language
     * @param jobName JobName
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForJobBreadcrumb(
            String sector, String language, String jobName) {
        if ((language.equalsIgnoreCase("en")
                || language.equalsIgnoreCase("us"))) {
            return String.format("jobs %s %s", sector, jobName);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("Jobs %s %s", sector, jobName);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("offres %s %s", sector, jobName);
        }
        throw new RuntimeException("No Such language: " + language);
    }

    /**
     * getPatternToMatchByLanguageForSectorBreadcrumb
     * @param expectedSector Expected sector
     * @param language language
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForSectorBreadcrumb(String expectedSector, String language) {
        if (language.equalsIgnoreCase("en") || language.equalsIgnoreCase("us")) {
            return String.format("jobs %s", expectedSector);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("offres %s", expectedSector);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("Jobs %s", expectedSector);
        }
        if (language.equalsIgnoreCase("cn")) {
            return String.format("职位 %s", expectedSector);
        }
        throw new RuntimeException("No Such language: " + language);
    }

    /**
     * getPatternToMatchByLanguageForSectorTooltip
     * @param randomSectorName Random sector name
     * @param language language
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForSectorTooltip(String randomSectorName, String language) {
        if (language.equalsIgnoreCase("en") || language.equalsIgnoreCase("us")) {
            return String.format("%s jobs", randomSectorName);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("Offre(s) %s", randomSectorName);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("%s Job(s)", randomSectorName);
        }
        throw new RuntimeException("No Such language: " + language);
    }

    /**
     * getPatternToMatchByLanguageForJobTooltip
     * @param expectedJobName expectedJobName
     * @param expectedCountry expectedCountry
     * @param expectedCompany expectedCompany
     * @param language language
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForJobTooltip(
            String expectedJobName, String expectedCountry, String expectedCompany, String language) {
        if ((language.equalsIgnoreCase("en") || language.equalsIgnoreCase("us"))) {
            String cmp = expectedCompany;
            if (expectedCompany.equalsIgnoreCase("Non-disclosed")){
                cmp = cmp + " companies";
            }
            return String.format("%s in %s, %s", expectedJobName,
                    cmp, expectedCountry);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("%s : offre %s, %s", expectedCompany,
                    expectedJobName, expectedCountry);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("%s in %s, %s", expectedJobName,
                    expectedCompany, expectedCountry);
        }
        throw new RuntimeException("No Such language: " + language);
    }


    /**
     * getPatternToMatchByLanguageForJobTooltip
     * @param expectedJobName expectedJobName
     * @param expectedCountry expectedCountry
     * @param expectedCompany expectedCompany
     * @param language language
     * @param sector sector
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForJobMetaTag(String expectedJobName,
        String expectedCountry, String expectedCompany, String language, String sector) {

        if ((language.equalsIgnoreCase("en") || language.equalsIgnoreCase("us"))) {
            return String.format("%1$s, %2$s job: Apply for %3$s in %1$s, %2$s."
                    + " %4$s jobs available with eFinancialCareers.",
                    expectedCompany, expectedCountry, expectedJobName, sector);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("Offre d'emploi %1$s, %2$s : postuler à l'offre %1$s : %3$s, %2$s."
                    + " Les dernières offres dans le secteur %4$s sur eFinancialCareers.",
                    expectedCompany, expectedCountry, expectedJobName, sector);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("%1$s, %2$s Job: Bewerben Sie sich auf  %3$s von %1$s, %2$s."
                    + " %4$s auf eFinancialCareers verfügbaren Jobs.",
                    expectedCompany, expectedCountry, expectedJobName, sector);
        }
        throw new RuntimeException("No Such language: " + language);
    }

    /**
     * getPatternToMatchByLanguageForJobTooltip
     *
     * @param sector sector
     * @param language language
     * @param country country
     * @param numberOfJobs numberOfJobs
     * @param lastPostedDate lastPostedDate
     * @param locale locale
     * @return Formatted string
     */
    public static String getPatternToMatchByLanguageForSectorCountryMetaTag(String sector,
        String language, String country, int numberOfJobs, String lastPostedDate, Locale locale) {
        NumberFormat formater = NumberFormat.getInstance(locale);
        String jobs = formater.format(numberOfJobs);
        if ((language.equalsIgnoreCase("en") || language.equalsIgnoreCase("us"))) {
            return String.format("%1$s jobs in %2$s - %3$s jobs in %1$s, %2$s."
                    + " Latest job posted on %4$s. Read the job details before applying.",
                    sector, country, jobs, lastPostedDate);
        }
        if (language.equalsIgnoreCase("fr")) {
            return String.format("Offre(s) d'emploi dans le secteur %1$s, %2$s - %3$s offre(s) dans le secteur %1$s,"
                    + " %2$s. Toutes les dernières offres mises en ligne le %4$s."
                    + " Voir le détail des offres avant de postuler.",
                    sector, country, jobs, lastPostedDate);
        }
        if (language.equalsIgnoreCase("de")) {
            return String.format("%1$s Jobs von %2$s - %3$s Jobs von %1$s, %2$s. Der letzte Job wurde am %4$s"
                    + " veröffentlicht. Lesen Sie bitte die Stellenbeschreibung, bevor Sie sich bewerben.",
                    sector, country, jobs, lastPostedDate);
        }
        throw new RuntimeException("No Such language: " + language);
    }
}

