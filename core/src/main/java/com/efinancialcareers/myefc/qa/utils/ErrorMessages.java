package com.efinancialcareers.myefc.qa.utils;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.List;

/**
 * Created by ilyas.patel on 03/06/2014.
 */
public class ErrorMessages {
    private final List<String> errorMessages;

    /**
     * Constructor
     * @param errorMessages errorMessages
     */
    public ErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(errorMessages)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj
                || (obj instanceof ErrorMessages
                && ((ErrorMessages) obj).errorMessages.equals(this.errorMessages)
            );
    }

    @Override
    public String toString() {
        return errorMessages.toString();
    }
}
