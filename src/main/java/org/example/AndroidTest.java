package org.example;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AndroidTest {
      AndroidDriver driver;
    @BeforeTest
    public void setupAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("org/example/app", "/src/main/java/org/example/app/app-debug.apk");
        capabilities.setCapability("automationName", "Flutter");
         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities);

    }

    @Test
    public void androidTest()
    {
        WebDriverWait wait= new WebDriverWait(driver,50);


        WebElement passwordTextbox= driver.findElement(By.id("flt-semantic-node-6"));
        WebElement userNameTextbox= driver.findElement(By.cssSelector("input[aria-label=\"Username\"]"));
        WebElement loginButton= driver.findElement(By.cssSelector("flt-semantics[id=\"flt-semantic-node-6\"]"));
        userNameTextbox.click();
        userNameTextbox.sendKeys("test");
        passwordTextbox.click();
        passwordTextbox.sendKeys("test");
        loginButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("flt-semantics[aria-label=\"Login Successful!\"]")));
    }

}
