package cps3230.assignment.task_two;

import cps3230.assignment.marketAlertUM.MarketAlertHome;
import cps3230.assignment.marketAlertUM.MarketAlertList;
import cps3230.assignment.marketAlertUM.MarketAlertLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class websiteSteps {
    WebDriver driver = new ChromeDriver();

    MarketAlertHome homePage; 
    MarketAlertLogin loginPage;
    MarketAlertList listPage; 
    public boolean checkTrue(){ 
        return true; 
    }

    @Given("I am a user of marketlalertum")
    public void i_am_a_user_of_marketlalertum() {
        Assertions.assertTrue(checkTrue());
        // loginPage = new MarketAlertLogin(driver);
        // System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        // throw new io.cucumber.java.PendingException();
    }

    @Then("I should see my alerts")
    public void i_should_see_my_alerts() {
        loginPage.inputUserID("31a7cb0e-e0e5-4a05-9351-c074815f7b8a");
        // Write code here that turns the phrase above into concrete actions
    }
//     @Given("I am a user of marketAlertum")
//     public void userUsingmarketAlertUM() { 
//         loginPage = new MarketAlertLogin(driver);
//         System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//     }

//     @When("I login using valid credentials")
//     public void loginWithValidCredentials() { 
//         loginPage.inputUserID("31a7cb0e-e0e5-4a05-9351-c074815f7b8a");
//     }

//     @Then(" I should see my alerts")
//     public void verifyMyAlerts() { 
//         Assertions.assertEquals(driver.getCurrentUrl(), "https://www.marketalertum.com/Alerts/List");
//     }

//     @When("I login using invalid credentials")
//     public void loginWithInvalidCredentials() { 
//         loginPage.inputUserID("abcdef");
//     }

//     @Then("I should see the login screen again")
//     public void verifyLoginPage() { 
//         Assertions.assertEquals(driver.getCurrentUrl(), "https://www.marketalertum.com/Alerts/Login");
//     }
    
// }
}