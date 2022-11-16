package cps3230.assignment.marketAlertUM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketAlertLogin {
    WebDriver driver; 
    private final String URL = "https://www.marketalertum.com/Alerts/Login";

    public MarketAlertLogin(WebDriver driver) { 
        this.driver = driver; 
        driver.get(URL);
    }

    public void inputUserID(String userID) { 
        WebElement userIDField = driver.findElement(By.xpath("//input[@id='UserId']"));
        userIDField.sendKeys(userID + Keys.ENTER);
    }
}