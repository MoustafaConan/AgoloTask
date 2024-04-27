package Tests;

import Pages.ClassicPackage;
import Pages.LitePackage;
import Pages.PremiumPackage;
import Pages.SubscriptionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SubscriptionTest {
    private WebDriver driver;
    private SubscriptionPage Classic;
    private SubscriptionPage Premium;
    private SubscriptionPage Lite;

    List<SubscriptionPage> myPackages;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Page Object
        Classic = new ClassicPackage(driver);
        Premium = new PremiumPackage(driver);
        Lite = new LitePackage(driver);

        myPackages.add(Classic);
        myPackages.add(Premium);
        myPackages.add(Lite);

    }

    @Test
    public void validateSubscriptionPackages() throws IOException {
        // Navigate to the URL
            FileWriter writer = new FileWriter("package_details.txt");
            writer.write("Country is Egypt");

            for (SubscriptionPage packagePage : myPackages) {
                String packageName = packagePage.getPackageName();
                String price = packagePage.getPrice();
                String currency = packagePage.getCurrency();

                // Write details to file
                writer.write(String.format("%s - %s %s\n", packageName, price, currency));
            }

            writer.close();
        }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }
}
