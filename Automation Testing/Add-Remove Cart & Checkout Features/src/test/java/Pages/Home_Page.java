package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Home_Page {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js;

    By DesktopMenu = By.linkText("Desktops");
    By LapAndNotesMenu = By.linkText("Laptops & Notebooks");
    By ComponentsMenu = By.linkText("Components");
    By TablesMenu = By.linkText("Tablets");
    By SoftwareMenu = By.linkText("Software");
    By PhonesMenu = By.linkText("Phones & PDAs");
    By CamerasMenu = By.linkText("Cameras");
    By Mp3Menu = By.linkText("MP3 Players");

    By Desktop = By.xpath("//a[contains(text(),'Show All Desktops')]");
    By Laps = By.xpath("//a[contains(text(),'Show All Laptops')]");
    By Components = By.xpath("//a[contains(text(),'Show All Components')]");
    By Tables = By.xpath("//a[contains(text(),'Show All Tablets')]");
    By Software = By.xpath("//a[contains(text(),'Show All Software')]");
    By Phones = By.xpath("//a[contains(text(),'Show All Phones')]");
    By Cameras = By.xpath("//a[contains(text(),'Show All Cameras')]");
    By Mp3 = By.xpath("//a[contains(text(),'Show All MP3')]");

    By Air = By.xpath("//*[@id='product-list']/div[8]/div/div[2]/form/div/button[1]");
    By MacBook = By.xpath("//*[@id='product-list']/div[7]/div/div[2]/form/div/button[1]");
    By VAIO = By.xpath("//*[@id='product-list']/div[5]/div/div[2]/form/div/button[1]");
    By Pro = By.xpath("//*[@id='product-list']/div[4]/div/div[2]/form/div/button[1]");
    By SamsungGalaxy = By.xpath("//*[@id='product-list']/div/div/div[2]/form/div/button[1]");
    By iPhone = By.xpath("//*[@id='product-list']/div[2]/div/div[2]/form/div/button[1]");
    By HTC = By.xpath("//*[@id='product-list']/div[1]/div/div[2]/form/div/button[1]");
    By Nikon = By.xpath("//*[@id='product-list']/div[2]/div/div[2]/form/div/button[1]");
    By Canon = By.xpath("(//button[@aria-label='Add to Cart'])[1]");
    By iPodNano = By.xpath("//*[@id='product-list']/div[2]/div/div[2]/form/div/button[1]");
    By iPodClassic = By.xpath("//*[@id='product-list']/div[1]/div/div[2]/form/div/button[1]");

    public Home_Page(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }


    private WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void scrollIntoView(By locator) {
        WebElement el = waitVisible(locator);
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", el);

        try { Thread.sleep(250); } catch (InterruptedException ignored) {}
    }

    private void clickWithScroll(By locator) {
        scrollIntoView(locator);
        try {
            WebElement el = waitClickable(locator);
            el.click();
        } catch (Exception e) {
            WebElement el = driver.findElement(locator);
            js.executeScript("arguments[0].click();", el);
        }
    }

    public void desktop() {
        WebElement desktopMenu = waitVisible(DesktopMenu);
        actions.moveToElement(desktopMenu).perform();
        clickWithScroll(Desktop);
        waitVisible(By.id("product-list"));
        clickWithScroll(Air);
        clickWithScroll(MacBook);
    }

    public void laps() {
        WebElement lapsMenu = waitVisible(LapAndNotesMenu);
        actions.moveToElement(lapsMenu).perform();
        clickWithScroll(Laps);
        waitVisible(By.id("product-list"));
        clickWithScroll(VAIO);
        clickWithScroll(Pro);
    }

//    public void components() {
//        WebElement componentsMenu = waitVisible(ComponentsMenu);
//        actions.moveToElement(componentsMenu).perform();
//        clickWithScroll(Components);
//    }

    public void tablets() {
        WebElement tabletsMenu = waitVisible(TablesMenu);
        actions.moveToElement(tabletsMenu).perform();
        clickWithScroll(Tables);
        waitVisible(By.id("product-list"));
        clickWithScroll(SamsungGalaxy);
    }

//    public void software() {
//        WebElement softwareMenu = waitVisible(SoftwareMenu);
//        actions.moveToElement(softwareMenu).perform();
//        clickWithScroll(Software);
//    }

    public void phones() {
        WebElement phonesMenu = waitVisible(PhonesMenu);
        actions.moveToElement(phonesMenu).perform();
        clickWithScroll(Phones);
        waitVisible(By.id("product-list"));
        clickWithScroll(iPhone);
        clickWithScroll(HTC);
    }

    public void cameras() {
        WebElement camerasMenu = waitVisible(CamerasMenu);
        actions.moveToElement(camerasMenu).perform();
        clickWithScroll(Cameras);
        waitVisible(By.id("product-list"));
        clickWithScroll(Nikon);
    }

    public void mp3() {
        WebElement mp3Menu = waitVisible(Mp3Menu);
        actions.moveToElement(mp3Menu).perform();
        clickWithScroll(Mp3);
        waitVisible(By.id("product-list"));
        clickWithScroll(iPodNano);
        clickWithScroll(iPodClassic);
    }

    public void AssertionForItemsAddedToCart(){
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("Your shopping cart is empty!"), "Cart is unexpectedly empty");
    }
}