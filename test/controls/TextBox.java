package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TextBox extends UIElement {

    public TextBox(WebDriver driver, By emailLocator) {
        super(driver, emailLocator);
    }

    public void fill(String text) {
            element().sendKeys(text);
    }

    public void fillAndConfirm(String text) { element().sendKeys(text); element().sendKeys(Keys.RETURN); }
}
