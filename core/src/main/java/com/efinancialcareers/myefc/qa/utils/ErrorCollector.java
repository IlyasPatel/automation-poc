package com.efinancialcareers.myefc.qa.utils;

import org.hamcrest.Matcher;
import org.junit.internal.runners.model.MultipleFailureException;
import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: d.zakutalin
 * Date: 13.03.14
 * Time: 15:36
 */
public class ErrorCollector extends Verifier {

    private List<Throwable> errors = new ArrayList<Throwable>();



    @Override
    public void verify() throws Throwable {
        MultipleFailureException.assertEmpty(errors);
    }

    /**
     * Method prints all errors from collector to console output
     */
    public void printErrors(){
        for (Throwable e : errors){
           System.out.println(e.getMessage());
        }
    }

    /**
     *  Adds a failure with the given {@code reason}
     * to the table if {@code matcher} does not match {@code value}.
     * Execution continues, but the test will fail at the end if the match fails.
     * @param reason reason
     * @param value value
     * @param matcher matcher
     * @param <T>  type of the value
     */
    public <T> void checkThat(final String reason, final T value, final Matcher<T> matcher) {
        checkSucceeds(new Callable<Object>() {
            public Object call() throws Exception {
                assertThat(reason, value, matcher);
                return value;
            }
        });
    }

    /**
     * Adds a Throwable to the table.  Execution continues, but the test will fail at the end.
     * @param error Error to add
     */
    public void addError(Throwable error) {
        errors.add(error);
    }

    /**
     * Adds a failure to the table if {@code matcher} does not match {@code value}.
     * Execution continues, but the test will fail at the end if the match fails.
     * @param value value
     * @param matcher matcher
     * @param <T>  type of the value
     */

    public <T> void checkThat(final T value, final Matcher<T> matcher) {
        checkThat("", value, matcher);
    }

    /**
     * Adds to the table the exception, if any, thrown from {@code callable}.
     * Execution continues, but the test will fail at the end if
     * {@code callable} threw an exception.
     * @param callable callable
     * @return  object to call
     */

    public Object checkSucceeds(Callable<Object> callable) {
        try {
            return callable.call();
        } catch (Throwable e) {
            addError(e);
            return null;
        }
    }
}
