package pages;

import controls.Button;
import controls.UIElement;
import org.junit.Assert;
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

    private UIElement priceElement() { return new UIElement(driver, new By.ByCssSelector("td.itemtotalprice > span.money")); }

    private UIElement emptyMessage() { return new UIElement(driver, new By.ByClassName("AspNet-GridView-Empty")); }

    private Button increaseQuantityButton() { return new Button(driver, new By.ByClassName("s-basket-plus-button")); }

    private Button decreaseQuantityButton() { return new Button(driver, new By.ByClassName("s-basket-minus-button")); }

    private Button refreshButton() {
        return new Button(driver, new By.ById("lbtnUpdateQtyAndVariants"));
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

    public float getPrice(){
        return Float.parseFloat( priceElement().getText().replaceAll("[^\\d.]", ""));
    }

    public MyBagPage increaseQuantity() {
        increaseQuantityButton().click();
        return this;
    }

    public MyBagPage decreaseQuantity() {
        decreaseQuantityButton().click();
        return this;
    }

    public MyBagPage refreshBag () {
        refreshButton().click();
        return this;
    }

    public MyBagPage assertPriceIsBiggerThan(float expectedPrice) {
        Assert.assertTrue(expectedPrice < getPrice());
        return this;
    }

    public MyBagPage assertPriceIsLowerThan(float expectedPrice) {
        Assert.assertTrue(expectedPrice > getPrice());
        return this;
    }

    public MyBagPage assertBagIsEmpty() {
        Assert.assertTrue(emptyMessage().isDisplayed());
        return this;
    }


}
