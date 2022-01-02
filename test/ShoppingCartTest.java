import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartTest {
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
    public void shouldDisplayShoppingListOnHover() {
        // open main page
        // hover over cart icon
        // should display cart context menu
        // should display goToBag button
    }

    @Test
    public void shouldUpdateTotalPriceAfterIncreasingQuantity() {
        // open product details
        // add item to bag
        // open cart page
        // item should be in cart
        // save total price of item
        // add +1 item to cart
        // click on refresh cart
        // sum should be x2 of first total price
    }

    @Test
    public void shouldRemoveProductWhenQuantitySetToZero() {
        // open product details
        // add item to bag
        // open cart page
        // item should be in cart
        // save total price of item
        // subtract 1 item from cart
        // click on refresh cart
        // item should not be displayed
    }
}
