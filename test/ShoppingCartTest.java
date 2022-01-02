import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DetailsPage;
import pages.MainPage;
import pages.MyBagPage;

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
        new DetailsPage(driver)
                .open()
                .openSmallShoppingList()
                .assertSmallShoppingListDisplayed();
    }

    @Test
    public void shouldUpdateTotalPriceAfterIncreasingQuantity() {
        DetailsPage detailsPage = new DetailsPage(driver);
        MyBagPage myBagPage = new MyBagPage(driver);

        detailsPage
                .open()
                .selectFirstSize()
                .addToBag()
                .goToCart();

        myBagPage
                .assertItemInBagText("adidas Response Super");

        float priceSingleItem = myBagPage.getPrice();

        myBagPage
                .increaseQuantity()
                .refreshBag()
                .assertPriceIsBiggerThan(priceSingleItem);
    }

    @Test
    public void shouldRemoveProductWhenQuantitySetToZero() {
        DetailsPage detailsPage = new DetailsPage(driver);
        MyBagPage myBagPage = new MyBagPage(driver);

        detailsPage
                .open()
                .selectFirstSize()
                .addToBag()
                .goToCart();

        myBagPage
                .assertItemInBagText("adidas Response Super")
                .decreaseQuantity()
                .refreshBag()
                .assertBagIsEmpty();
    }
}
