package cps3230.assignment.task_two.stepDefinitions;

import cps3230.assignment.Alert;
import cps3230.assignment.PostService;
import cps3230.assignment.ScrapperService;
import cps3230.assignment.marketAlertUM.MarketAlertHome;
import cps3230.assignment.marketAlertUM.MarketAlertList;
import cps3230.assignment.marketAlertUM.MarketAlertLogin;
import cps3230.assignment.seleniumconfig.SeleniumConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    SeleniumConfig config = new SeleniumConfig(); 
    WebDriver driver;

    MarketAlertHome homePage; 
    MarketAlertLogin loginPage;
    MarketAlertList listPage; 

    String UserID = "31a7cb0e-e0e5-4a05-9351-c074815f7b8a";

    @Given("I am a user of marketlalertum")
    public void userOfMarketalertum() { 
        driver = config.driver();
        loginPage = new MarketAlertLogin(driver);
    }

    @When("I login using valid credentials")
    public void loginUsingValidCredentials() { 
        loginPage.inputUserID(UserID);
    }

    @Then("I should see my alerts")
    public void checkAlerts() { 
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.marketalertum.com/Alerts/List");
        driver.quit();
    }

    @When("I login using invalid credentials")
    public void loginUsingInvalidCredentials() {
        loginPage.inputUserID("abcdef");
    }

    @Then("I should see the login screen again")
    public void verifyLoginScreen() { 
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.marketalertum.com/Alerts/Login");
        driver.quit();
    } 

    @Given("I am an administrator of the website and I upload {int} alerts")
    public void uploadAlerts(int arg01) throws Exception{ 

        ArrayList <Alert> alerts = new ArrayList<Alert>();
        ScrapperService scrapperService = new ScrapperService();
        PostService postService = new PostService(); 
        
         // remove previous alerts 
         postService.removeAllAlerts();

        alerts.add(scrapperService.scrapeElement("Apple leather case"));

        for(int i = 0; i < arg01; i++){
            postService.postAlerts(alerts);
        }

        scrapperService.driver.quit();
    }

    @When("I view a list of alerts")
    public void viewAlerts() { 
        listPage = new MarketAlertList(driver);
        if (driver.getCurrentUrl().equals("https://www.marketalertum.com/Alerts/Login")) {  
            loginPage.inputUserID(UserID);
        }
        listPage.viewAlerts();
    }

    @Then("each alert should contain an icon")
    public void checkEachAlertIcon() { 
        Assertions.assertDoesNotThrow(() -> listPage.checkIcon());
    }

    @And("each alert should contain a heading")
    public void checkEachAlertHeading() { 
        Assertions.assertDoesNotThrow(() -> listPage.checkHeading());
    }

    @And("each alert should contain a description")
    public void checkEachAlertDescription() { 
        Assertions.assertDoesNotThrow(() -> listPage.checkDescription());
    }

    @And("each alert should contain an image")
    public void checkEachAlertImage() { 
        Assertions.assertDoesNotThrow(() -> listPage.checkImageSource());
    }

    @And("each alert should contain a price")
    public void checkEachAlertPrice() { 
        Assertions.assertDoesNotThrow(() -> listPage.checkPrice());
    }

    @And("each alert should contain a link to the original product website")
    public void checkEachAlertLinkToProduct() { 
        Assertions.assertDoesNotThrow(() -> listPage.checkLinkToSource());
        driver.quit();
    }

    @Given("I am an administrator of the website and I upload more than {int} alerts")
    public void uploadMoreThanVisibleAlerts(int arg01) throws Exception { 

        ArrayList <Alert> alerts = new ArrayList<Alert>();
        ScrapperService scrapperService = new ScrapperService();
        PostService postService = new PostService(); 
        
        // remove previous alerts 
        postService.removeAllAlerts();
        // Assertions.assertEquals(201, null);
        
        alerts.add(scrapperService.scrapeElement("Nintendo"));

        for(int i = 0; i < arg01 + 1; i++){ 
            postService.postAlerts(alerts);
        }

        scrapperService.driver.quit();
    }

    @Then("I should see {int} alerts")
    public void verifyAlertCount(int arg01) { 
        Assertions.assertEquals(arg01, listPage.getNumberOfAlerts());
    }

    @Given("I am an administrator of the website and I upload an alert of type {int}")
    public void uploadAlertOfType(int arg01) throws Exception{
        if (driver != null) { 
            driver.quit();
        }

        ScrapperService scrapperService = new ScrapperService();
        PostService postService = new PostService(); 
        ArrayList <Alert> alerts = new ArrayList<Alert>();

        // remove previous alerts 
        postService.removeAllAlerts();

        alerts.add(scrapperService.scrapeElement("apple leather case"));
        alerts.get(0).setAlertType(arg01);
        postService.postAlerts(alerts);

        scrapperService.driver.quit();
    }

    @And("the icon displayed should be {word}")
    public void verifyIconFileName(String arg01String) { 
        Assertions.assertEquals(arg01String, listPage.getIconFileName());
        driver.quit();
    }
}
