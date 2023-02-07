package com.example.Final.Project;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeTotalCheck {
//
//    Scenario: Check total income returns correct figure
//    Given User enters ID to return their total income
//    When Details passed to chrome
//    Then chrome should open with correct total income for specified user

    private IncomeTotalCheck incomeTotalCheck;

    private WebDriver webDriver;

    @Before
    public void setUp(){
        incomeTotalCheck = new IncomeTotalCheck();
    }

    @Given("User wants to check total income")
    public void newDriver () {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("Details passed to chrome")
    public void checkDetails(){
        webDriver.navigate().to("http://localhost:8080/TotalIncome/992211");
    }

    @Then("chrome should open with correct total income for specified user")
    public void returnDetails(){

        String text = webDriver.findElement(By.tagName("body")).getText();
        assertEquals("[{\"totalIncome\":5000}]",text);
    }
}
