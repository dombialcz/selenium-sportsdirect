package pages;

import controls.Button;
import controls.TextBox;
import controls.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    private String URL = "https://lv.sportsdirect.com/";

    private Button dismissModal() {
        return new Button(driver, new By.ByCssSelector("button[data-dismiss='modal']"));
    }

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
        return this;
    }

    public MainPage dismissLanguageModal() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,3000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("button[data-dismiss='modal']"
//        )));

        if ( !driver.findElements(new By.ByCssSelector("button[data-dismiss='modal']")).isEmpty() ){
            dismissModal().click();
        }
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
