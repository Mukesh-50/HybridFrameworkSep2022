package Saucepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Saucehomepage

{
WebDriver driver;
	
	public Saucehomepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void logout()
	{
		By arrows=By.id("(//button[normalize-space()='Open Menu'])[1]");
		
		By logout=By.id("//a[@id='logout_sidebar_link']");
		
		driver.findElement(arrows).click();
		
		driver.findElement(logout).click();
	}
	public String welcomepagetitle()
	{
		By title=By.xpath("\\span[class*='title']");
		
		 return driver.findElement(title).getText();
	}

}
