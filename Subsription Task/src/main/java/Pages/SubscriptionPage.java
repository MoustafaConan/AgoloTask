package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubscriptionPage {
    private WebDriver driver;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSubscriptionPackages() {
        return driver.findElements(By.className("plan-names"));
    }

    public String getPackageName(WebElement packageElement) {
        return packageElement.findElement(By.className("plan-title")).getText().trim();
    }

    public String getTypeAndPrice(WebElement packageElement) {
        WebElement infoFlag = packageElement.findElement(By.className("info-flag"));
        return (infoFlag != null) ? infoFlag.getText().trim() : "Not available";
    }
}
