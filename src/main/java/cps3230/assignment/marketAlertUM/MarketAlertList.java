package cps3230.assignment.marketAlertUM;

import java.io.FilenameFilter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketAlertList {

    WebDriver driver; 
    private final String URL = "https://www.marketalertum.com/Alerts/List/";
    
    public MarketAlertList(WebDriver driver) { 
        this.driver =driver; 
        driver.get(URL);
    }

    public void checkEachAlert()  {
        WebElement parentMainElement = driver.findElement(By.xpath("//main[@role='main' and @class='pb-3']"));
        List<WebElement> listOfAlerts = parentMainElement.findElements(By.xpath("//table[@border='1']")); 
        // WebElement singleElement = listOfAlerts.get(0);

        for (WebElement alert : listOfAlerts) { 
            // String icon = alert.findElement(By.xpath("*//img[@width='100']")).getAttribute("src");
            // String heading = alert.findElement(By.xpath("*//h4")).getText();
            // String description = alert.findElement(By.xpath("*//tr[3]//td")).getText();
            // String imgSrc = alert.findElement(By.xpath("//tr[2]//td//img")).getAttribute("src");
            // String price = alert.findElement(By.xpath("*//tr[4]//td")).getText();
            // String linkToProduct = alert.findElement(By.xpath("*//tr[5]//td//a")).getAttribute("href");

            alert.findElement(By.xpath("*//img[@width='100']")).getAttribute("src"); // icon
            alert.findElement(By.xpath("*//h4")).getText(); // heading
            alert.findElement(By.xpath("*//tr[3]//td")).getText(); // description
            alert.findElement(By.xpath("//tr[2]//td//img")).getAttribute("src"); // image source
            alert.findElement(By.xpath("*//tr[4]//td")).getText(); // price
            alert.findElement(By.xpath("*//tr[5]//td//a")).getAttribute("href"); // link 
        }
    }

    public int getNumberOfAlerts() { 
        WebElement parentMainElement = driver.findElement(By.xpath("//main[@role='main' and @class='pb-3']"));
        List<WebElement> listOfAlerts = parentMainElement.findElements(By.xpath("//table[@border='1']"));
        return listOfAlerts.size();
    }

    public String getIconFileName() { 
        WebElement parentMainElement = driver.findElement(By.xpath("//main[@role='main' and @class='pb-3']"));
        List<WebElement> listOfAlerts = parentMainElement.findElements(By.xpath("//table[@border='1']"));

        String fileName = listOfAlerts.get(0).findElement(By.xpath("*//img[@width='100']")).getAttribute("src");
        return fileName.replace("/images/", "");
    }
}
