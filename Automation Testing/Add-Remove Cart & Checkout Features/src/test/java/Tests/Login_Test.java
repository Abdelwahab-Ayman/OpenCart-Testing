
package Tests;

import Pages.Login_Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class Login_Test extends Test_Base {
        Login_Page loginPage;

        @BeforeClass
        public void pre() {
            driver.get("http://localhost/opencartgp/index.php?route=account/login&language=en-gb");
            loginPage = new Login_Page(driver);
        }

    @Test(priority = 1, description = "Valid login - test@gmail.com")
    public void LoginWithValidUserNameAndValidPassword() {
        loginPage.login("test@gmail.com","test123");
        loginPage.AssertionForValidLogin();

    }
}
