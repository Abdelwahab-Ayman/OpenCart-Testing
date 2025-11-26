package opencart.pages.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Wishlist {
    WebDriver driver;
    By wishlist_btn = By.xpath("//button[contains(text(), 'Wish List')]");
    public Wishlist(WebDriver driver){
        this.driver = driver;
    }
    public void click_WishList(){
        driver.findElement(wishlist_btn).click();
    }
    public void verify_click_wishlist(String redirectedURL){
        Assert.assertEquals(driver.getCurrentUrl(),redirectedURL);
    }
}
