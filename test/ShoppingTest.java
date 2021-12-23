import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DetailsPage;
import pages.MainPage;
import pages.MyBagPage;

public class ShoppingTest {

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
    public void shouldSearchForSuperShoesAndAddToCart() throws InterruptedException {
        new MainPage(driver).open()
                .dismissLanguageModal()
                .searchFor("Super Shoes")
                .clickOnText("Response Super Mens Training Shoes");

        new DetailsPage(driver)
                .selectFirstSize()
                .addToBag()
                .goToCart();

        new MyBagPage(driver)
                .assertHeaderText("MY BAG")
                .assertItemInBagText("adidas Response Super Mens Training Shoes");
    }

}
