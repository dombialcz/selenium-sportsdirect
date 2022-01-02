import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    // click on searchbar
    // type in shoes
    // press enter
    // expect page to load with:
        // // We found 4455 products in category shoes
    }

    @Test
    public void shouldLandOnErrorPage() {
        // click on searchbar
        // type in asdfghjkl
        // press enter
        // expect page to load with:
        // // Unfortunately there were no results for your search, but don't give up! Please check the spelling, or try using less words.
    }

    @Test
    public void shouldAutoCompleteShoesWithNike() {
        // click on searchbar
        // type in shoes
        // attempt to click on Nike Shoes text
        // expect search bar filled with Nike Shoes
    }

    @Test
    public void shouldStartAutocompleteAt2Characters() {
        // click on searchbar
        // type in sho
        // expect
        // // ul class=ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all
        // // to be visible
    }
}
