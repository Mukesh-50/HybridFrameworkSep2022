package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signOut=By.xpath("//button[normalize-space()='Sign out']");
	
	By welcomeMsg=By.xpath("//h2[contains(text(),'Java Selenium')]");
	
	public void clickOnSignOut()
	{
		driver.findElement(signOut).click();
	}
	
	public String getWelcomeMsg()
	{
		return driver.findElement(signOut).getText();
	}
	
	
}
