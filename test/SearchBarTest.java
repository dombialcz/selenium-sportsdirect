import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class SearchBarTest {
    private static ChromeDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void shouldSearchForShoes() {
        new MainPage(driver)
                .open()
                .searchFor("shoes")
                .assertCategorySearched("shoes"); // "We found 4455 products in category shoes"
    }

    @Test
    public void shouldLandOnErrorPage() {
        new MainPage(driver)
                .open()
                .searchFor("asdfghjkl")
                .assertSearchHeaderTitleContains("Ooops.....");
    }

    @Test
    public void shouldAutoCompleteShoesWithNike() {
        new MainPage(driver)
                .open()
                .useAutocompleteFromText("Nike S")
                .searchConfirm()
                .assertCategorySearched("Nike Shoes");
    }

    @Test
    public void shouldStartAutocompleteAt2Characters() {
        new MainPage(driver)
                .open()
                .useAutocompleteFromText("s")
                .assertAutocompleteNotDisplayed()
                .useAutocompleteFromText("h")
                .assertAutocompleteIsDisplayed();
    }
}
