package cps3230.assignment;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrapperService {
    private final int alertType = 6; 
    private ChromeDriver driver; 
    private final String URL = "https://lava.mt/";
   
    public ScrapperService() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    public boolean searchItem(String itemToSearch) { 
        // input item 
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.sendKeys(itemToSearch + Keys.ENTER);

        List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@class, 'status-publish first')]"));

        if(elements.isEmpty()) return false; 
        
        elements.get(0).click();

        return true; 
    }

    public Alert scrapeElement(String item) { 

        if(!searchItem(item)){
            return null; 
        };
        
        String title = driver.findElements(By.className("product_title")).get(0).getText();
        int price = (int) Double.parseDouble(driver.findElements(By.xpath("//bdi")).get(1).getText().substring(1).replaceAll(",","")) * 100;
        String url = driver.getCurrentUrl();
        String description = driver.findElement(By.xpath("//div[@class='desc-text']/p")).getText();
        String imgUrl = driver.findElement(By.xpath("//img[@role='presentation' and @class='zoomImg']")).getAttribute("src");
        
        return new Alert(alertType, title, description, url, imgUrl, price);
    }
}