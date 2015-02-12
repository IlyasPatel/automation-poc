package com.efinancialcareers.myefc.qa.utils;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.List;

/**
 * Created by ilyas.patel on 06/06/2014.
 */
public class PageMessages {
    private final List<String> messages;

    /**
     * Constructor
     * @param messages errorMessages
     */
    public PageMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(messages)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj
                || (obj instanceof PageMessages
                && ((PageMessages) obj).messages.equals(this.messages)
        );
    }

    @Override
    public String toString() {
        return messages.toString();
    }

}
