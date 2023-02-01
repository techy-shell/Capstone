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

public class FinancialCheck404 {


//    Given user passes false info
//    When passed incorrect user name to chrome
//    Then Chrome should open with 404 error
    private FinancialCheck404 financialCheck404;

    private WebDriver webDriver;

    @Before
    public void setUp(){
        financialCheck404 = new FinancialCheck404();
    }

    @Given("user passes false info")
    public void openBrowser (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("passed incorrect user name to chrome")
    public void userPassesInfo () {
        webDriver.navigate().to("http://localhost:8080/Financial/falseUserName");

    }

    @Then("Chrome should open with 404 error")
    public void checkDetails (){
        String text = webDriver.findElement(By.tagName("Body")).getText();
        assertEquals(text,text);
    }
}

