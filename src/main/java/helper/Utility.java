package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Utility {
	

	

	public static void clickElement(WebDriver driver, By locator)
	{
		try 
		{
			driver.findElement(locator).click();
		} catch (Exception e) {
			
			try {
				System.out.println("Trying with actions class click");
				Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(locator)).click().build().perform();
			} catch (Exception e1) {
				
				System.out.println("Trying with JS Click");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			}
			
		}
		
	}
	


	public static WebElement highlightElement(WebDriver driver,WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')", element);
		
		waitForSeconds(1);
		
		js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);
		
		return element;
	}
	
	public static WebElement highlightElement(WebDriver driver,By locator)
	{
		
		WebElement element=driver.findElement(locator);
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')", element);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);
		
		return element;
	}
	
	
	
	
	
	public static Alert waitForAlert(WebDriver driver)
	{
		Alert alt = null;
		
		for(int i=0;i<=15;i++)
		{
			try
			{
				alt=driver.switchTo().alert();
				break;
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("No Alert Found- Waiting for Alert");
				
				waitForSeconds(1);
			}
		}
		
		return alt;
	}
	
		

	
	public static Alert waitForAlert(WebDriver driver,int time)
	{
		Alert alt = null;
		
		for(int i=0;i<=time;i++)
		{
			try
			{
				alt=driver.switchTo().alert();
				break;
			}
			catch(NoAlertPresentException e)
			{
				System.out.println("No Alert Found- Waiting for Alert");
				
				waitForSeconds(1);
			}
		}
		
		return alt;
	}
	
	public static void waitForSeconds(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) 
		{
		
		}
	}
	
	// Sample Code
	public static void multipleScreenshot(int timeInterval,int totalDuration)
	{
		for(int i=0;i<totalDuration;i++)
		{
			
			try 
			{
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				
			}
			
		}
		
	}
	
	
	public static String captureScreenshotInBase64(WebDriver driver)
	{
	
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String base64=ts.getScreenshotAs(OutputType.BASE64);
		
		return base64;
		
	}
	
	public static void captureScreenshot(WebDriver driver)
	{
		try 
		{
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("./screenshots/Screenshot_"+getCurrentTime()+".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Something went wrong "+e.getMessage());
		}
	}
	
	public static String getCurrentTime()
	{
		String date=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		
		return date;
	}
	
	public static void captureScreenshotOfWebElement(WebDriver driver,WebElement element)
	{
		/*
		 * 	Implement this for screenshot of WebElement
		 * 
		 */
	}


	public static WebDriver startBroswer(String brosweName, String url ) {
		WebDriver driver =null;
		
		if(brosweName.contains("chrome"))
		{
			driver = new ChromeDriver();
		}else if(brosweName.contains("firefox")) {
			driver = new FirefoxDriver();
		}else if(brosweName.contains("Edge")){
			driver = new EdgeDriver();
		}else if(brosweName.contains("Safari")) {
			driver = new SafariDriver();
		}else{
			Reporter.log("Broswer not supported::"+brosweName +" Running tests in default browser");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	
}
