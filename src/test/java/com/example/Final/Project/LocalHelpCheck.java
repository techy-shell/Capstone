package com.example.Final.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalHelpCheck {

    //    Given User wants to check total income local help
//    When Details passed to chrome local help
//    Then chrome should open with correct total income for specified user local help
    private LocalHelpCheck localHelpCheck;

    private WebDriver webDriver;

    @Before
    public void setUp(){
        localHelpCheck = new LocalHelpCheck();
    }

    @Given("User wants to check total income local help")
    public void newDriver () {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("Details passed to chrome local help")
    public void checkDetails(){
        webDriver.navigate().to("http://localhost:8080/localhelp/Portsmouth");
    }

    @Then("chrome should open with correct total income for specified user local help")
    public void returnDetails(){

        String text = webDriver.findElement(By.tagName("body")).getText();
        assertEquals("[{\"supportName\":\"Hive Portsmouth\",\"description\":\"Hive can help families in many ways including a uniform share store, cost of living funding, a community helpdesk, and a directory of all other local charities. Tel. 023 9400 7124\",\"cityID\":\"Portsmouth\"}]",text);
    }
}
