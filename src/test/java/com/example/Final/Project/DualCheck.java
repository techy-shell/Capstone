package com.example.Final.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class DualCheck {

//    Scenario: Check total income returns correct figure for dual income
//    Given User wants to check total income for dual income
//    When Details passed to chrome for dual income
//    Then chrome should open with correct total income for specified user for dual income



    private DualCheck dualCheck;

    private WebDriver webDriver;

    @Before
    public void setUp(){
        dualCheck = new DualCheck();
    }

    @Given("User wants to check total income for dual income")
    public void openBrowser (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("Details passed to chrome for dual income")
    public void userPassesInfo () {
        webDriver.navigate().to("http://localhost:8080/DualIncome/100005/100006");

    }

    @Then("chrome should open with correct total income for specified user for dual income")
    public void checkDetails (){
        String text = webDriver.findElement(By.tagName("Body")).getText();
        assertEquals("[{\"dualIncome\":4600}]",text);
    }
}
