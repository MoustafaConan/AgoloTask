package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface SubscriptionPage {

    public String getPackageName();
    public String getPrice();
    public String getCurrency();

}
