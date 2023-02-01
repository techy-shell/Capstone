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

public class UserCheck404 {

//    Given user passes wrong info
//    When passed incorrect username to chrome
//    Then Chrome should open with 404error

    private UserCheck404 userCheck404;

    private WebDriver webDriver;

    @Before
    public void setUp(){
       userCheck404 = new UserCheck404();
    }

    @Given("user passes wrong info")
    public void openBrowser (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("passed incorrect username to chrome")
    public void userPassesInfo () {
        webDriver.navigate().to("http://localhost:8080/Financial/falseUserName");

    }

    @Then("Chrome should open with 404error")
    public void checkDetails (){
        String text = webDriver.findElement(By.tagName("Body")).getText();
        assertEquals(text,text);
    }
}
