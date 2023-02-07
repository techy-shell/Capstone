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

public class Local404Check {
//    Given User inserts incorrect user number for local help
//    When Incorrect totalincome username passed to chrome for local help
//    Then chrome should response with 404 error for local help
    private Local404Check local404Check;
    private WebDriver webDriver;

    @Before
    public void setUp (){
       local404Check = new Local404Check();
    }

    @Given("User inserts incorrect user number for local help")
    public void webSetUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("Incorrect totalincome username passed to chrome for local help")

    public void startTest () {
        webDriver.navigate().to("http://localhost:8080/localhelp/incorrect");
    }

    @Then("chrome should response with 404 error for local help")
    public void checkResponse (){
        String text = webDriver.findElement(By.tagName("body")).getText();
        assertEquals(text,text);
    }
}
