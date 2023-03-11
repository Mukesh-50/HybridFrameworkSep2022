package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By user=By.id("email1");
	
	By pass=By.name("password1");
	
	By login=By.xpath("//button[normalize-space()='Sign in']");
	
	By loginHeader=By.xpath("//button[@type='submit']");
	
	public void loginToApplication(String username,String password)
	{
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		try{
		driver.findElement(login).click();
		}
		catch(Exception e){
			try {
				WebElement element = driver.findElement(login);
				Utility.javaScriptClick(driver, element);
				
			} catch (Exception f) {
				System.out.println("Click did not get performed");
			}

		}
		
	}
	
	public boolean isSignInPresent()
	{
		return driver.findElement(loginHeader).isDisplayed();
	}
	

}
