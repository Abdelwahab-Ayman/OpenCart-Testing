
package Tests;

import Pages.Checkout_Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class RemoveCart_Test extends Test_Base {
        Checkout_Page checkoutPage;

        @BeforeClass
        public void setUp() {
            checkoutPage = new Checkout_Page(driver);
            if (!driver.getCurrentUrl().contains("checkout/cart")) {
                driver.get("http://localhost/opencartgp/index.php?route=checkout/cart&language=en-gb");
            }
        }
    @Test(priority = 9, description = "Remove MacBook from Cart")
    public void RemoveMacBook() {
        checkoutPage.removeMacBook();
    }

    @Test(priority = 10, description = "Remove Air from Cart")
    public void RemoveAir() {
        checkoutPage.removeAir();
    }

    @Test(priority = 11, description = "Remove VAIO from Cart")
    public void RemoveVAIO() {
        checkoutPage.removeVAIO();
    }

    @Test(priority = 12, description = "Remove Pro Laptop from Cart")
    public void RemovePro() {
        checkoutPage.removePro();
    }

//    @Test(priority = 13, description = "Remove Samsung Galaxy from Cart")
//    public void RemoveGalaxy() {
//        checkoutPage.removeGalaxy();
//    }
//
//    @Test(priority = 14, description = "Remove HTC from Cart")
//    public void RemoveHTC() {
//        checkoutPage.removeHTC();
//    }
//
//    @Test(priority = 15, description = "Remove iPhone from Cart")
//    public void RemoveiPhone() {
//        checkoutPage.removeiPhone();
//    }
//
//    @Test(priority = 16, description = "Remove Nikon from Cart")
//    public void RemoveNikon() {
//        checkoutPage.removeNikon();
//    }

    @Test(priority = 17, description = "Remove iPod Classic from Cart")
    public void RemoveiPodClassic() {
        checkoutPage.removeiPodClassic();
    }

    @Test(priority = 18, description = "Remove iPod Nano from Cart")
    public void RemoveiPodNano() {
        checkoutPage.removeiPodNano();

    }  @Test(priority = 19, description = "Checkout to Payment")
    public void Checkout() {
        checkoutPage.Checkout();
    }

    @Test(priority = 20, description = "Verify Cart is Empty")
    public void VerifyCartEmpty() {
        checkoutPage.assertCartEmpty();
    }

}
