package pages;

import controls.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBagPage extends Page{

    private String URL = "https://lv.sportsdirect.com/cart";

    private UIElement basketHeaderText() {
        return new UIElement(driver, new By.ById("BasketHeaderText"));
    }

    private UIElement productInBag() {
        return new UIElement(driver, new By.ById("dhypProductLink"));
    }

    public MyBagPage(WebDriver driver) {
        super(driver);
    }

    public MyBagPage assertHeaderText (String text) {
        basketHeaderText().assertContains(text);
        return this;
    }

    public MyBagPage assertItemInBagText (String text) {
        productInBag().assertContains(text);
        return this;
    }
}
