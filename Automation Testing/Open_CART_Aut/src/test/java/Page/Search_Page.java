package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.lang.model.element.Name;

public class Search_Page {
    WebDriver driver;

////////////////////////Locators////////////////////////
    By Search_Icon = By.xpath("//input[@type=\"text\"]");
    By Search_Button = By.xpath("//button[@type=\"submit\"]");



////////////////////////constructors////////////////////////
public Search_Page(WebDriver driver){
    this.driver = driver;
}


///////////////////////Action////////////////////////////
public void OpenCartPage(){
    this.driver.get("http://localhost:8080/opencart/");
}

public void ProductSearch(String ProductName){
        this.driver.findElement(this.Search_Icon).sendKeys(new CharSequence[]{ProductName});
        this.driver.findElement(this.Search_Button).click();
    }
//    public void NavigateSearch(){
//        this.driver.get("http://localhost:8080/opencart/index.php?route=product/search&language=en-gb&search=MacBook");
//    }


//////////////////////ASSERTION//////////////////////////

}
