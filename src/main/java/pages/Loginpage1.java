package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
public class Loginpage1 

{
WebDriver driver;
	
	public Loginpage1(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By UN=By.xpath("//input[@id='email1']");
	
	By pwd1=By.xpath("//input[@id='password1']");
	
	By Loginbutton=By.xpath("//button[@class='submit-btn']");
	
	By loginpageheaderr=By.xpath("//h2[normalize-space()='Sign In']");
	
	By name1=By.xpath("//input[@id='name']");
	
	By email1=By.xpath("//input[@id='email']");
	
	By pwdusersign=By.xpath("//input[@id='password']");
	
	By checkbox=By.xpath("(//input[@type='checkbox'])[3]");
	
	By  signup=By.xpath("//button[contains(.,'Sign up')]");
	
	By newusersignup=By.xpath("//a[contains(.,'New user? Signup')]");
	
	
	public void loginintapp(String un,String pwd)
	{
		driver.findElement(UN).sendKeys(un);
		
		driver.findElement(pwd1).sendKeys(pwd);
		
		driver.findElement(Loginbutton).click();
	}
	
	public void loginintapp33(String un,String pwd)
	{
		driver.findElement(UN).sendKeys(un);
		
		driver.findElement(pwd1).sendKeys(pwd);
		
		driver.findElement(Loginbutton).click();
	}
	
	
	public boolean signinpagepresent()
	{
		return driver.findElement(loginpageheaderr).isDisplayed();
		
		
	}
	
	public void usercreation(String name,String email,String pwdforUC)
	{
		driver.findElement(newusersignup).click();
		
		driver.findElement(name1).sendKeys(name);
		
		driver.findElement(email1).sendKeys(email);
		
		driver.findElement(pwdusersign).sendKeys(pwdforUC);
		
		driver.findElement(checkbox).click();
		
org.openqa.selenium.WebElement RB=driver.findElement(By.xpath("//label[text()='Male']"));
		
		org.openqa.selenium.JavascriptExecutor js=(org.openqa.selenium.JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click()", RB);
		
		//Thread.sleep(5000);
		
		
		org.openqa.selenium.WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
		
		//js.executeScript("arguments[0].click()", state);
		
		Select obj=new Select(state);
		
		obj.selectByVisibleText("Karnataka");
		
		boolean Enabled=driver.findElement(By.xpath("//button[text()='Sign up']")).isEnabled();
		
		driver.findElement(signup).click();
		
		
	}
	
	
	
	
}
