package pages;

import controls.Button;
import controls.TextBox;
import controls.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.UserLoginDetails;

public abstract class Page {


    protected WebDriver driver;
    private String URL = "https://lv.sportsdirect.com/";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public Page open(){
        driver.get(this.URL);
        return this;
    }

    private Button dismissModal() {
        return new Button(driver, new By.ByCssSelector("button[data-dismiss='modal']"));
    }

    public void dismissLanguageModal(){
//        WebDriverWait wait = new WebDriverWait(driver,3000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("button[data-dismiss='modal']"
//        )));
        if ( !driver.findElements(new By.ByCssSelector("button[data-dismiss='modal']")).isEmpty() ){
            dismissModal().click();
        }
    }

//        errorMessage().assertContains("There were errors in your submission\n" +

}
