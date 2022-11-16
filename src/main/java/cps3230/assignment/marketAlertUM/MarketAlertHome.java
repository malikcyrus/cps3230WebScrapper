package cps3230.assignment.marketAlertUM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketAlertHome {
    
    WebDriver driver; 
    private final String URL = "https://www.marketalertum.com/";

    public MarketAlertHome(WebDriver driver) { 
        this.driver =driver; 
        driver.get(URL);
    }

    public void clickHome() { 
        WebElement home = driver.findElement(By.xpath("//a[@href='/']"));
        home.click(); 
    }

    public void clickMyAlerts() { 
        WebElement myAlerts = driver.findElement(By.xpath("//a[@href='/Alerts/List']"));
        myAlerts.click(); 
    }

    public void clickLogIn() { 
        WebElement login = driver.findElement(By.xpath("//a[@href='/Alerts/Login']"));
        login.click(); 
    }
}
