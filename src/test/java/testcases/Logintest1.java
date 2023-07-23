package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.HomePage;
import pages.Loginpage1;
import pages.homepage1;

public class Logintest1 extends BaseClass
{
	@Test(dataProvider = "loginDetails",dataProviderClass = CustomDataProvider.class)
	public void loginintoapp23(String Username,String Password) throws InterruptedException
	{
		Loginpage1 loginpage=new Loginpage1(driver);
		
		loginpage.loginintapp(Username, Password);
		
		homepage1 home=new homepage1(driver);
		
		Assert.assertTrue(home.welcomemsg().contains("JAVA"));
		
		Thread.sleep(5);
		
		home.signout();
		
		Assert.assertTrue(loginpage.signinpagepresent());
		
		
	}
}

