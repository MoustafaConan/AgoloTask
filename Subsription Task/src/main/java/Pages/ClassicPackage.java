package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClassicPackage extends PageBase implements SubscriptionPage  {

    private final String currentPackage = "Classic Pacakge";
    private final By price = By.xpath("//*[@id='currency-classic']//b]");
    private final By Currency = By.xpath("//*[@id='currency-classic']//i]");

    public ClassicPackage(WebDriver driver)
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
