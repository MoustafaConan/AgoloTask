package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PremiumPackage extends PageBase implements SubscriptionPage {

    private final String currentPackage = "Premium Pacakge";
    private final By price = By.xpath("//*[@id='currency-premium']//b]");
    private final By Currency = By.xpath("//*[@id='currency-premium']//i]");

    public PremiumPackage(WebDriver driver)
        {
            super(driver);
        }

    public String getPackageName() {
        return currentPackage;
    }

    public String getPrice(){
       return getElement(price).getText();
    }

    public String getCurrency(){
        return getElement(Currency).getText();
    }


}
