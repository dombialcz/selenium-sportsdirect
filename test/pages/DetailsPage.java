package pages;

import controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends Page {

    private String URL = "https://www.sportsdirect.com/searchresults?descriptionfilter=super%20shoes";

    private Button sizeButton() {
        return new Button(driver, new By.ByCssSelector("#liItem"));
    }
    private Button addToBagButton() {
        return new Button(driver, new By.ByCssSelector("#aAddToBag"));
    }
    private Button myBagButton() {
        return new Button(driver, new By.ByCssSelector("#bagQuantity"));
    }

    public DetailsPage(WebDriver driver) {
        super(driver);
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

}
