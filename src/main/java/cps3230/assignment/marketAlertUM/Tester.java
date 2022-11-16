package cps3230.assignment.marketAlertUM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String args[]) { 
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // MarketAlertHome homePage = new MarketAlertHome(driver); 
        // homePage.clickLogIn();

        MarketAlertLogin login = new MarketAlertLogin(driver);
        login.inputUserID("31a7cb0e-e0e5-4a05-9351-c074815f7b8a");

        MarketAlertList marketAlertList = new MarketAlertList(driver);
        System.out.println(marketAlertList.getIconFileName());
    }
}
