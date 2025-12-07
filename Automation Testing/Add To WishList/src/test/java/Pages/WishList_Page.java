package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.time.Duration;
public class WishList_Page {
    WebDriver driver;
    Actions actions;
    // present with static time before any actions
    private static final int TIMEOUT_SECONDS = 10;
    private By getRemoveButtonByProductName(String productName) {
    // this build a dynamic locator for add to wishlist button tied to a specific row
        return By.xpath(String.format(
                "//tr[.//a[text()='%s']]//a[@class='btn btn-danger']",
                productName
        ));
    }
    By WishList_Page = By.xpath("//a[@href=\"http://localhost/OpenCartSite/index.php?route=account/wishlist&language=en-gb\"]");
    public WishList_Page(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }
    private void scrollClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        element.click();
    }
    public void removeItem(String productName) {
        By removeLocator = getRemoveButtonByProductName(productName);
        scrollClick(removeLocator);
    }
    public void removeMacBook() {
        removeItem("MacBook");
    }

    public void removeAir() {
        removeItem("MacBook Air");
    }

    public void removePro() {
        removeItem("MacBook Pro");
    }

    public void removeVAIO() {
        removeItem("Sony VAIO");
    }

    public void removeGalaxy() {
        removeItem("Samsung Galaxy Tab 10.1");
    }

    public void removeHTC() {
        removeItem("HTC Touch HD");
    }

    public void removeiPhone() {
        removeItem("iPhone");
    }

    public void removeNikon() {
        removeItem("Nikon D300");
    }

    public void removeiPodClassic() {
        removeItem("iPod Classic");
    }

    public void removeiPodNano() {
        removeItem("iPod Nano");
    }

    public void Checkout(){
        scrollClick(WishList_Page);
    }
    public void assertWishList(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='content']"), "Your wish list is empty." ));
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Your wish list is empty."), "wish list is not empty");
    }
}
