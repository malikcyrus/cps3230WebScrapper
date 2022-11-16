package cps3230.assignment.marketAlertUM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketAlertList {

    WebDriver driver; 
    private final String URL = "https://www.marketalertum.com/Alerts/List/";
    WebElement parentMainElement; 
    List<WebElement> listOfAlerts; 

    public MarketAlertList(WebDriver driver) { 
        this.driver =driver; 
    }

    public void viewAlerts() { 
        driver.get(URL);
        parentMainElement = driver.findElement(By.xpath("//main[@role='main' and @class='pb-3']"));
        listOfAlerts = parentMainElement.findElements(By.xpath("//table[@border='1']")); 
    }

    public void checkIcon() { 
        for(WebElement alert : listOfAlerts) { 
            alert.findElement(By.xpath("*//img[@width='100']")).getAttribute("src"); // icon
        }
    }

    public void checkHeading() { 
        for(WebElement alert : listOfAlerts) { 
            alert.findElement(By.xpath("*//h4")).getText(); // heading
        }
    }

    public void checkDescription() {
        for(WebElement alert : listOfAlerts) {
            alert.findElement(By.xpath("*//tr[3]//td")).getText(); // description
        }
    }

    public void checkImageSource() { 
        for(WebElement alert : listOfAlerts) {
            alert.findElement(By.xpath("//tr[2]//td//img")).getAttribute("src"); // image source
        }   
    }

    public void checkPrice() { 
        for(WebElement alert : listOfAlerts) {
            alert.findElement(By.xpath("*//tr[4]//td")).getText(); // price
        }  
    }

    public void checkLinkToSource() { 
        for(WebElement alert : listOfAlerts) { 
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
        return fileName.replace("https://www.marketalertum.com/images/", "");
    }
}
