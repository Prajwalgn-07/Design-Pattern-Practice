package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.PropertyReader;
import utilities.CommonActions;

import java.io.FileNotFoundException;

public class HomePage extends CommonActions {
    public HomePage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "from.search")
    WebElement from;
    @FindBy(xpath = "//*[@id=\"stations_from\"]/div[2]/li[3]")
    WebElement leeds;
    @FindBy(xpath = "//*[@id=\"stations_to\"]/div[2]/li[8]")
    WebElement newCastle;
    @FindBy(id="return")
    WebElement returnElement;
    @FindBy(id="single")
    WebElement singleElement;
    @FindBy(id="openReturn")
    WebElement openReturnElement;
    @FindBy(id="seasons")
    WebElement seasonsElement;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[1]/div[1]/button[1]")
    WebElement today;
    @FindBy(xpath="//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[1]/div[1]/button[2]")
    WebElement tomorrow;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[2]/div[1]/button[1]")
    WebElement sameDay;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[2]/div[1]/button[2]")
    WebElement nextDay;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[1]/div[4]/div[1]/select")
    WebElement hourInOut;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[1]/div[4]/div[2]/select")
    WebElement minutesInOut;
    @FindBy(xpath="//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[2]/div[4]/div[1]/select")
    WebElement hourInReturn;
    @FindBy(xpath="//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[3]/fieldset[2]/div[4]/div[2]/select")
    WebElement minutesInReturn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/main/div[2]/div[4]/div/div/div[1]/section/form/div[5]/button")
    WebElement getTimeTickets;
    PropertyReader propertyReader=new PropertyReader();
    public void setFrom(){
        CommonActions.click(from);
        CommonActions.click(leeds);
    }
    public void setTo(){
        CommonActions.click(newCastle);
    }
    public void selectVia(){
        String via=propertyReader.getProperty("via");
        switch (via) {
            case "OneWay" -> CommonActions.click(singleElement);
            case "Return" -> CommonActions.click(returnElement);
            case "OpenReturn" -> CommonActions.click(openReturnElement);
            case "Seasons" -> CommonActions.click(seasonsElement);
            default -> CommonActions.click(singleElement);
        }
    }
    public void selectOutDay(){
        String out=propertyReader.getProperty("OUT");
        if(out.equals("today")){
            CommonActions.click(today);
        }else{
            CommonActions.click(tomorrow);
        }
    }
    public void selectReturnDay(){
        String returnDay=propertyReader.getProperty("returnDay");
        if(returnDay.equals("NextDay")){
            CommonActions.click(nextDay);
        }else{
            CommonActions.click(sameDay);
        }
    }
    public void selectTimings(){
        String outTimings=propertyReader.getProperty("outTimings");
        String[] splitOutTimings=outTimings.split(":");
        String via=propertyReader.getProperty("via");
        if(via.equals("OneWay")){
            CommonActions.select1(hourInOut,splitOutTimings[0]);
            CommonActions.select1(minutesInOut,splitOutTimings[1]);
        }
        else if(via.equals("Return")){
            String returnTimings=propertyReader.getProperty("returnTimings");
            String[] splitReturnTimings=returnTimings.split(":");
            CommonActions.select1(hourInOut,splitOutTimings[0]);
            CommonActions.select1(minutesInOut,splitOutTimings[1]);
            CommonActions.select1(hourInReturn,splitReturnTimings[0]);
            CommonActions.select1(minutesInReturn,splitReturnTimings[1]);
        }
        else if(via.equals("OpenReturn")){
            CommonActions.select1(hourInOut,splitOutTimings[0]);
            CommonActions.select1(minutesInOut,splitOutTimings[1]);
        }
    }
    public void selectGetTimings(){
        CommonActions.click(getTimeTickets);
    }
}
