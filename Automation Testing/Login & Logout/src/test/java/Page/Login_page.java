package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_page {

        WebDriver driver;
        By UserNameInput=By.id("input-email");
        By PasswordInput=By.id("input-password");
    By LoginBtn = By.xpath("//button[text()='Login']");
    By ContinueBtn = By.xpath("//a[text()='Continue']");
    By MyAccDropDown = By.cssSelector("a[title='My Account']");
  //  By Order = By.linkText("Order History");
    By LogoutBtn = By.linkText("Logout");

//By LogoutBtn = By.xpath("//a[@href='index.php?route=account/logout' or contains(@href, 'route=account/logout')]");

        public Login_page(WebDriver driver){
            this.driver=driver;
        }
        public void Enter_User_Name(String username){
            driver.findElement(UserNameInput).sendKeys(username);

        }
        public void Enter_Password(String password){
            driver.findElement(PasswordInput).sendKeys(password);

        }
    public void Click_Login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Wait until the button is clickable
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));

            // Scroll the button into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);

            // Try normal click
            loginButton.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback: click using JavaScript if normal click fails
            WebElement loginButton = driver.findElement(LoginBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
        }
    }

    public void Click_Logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the Logout button to appear
            WebElement logoutButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(LogoutBtn)
            );

            // Scroll into view
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", logoutButton);

            // Try normal click
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        } catch (Exception e) {
            // Fallback: JS click in case normal click fails
            WebElement logoutButton = driver.findElement(LogoutBtn);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", logoutButton);
        }
    }

    public void Click_Continue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the Continue button to be visible
            WebElement continueBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(ContinueBtn)
            );

            // Scroll into view
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", continueBtn);

            // Normal click
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

        } catch (Exception e) {
            // Fallback JS click
            WebElement continueBtn = driver.findElement(ContinueBtn);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", continueBtn);
        }
    }

}
