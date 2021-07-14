package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains common actions like
 * click and select
 */
public class CommonActions {
    public static void click(WebElement webElement) {
        webElement.click();
    }

    public static void select(WebElement webElement, String timings) {
        Select select = new Select(webElement);
        select.selectByValue(timings);
    }

}
