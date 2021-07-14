package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonActions;

public class ComparePricePage extends CommonActions {
    public ComparePricePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "_eu1pe2")
    WebElement continueButton;
    @FindBy(className = "_qs25pa")
    WebElement amount;
    public void selectContinue(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_eu1pe2")));
        CommonActions.click(continueButton);
    }
    public void getAmount(){
        System.out.println("The amount is :"+amount.getText());
    }
}
