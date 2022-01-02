package pages;

import controls.Button;
import controls.TextBox;
import controls.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    private String URL = "https://lv.sportsdirect.com/";

    private TextBox searchField() {
        return new TextBox(driver, new By.ByCssSelector("#txtSearch"));
    }

    private UIElement queryText(String text) {
        String xpath = "//*[contains(text(),'" + text + "')]";
        return new UIElement(driver, By.xpath (xpath) );
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(URL);
        dismissLanguageModal();
        return this;
    }


    public MainPage searchFor(String searchQuery){
        searchField().fillAndConfirm(searchQuery);
        return this;
    }

    public MainPage clickOnText(String text) {
        WebElement e = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        e.click();
        return this;
    }
}
