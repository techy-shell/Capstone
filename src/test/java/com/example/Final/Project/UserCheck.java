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

public class UserCheck {

//    Given user wants to check user/ user number name
//    When passed username to chrome
//    Then Chrome should open with correct users details

    private UserCheck userCheck;

    private WebDriver webDriver;

    @Before
    public void setUp(){
        userCheck = new UserCheck();
    }

    @Given("user wants to check or use user name")
    public void openBrowser (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("passed username to chrome")
    public void userPassesInfo () {
        webDriver.navigate().to("http://localhost:8080/User/100003");

    }

    @Then("Chrome should open with correct users details")
    public void checkDetails (){
        String text = webDriver.findElement(By.tagName("Body")).getText();
        assertEquals(text,text);
    }
}
