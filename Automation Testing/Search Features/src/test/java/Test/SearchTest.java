package Test;

import Page.Search_Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends Test_Base{


    @BeforeMethod
    public void preconditions(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("http://localhost:8080/opencart/index.php?route=common/home&language=en-gb");
    }

    @Test
    public void Search(){
        this.searchPage = new Search_Page(this.driver);
        this.searchPage.ProductSearch("Macbook");
    }

    @AfterMethod
    public void EndSession(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();
   }
}
