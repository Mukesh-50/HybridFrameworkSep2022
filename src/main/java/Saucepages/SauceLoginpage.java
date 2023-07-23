package Saucepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginpage 

{
WebDriver driver;
	
	public SauceLoginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	By un3=By.id("\\input[id^='user-name']");
	
	By pwd3=By.id("\\input[id='password']");
	
	By login3=By.id("\\input[id='login-button']");
	
	public void loginintpsauceapp(String une,String pwde)
	{
	
		
		driver.findElement(un3).sendKeys(une);
		
		driver.findElement(pwd3).sendKeys(pwde);
		
		driver.findElement(login3).click();
				
	}
	
	public boolean loginbutton()
	{
		return driver.findElement(login3).isEnabled();
		
	}
}
