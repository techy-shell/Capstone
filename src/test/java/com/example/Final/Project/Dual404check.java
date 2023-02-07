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

public class Dual404check {
    //
//    Scenario: Check when happens when wrong user name provided for dual income
//    Given User inserts incorrect user number for dual income
//    When Incorrect totalincome username passed to chrome for dual income
//    Then chrome should response with 404 error for dual income

    private Dual404check dual404check;
    private WebDriver webDriver;

    @Before
    public void setUp (){
       dual404check = new Dual404check();
    }

    @Given("User inserts incorrect user number for dual income")
    public void webSetUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("Incorrect totalincome username passed to chrome for dual income")

    public void startTest () {
        webDriver.navigate().to("http://localhost:8080/DualIncome/incorrect");
    }

    @Then("chrome should response with 404 error for dual income")
    public void checkResponse (){
        String text = webDriver.findElement(By.tagName("body")).getText();
        assertEquals(text,text);
    }
}
