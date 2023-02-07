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

public class IncomeTotal404Checker {
//    Scenario: Check when happens when wrong user name provided
//    Given User inserts incorrect user number
//    When Incorrect totalincome username passed to chrome
//    Then chrome should response with 404 error

    private IncomeTotal404Checker incomeTotal404Checker;
    private WebDriver webDriver;

    @Before
    public void setUp (){
        incomeTotal404Checker = new IncomeTotal404Checker();
    }

    @Given("User inserts incorrect user number")
    public void webSetUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("Incorrect totalincome username passed to chrome")

    public void startTest () {
        webDriver.navigate().to("http://localhost:8080/TotalIncome/wrongusername");
    }

    @Then("chrome should response with 404 error")
    public void checkResponse (){
        String text = webDriver.findElement(By.tagName("body")).getText();
        assertEquals(text,text);
    }
}
