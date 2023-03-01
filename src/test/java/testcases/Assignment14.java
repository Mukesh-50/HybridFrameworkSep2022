package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import dataProvider.Dataprovider;
import helper.Utility;

public class Assignment14 {
	
	@Test(dataProvider ="browsers",dataProviderClass = Dataprovider.class )
	public void verifyLogin(String browser) throws InterruptedException {
		
		Reporter.log("thread Id is"+Thread.currentThread().getId(), true);
	    WebDriver driver = Utility.startBroswer(browser, "https://freelance-learn-automation.vercel.app/login");
		
	    Reporter.log("Enter email", true);
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@email.com");
	    
	    Reporter.log("Enter password", true);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin@123");
	    
	    Reporter.log("Click on sign in", true);
	    driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	    
	    Thread.sleep(2000);
	    Reporter.log("URL is::"+driver.getCurrentUrl(), true);
	    Assert.assertFalse(driver.getCurrentUrl().contains("login"));
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	    
	    driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='offcanvas-body']")));
	    
	    Reporter.log("click on logout", true);
	    driver.findElement(By.xpath("//button[text()='Sign out']")).click();
	    
	    Thread.sleep(1000);
	    Reporter.log("URL is::"+driver.getCurrentUrl(), true);
	    Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	    
	    driver.quit();
	    
		
	}

}
