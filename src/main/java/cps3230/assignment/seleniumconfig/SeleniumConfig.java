package cps3230.assignment.seleniumconfig;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {
     
    public void construct() { 
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
    }

    public ChromeDriver driver() { 
        return new ChromeDriver();
    }
}

