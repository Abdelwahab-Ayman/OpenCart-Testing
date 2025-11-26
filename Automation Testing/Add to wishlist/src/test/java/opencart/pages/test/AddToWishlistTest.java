package opencart.pages.test;

import opencart.pages.pagefactory.Wishlist;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToWishlistTest {

     WebDriver driver;
     Wishlist wishlistPage;

    @BeforeClass
    public void setUp() {
        // Set correct path to chromedriver.exe
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\opencart\\src\\test\\java\\opencart\\pages\\resources\\chromedriver\\chromedriver.exe"
        );

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open home (or product listing) page
        driver.get("http://127.0.0.1:8080/");
        wishlistPage = new Wishlist(driver);
    }

    @Test
    public void addToWishlist_Positive() {
        // Click on "Wish List" button
        wishlistPage.click_WishList();

        // Expected URL after clicking wishlist (adjust to your real URL)
        String expectedWishlistUrl = "http://127.0.0.1:8080/index.php?route=account/wishlist";

        // Verify URL
        wishlistPage.verify_click_wishlist(expectedWishlistUrl);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
