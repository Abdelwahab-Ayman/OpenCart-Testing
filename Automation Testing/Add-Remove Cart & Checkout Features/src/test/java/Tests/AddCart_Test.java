package Tests;

import Pages.Checkout_Page;
import Pages.Home_Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddCart_Test extends Test_Base {
    Home_Page homePage;
    @BeforeClass
    public void setUp() {
        homePage = new Home_Page(driver);
        if (!driver.getCurrentUrl().contains("checkout/cart")) {
            driver.get("http://localhost/opencartgp/index.php?route=common/home&language=en-gb");
        }
    }

    @Test(priority = 2, description = "Adding Desktop Items to Cart")
    public void AddDesktop() {
        homePage.desktop();
    }

    @Test(priority = 3, description = "Adding Laps Items to Cart")
    public void AddLaps() {
        homePage.laps();
    }

    @Test(priority = 4, description = "Adding Tablets Items to Cart")
    public void AddTablets() {
        homePage.tablets();
    }

    @Test(priority = 5, description = "Adding Phones Items to Cart")
    public void AddPhones() {
        homePage.phones();
    }

    @Test(priority = 6, description = "Adding Cameras Items to Cart")
    public void AddCameras() {
        homePage.cameras();
    }

    @Test(priority = 7, description = "Adding MP3 Items to Cart")
    public void AddMp3() {
        homePage.mp3();
    }


    @Test(priority = 8, description = "Verify Items are Added to Cart")
    public void VerifyCartNotEmpty() {
        homePage.AssertionForItemsAddedToCart();
    }

}
