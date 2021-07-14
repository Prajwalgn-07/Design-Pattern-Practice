package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertyReader;
import utilities.CommonActions;

import java.io.FileNotFoundException;

public class OptionsPage extends CommonActions {
    public OptionsPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver,this);
    }
    PropertyReader propertyReader=new PropertyReader();
    @FindBy(className = "_qs25pa")
    WebElement yes;
    @FindBy(className = "_274bwu5")
    WebElement no;
    @FindBy(className = "_eulpe2")
    WebElement continueButton;

    /**
     * This will select yes and no for reserve seat based on
     * user requirement
     * @param driver
     */
    public void selectReserveSeat(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_qs25pa")));
    String reserveSeat=propertyReader.getProperty("reserveSeat");
    if(reserveSeat.equals("yes")){
        CommonActions.click(yes);
    }
    else if(reserveSeat.equals("no")){
        CommonActions.click(no);
    }
}

    /**
     * This method will click on the continue button
     * @param driver
     */
    public void selectContinue(WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_eulpe2")));
    CommonActions.click(continueButton);
}
}
