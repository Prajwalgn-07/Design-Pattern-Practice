package testScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertyReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    Properties properties=new Properties();
    public static WebDriver driver;

    /**
     * This constructor will load the websiteDetails property
     * file
     * @throws FileNotFoundException
     */
    public BaseTest() throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("/Users/prajwal/Desktop/testvagrant /assignment projects/Design-Pattern-Practice/src/test/java/properties/websiteDetails.properties");
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method initializes the driver and the browser required
     * and accepts the cookies at the start of the page
     */
    public void initialization(){
        String browser=properties.getProperty("browser");
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(driver,10);

        //Accepting cookies
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"onetrust-button-group\"]/div")));
        driver.findElement(By.xpath("//*[@id=\"onetrust-button-group\"]/div")).click();
    }
}
