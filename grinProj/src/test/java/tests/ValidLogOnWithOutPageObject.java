package tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class ValidLogOnWithOutPageObject {

    WebDriver driver = new FirefoxDriver();
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void validLogOnWithOutPageObdect() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://v3.test.itpmgroup.com/login");
        logger.info("Page was opened");
        driver.findElement(By.name("_username")).clear();
        driver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        logger.info("Login was entered");
        driver.findElement(By.name("_password")).clear();
        driver.findElement(By.name("_password")).sendKeys("909090");
        logger.info("Pass was entered");
        driver.findElement(By.xpath(".//button")).click();
        logger.info("Button was clicked");

        Assert.assertTrue("Not homepage", driver.findElement(By.xpath(".//*[@class='user-image']")).isDisplayed());
        logger.info("Avatar apepared successfully");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
