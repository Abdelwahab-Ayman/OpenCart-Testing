package Test;

import Page.Login_Page;
import Page.Search_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Test_Base {

    WebDriver driver;
    Login_Page loginPage;
    Search_Page searchPage;

    @BeforeMethod
    public void preconditions(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--incognito");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        searchPage = new Search_Page(driver);
        loginPage = new Login_Page(driver);
        loginPage.Navigate();
        searchPage.OpenCartPage();
//        searchPage.NavigateSearch();

    }

    @AfterMethod
    public void EndSession(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.quit();
    }
}
