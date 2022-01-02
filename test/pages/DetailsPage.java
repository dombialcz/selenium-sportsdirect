package pages;

import controls.Button;
import controls.UIElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DetailsPage extends Page {

    private String URL = "https://www.sportsdirect.com/adidas-response-super-20-shoes-mens-212328#colcode=21232818";

    private Button sizeButton() {
        return new Button(driver, new By.ByCssSelector("#liItem"));
    }
    private Button addToBagButton() {
        return new Button(driver, new By.ByCssSelector("#aAddToBag"));
    }
    private Button myBagButton() {
        return new Button(driver, new By.ByCssSelector("#bagQuantity"));
    }
    private UIElement shoppingListWrapper() { return new UIElement(driver, new By.ByClassName("spanCheckout")); }

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public DetailsPage open(){
        driver.get(this.URL);
        dismissLanguageModal();
        return this;
    }

    public DetailsPage selectFirstSize () {
        sizeButton().click();
        return this;
    }

    public DetailsPage addToBag() {
        addToBagButton().click();
        return this;
    }

    public void goToCart() {
        myBagButton().click();
    }

    public DetailsPage openSmallShoppingList() {
        myBagButton().hover();
        return this;
    }

    public DetailsPage assertSmallShoppingListDisplayed() {
        Assert.assertTrue(shoppingListWrapper().isDisplayed());
        return this;
    }

}
