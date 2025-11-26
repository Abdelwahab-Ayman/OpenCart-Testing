
package opencart.pages.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class WishlistCheckTest {

     WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\opencart\\src\\test\\java\\opencart\\pages\\resources\\chromedriver\\chromedriver.exe"
        );

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:8080/");
    }

    @Test
    public void checkWishlistOrLoginRequired() {
        By wishlistHeaderLink = By.id("wishlist-total");
        driver.findElement(wishlistHeaderLink).click();

        
        boolean onLoginPage =
                driver.getCurrentUrl().contains("route=account/login") ||
                !driver.findElements(By.id("input-email")).isEmpty();

        if (onLoginPage) {
          
            Assert.assertTrue(
                    onLoginPage,
                    "User should be redirected to login page when opening wishlist as guest."
            );
            System.out.println("Result: Need to sign in first to view wishlist.");
        } else { 
            List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
            Assert.assertFalse(
                    rows.isEmpty(),
                    "Wishlist is empty or wishlist table not found."
            );

            String expectedProductName = "MacBook"; 
            boolean productFound = !driver.findElements(
                    By.xpath("//table//a[normalize-space(text())='" + expectedProductName + "']")
            ).isEmpty();

            Assert.assertTrue(
                    productFound,
                    "Expected product '" + expectedProductName + "' not found in wishlist."
            );

            System.out.println("Result: Wishlist is accessible and contains at least product: " + expectedProductName);
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
