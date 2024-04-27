package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LitePackage extends PageBase implements SubscriptionPage {

    private final String currentPackage = "Lite Pacakge";
    private final By price = By.xpath("//*[@id='currency-lite']//b]");
    private final By Currency = By.xpath("//*[@id='currency-lite']//i]");

    public LitePackage(WebDriver driver)
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
