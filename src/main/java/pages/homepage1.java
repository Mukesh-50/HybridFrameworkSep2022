package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage1 
{
WebDriver driver;
	
	public homepage1(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Signout=By.xpath("//button[contains(.,'Sign out')]");
	
    By welcomemsg=By.xpath("//h2[contains(text(),'Java Selenium')]");
	
	public void signout()
	{
		driver.findElement(Signout).click();
	}
	
	public String welcomemsg()
	{
		return driver.findElement(welcomemsg).getText();
		
	}
}
