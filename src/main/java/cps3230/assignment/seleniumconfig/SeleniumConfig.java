package cps3230.assignment.seleniumconfig;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {
     
    public ChromeDriver driver() { 
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}
