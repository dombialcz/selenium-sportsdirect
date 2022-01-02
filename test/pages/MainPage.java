package pages;

import controls.Button;
import controls.TextBox;
import controls.UIElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    private String URL = "https://lv.sportsdirect.com/";

    private TextBox searchField() {
        return new TextBox(driver, new By.ByCssSelector("#txtSearch"));
    }
    private UIElement searchResultsMessage() { return new UIElement(driver, new By.ById("lblCategorySearchCopy")); }
    private UIElement searchHeaderTitle() {
        return new UIElement(driver, new By.ByClassName("searchHeadertitle"));
    }
    private UIElement autocomplete()  {
        return new UIElement(driver, new By.ByClassName("ui-autocomplete"));
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

    public MainPage searchFill(String searchQuery){
        searchField().fill(searchQuery);
        return this;
    }

    public MainPage searchConfirm(){
        searchField().confirm();
        return this;
    }

    public MainPage clickOnText(String text) {
        WebElement e = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        e.click();
        return this;
    }

    public MainPage assertCategorySearched(String categoryExpected){
        searchResultsMessage().assertContains(categoryExpected);
        return this;
    }

    public MainPage assertSearchHeaderTitleContains(String expectedTitle){
        searchHeaderTitle().assertContains(expectedTitle);
        return this;
    }

    public MainPage assertAutocompleteIsDisplayed() {
        Assert.assertTrue(autocomplete().isDisplayed());
        return this;
    }

    public MainPage assertAutocompleteNotDisplayed() {
        Assert.assertTrue(
                driver.findElements(new By.ByClassName("ui-menu-item")).isEmpty());
        return this;
    }

    public MainPage useAutocompleteFromText(String partialSearchPhrase) {
        searchField().fill(partialSearchPhrase);
        searchField().pressDown();
        searchField().pressDown();
        return this;
    }
}
