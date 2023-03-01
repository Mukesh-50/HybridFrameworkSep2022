package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.Dataprovider;
import helper.Utility;

public class Assignment10 {
	
	@Test(dataProvider ="browsers",dataProviderClass = Dataprovider.class )
	public void verifycreationandDeletionOfCource(String browser) throws InterruptedException {
		Reporter.log("thread Id is"+Thread.currentThread().getId(), true);
	    WebDriver driver = Utility.startBroswer(browser, "https://ineuron-courses.vercel.app/login");
		 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		String email ="ineuron@ineuron.ai";
		String password ="ineuron";
		String courseName = "Rest Assured";
		
		Reporter.log("Launch the website", true);
		driver.get("https://ineuron-courses.vercel.app/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content']")));
		
		Reporter.log("Login to the website", true);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Reporter.log("Hover on manage", true);
		WebElement title = driver.findElement(By.xpath("//div[@class='navbar-menu']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navbar-menu']")));
		
		Reporter.log("title::"+title.getText(), true);
		Actions action = new Actions(driver);	
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='Manage']")));
	    action.moveToElement(driver.findElement(By.xpath("//span[text()='Manage']"))).perform();
	    
	    Reporter.log("click on manage courses", true);
	    driver.findElement(By.xpath("//a[@href='/course/manage']")).click();
	    
	    List<WebElement> courses = driver.findElements(By.xpath("//tr"));
	    int numberOfCources = courses.size();
	    Reporter.log("Courses avaialble are::"+numberOfCources, true);
		
		Reporter.log("click on add new course", true);
		driver.findElement(By.xpath("//button[contains(text(),'Add New Course')]")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='modal-dialog']")));
		driver.findElement(By.xpath("//input[@name='thumbnail']")).sendKeys("/Users/a0k00l0/eclipse-workspace/SeleniumWebDriver/courseImg.png");
		
		Reporter.log("Fill in course details", true);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(courseName);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Learn to automated apis using rest assured");
		driver.findElement(By.xpath("//input[@name='instructorName']")).sendKeys("aparajeeta");
		driver.findElement(By.xpath("//input[@name='price']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@name='startDate']")).click();
		driver.findElement(By.xpath("//div[text()='28']"));
		driver.findElement(By.xpath("//input[@name='endDate']")).click();
		driver.findElement(By.xpath("//div[text()='29']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Select Category']")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[normalize-space()='Testing']")));
		driver.findElement(By.xpath("//button[normalize-space()='Testing']")).click();
		
		Reporter.log("save button should be enabled", true);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//button[text()='Save']")).isEnabled());
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Reporter.log("check if user is redirected to manage cource page", true);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Manage Courses']")));
		
		Reporter.log("check if added course is present", true);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody")));
		
		Reporter.log("delete the course", true);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody//tr")));	
		driver.findElement(By.xpath("//td[normalize-space()='Rest Assured']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		
		Thread.sleep(2000);
		Reporter.log("Assert the course is deleted", true);
		
		Reporter.log("Click on logout", true);
		driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).click();
		
		Reporter.log("Assert user is redirected to login page", true);
		wait.until(ExpectedConditions.urlContains("login"));
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains("login"));
		driver.findElement(By.xpath("//h2[normalize-space()='Sign In']")).isDisplayed();
		
		driver.quit();
		
		
		
	}

		
	}

