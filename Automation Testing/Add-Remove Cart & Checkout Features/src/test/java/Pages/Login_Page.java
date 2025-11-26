package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_Page {
    WebDriver driver;
    By mail = By.id("input-email");
    By password = By.id("input-password");
    By LoginButton = By.xpath("//*[@id=\"form-login\"]/div[3]/button");

    public Login_Page(WebDriver driver){
        this.driver = driver;
    }

    public void login(String Email, String Password){
        driver.findElement(mail).sendKeys(Email);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(LoginButton).click();
    }

    public void AssertionForValidLogin(){
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/opencartgp/index.php?route=account/home&language=en-gb");
    }
}
