package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebTest {
    WebDriver driver;
    @BeforeTest
    public void setup()
    {
         driver= new FirefoxDriver();
    }


    @Test
     public void webTest(String[] args) {

         WebDriverWait wait= new WebDriverWait(driver, 50);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[aria-label=\"Password\"]")));
         WebElement passwordTextbox= driver.findElement(By.cssSelector("input[aria-label=\"Password\"]"));
         WebElement userNameTextbox= driver.findElement(By.cssSelector("input[aria-label=\"Username\"]"));
         WebElement loginButton= driver.findElement(By.cssSelector("flt-semantics[id=\"flt-semantic-node-6\"]"));
         userNameTextbox.click();
         userNameTextbox.sendKeys("test");
         passwordTextbox.click();
         passwordTextbox.sendKeys("test");
         loginButton.click();
         wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("flt-semantics[aria-label=\"Login Successful!\"]")));

     }

     @AfterTest
    public void closeApp()
     {
         driver.close();
     }
}