package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonActions {
    public static void click(WebElement webElement) {
        webElement.click();
    }

    public static void select1(WebElement webElement, String timings) {
        Select select = new Select(webElement);
        select.selectByValue(timings);
    }

}
