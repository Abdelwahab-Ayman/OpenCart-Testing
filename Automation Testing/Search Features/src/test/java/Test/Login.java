package Test;

import Page.Login_Page;
import Page.Search_Page;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends Test_Base{


//    @BeforeMethod
//    public void preconditions(){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @Test
    public void SuccessLogin(){
        this.loginPage = new Login_Page(this.driver);
//        this.searchPage = new Search_Page(this.driver);
        this.loginPage.login("admin","admin");
    }
}



