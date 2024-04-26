package Tests;

import Pages.SubscriptionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;

public class SubscriptionTest {
    private WebDriver driver;
    private SubscriptionPage subscriptionPage;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Page Object
        subscriptionPage = new SubscriptionPage(driver);
    }

    @Test
    public void validateSubscriptionPackages() throws IOException {
        // Navigate to the URL
        driver.get("https://subscribe.stctv.com/");

        // Validate subscription packages for 3 countries
        String result = subscriptionPage.validateSubscriptionPackages();

        // Print result in notepad
        FileWriter writer = new FileWriter("subscription_packages.txt");
        writer.write(result);
        writer.close();
    }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }
}
