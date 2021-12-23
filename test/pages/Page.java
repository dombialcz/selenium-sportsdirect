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


//        errorMessage().assertContains("There were errors in your submission\n" +

}
