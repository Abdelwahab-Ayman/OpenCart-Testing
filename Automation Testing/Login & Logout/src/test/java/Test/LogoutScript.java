package Test;

import Page.Login_page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LogoutScript {
    private static final Logger log = LoggerFactory.getLogger(Test_Script.class);
    WebDriver driver;
    Login_page loginPage;

    @BeforeMethod
    public void precondition() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // FULLY disable Chrome password manager popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://localhost/opencart/index.php?route=account/login&language=en-gb");

        loginPage = new Login_page(driver);
    }

    @AfterMethod
    public void TierDown() {
      // driver.quit();
    }

    @Test
    public void logout() {

        loginPage.Enter_User_Name("nesma@gmail.com");
        loginPage.Enter_Password("123456");
        loginPage.Click_Login();
        Assert.assertTrue(true,"My Account");
        loginPage.Click_Logout();
        loginPage.Click_Continue();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencart/index.php?route=common/home&language=en-gb");

    }

}
