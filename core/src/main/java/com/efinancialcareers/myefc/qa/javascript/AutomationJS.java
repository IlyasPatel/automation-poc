package com.efinancialcareers.myefc.qa.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by ilyas.patel on 04/03/14.
 */
public class AutomationJS {

    private JavascriptExecutor javascriptExecutor;

    private final String js = "(function (window, $) {"
            + "    var automation = {"
            + "        container: $('html, body'),"
            + "        scroll: function () {"
            + "            var e = this,"
            + "                t = this.offset().top,"
            + "                n = this.height(),"
            + "                r = $(window).height(),"
            + "                i;"
            + "            automation.scrollComplete = false;"
            + "            if (n < r) {"
            + "                i = t - (r / 2 - n / 2)"
            + "            } else {"
            + "                i = t"
            + "            }"
            + "            automation.container.animate({"
            + "                scrollTop: i"
            + "            }, 'fast', function () {"
            + "                automation.scrollComplete = true;"
            + "            });"
            + "        },"
            + "        scrollTop: function () {"
            + "            automation.container.animate({"
            + "                scrollTop: i"
            + "            }, 'fast', function () {"
            + "                automation.scrollComplete = true;"
            + "            });"
            + "        }"
            + "    };"
            + "    $.fn.automation = function (method) {"
            + "        if (typeof automation[method] === 'function') {"
            + "            return automation[method].apply(this, Array.prototype.slice.call(arguments, 1));"
            + "        }"
            + "    };"
            + "    window.automation = automation;"
            + "})(window, jQuery);";


    /**
     * Constructor
     * @param driver WebDriver
     */
    public AutomationJS(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    /**
     * Inject automation JavaScript object
     */
    public void injectAutomationObject() {
        if (!automationJSExist()) {
            javascriptExecutor.executeScript(js);
        }
    }

    private boolean automationJSExist() {
        return (Boolean) javascriptExecutor.executeScript("return typeof($.fn.automation) === 'function'");
    }
}
