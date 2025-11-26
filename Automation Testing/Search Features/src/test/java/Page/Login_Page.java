package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_Page {


/// ////////////////////////locaters////////////////////////////////
    WebDriver driver;
    By User_Name_input = By.id("input-username");
    By Password_input = By.id("input-password");
    By Login_button = By.xpath("//button[@type=\"submit\"]");
    By OpenCart_img = By.xpath("//img[@src=\"http://localhost:8080/opencart/image/catalog/opencart-logo.png\"]");

/// ////////////////////////Constructor////////////////////////////////
    public Login_Page(WebDriver driver){
        this.driver = driver;
    }

/// ////////////////////////Actions////////////////////////////////
    public void login(String username, String password){
        this.driver.findElement(this.User_Name_input).sendKeys(new CharSequence[]{username});
        this.driver.findElement(this.Password_input).sendKeys(new CharSequence[]{password});
        this.driver.findElement(this.Login_button).click();
    }

    public void Navigate(){
        this.driver.get("http://localhost:8080/opencart/testing/index.php?route=common/dashboard&user_token=f6a580fd17db9ef101cd7d62346b450d");
    }

/// ////////////////////////Assertions////////////////////////////////
    public void AssertForValidLogin(){
        Assert.assertTrue(this.driver.findElement(this.OpenCart_img).isDisplayed());
        Assert.assertEquals(this.driver.getCurrentUrl(), "http://localhost:8080/opencart/index.php?route=common/home&language=en-gb");
    }

}
