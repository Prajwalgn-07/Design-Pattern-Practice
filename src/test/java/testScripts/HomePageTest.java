package testScripts;

import Pages.ComparePricePage;
import Pages.HomePage;
import Pages.OptionsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testScripts.BaseTest;

import java.io.FileNotFoundException;

public class HomePageTest extends BaseTest {
HomePage homePage;
ComparePricePage comparePricePage;
OptionsPage optionsPage;
public HomePageTest() throws FileNotFoundException {
    super();
}

    @BeforeMethod
public void setup() throws FileNotFoundException {
    initialization();
    homePage=new HomePage(driver);
    comparePricePage=new ComparePricePage(driver);
    optionsPage=new OptionsPage(driver);
}


    @Test
public void test(){
    homePage.setFrom();
    homePage.setTo();
    homePage.selectVia();
    homePage.selectOutDay();
    homePage.selectReturnDay();
    homePage.selectTimings();
    homePage.selectGetTimings();
    comparePricePage.selectContinue(driver);
    comparePricePage.getAmount();
}

    @AfterMethod
public void tearDown(){
    driver.quit();
}
}
