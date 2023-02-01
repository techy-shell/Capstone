package com.example.Final.Project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

public class FinancialCheck {

    private FinancialCheck financialCheck;

    private WebDriver webDriver;

    @Before
    public void setUp(){
        financialCheck = new FinancialCheck();
    }

    @Given("user wants to check user name")
    public void openBrowser (){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @When("passed user name to chrome")
    public void userPassesInfo () {
        webDriver.navigate().to("http://localhost:8080/Financial/992211");

    }

    @Then("Chrome should open with uses details")
        public void checkDetails (){
        String text = webDriver.findElement(By.tagName("Body")).getText();
        assertEquals("[{\"userName\":992211,\"salary\":5000,\"benefit\":0}]",text);
    }
}
