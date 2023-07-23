package Saucetestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import Saucepages.SauceLoginpage;
import Saucepages.Saucehomepage;
public class Saucelogintest extends BaseClass
{
	@Test(dataProvider = "loginDetails",dataProviderClass = CustomDataProvider.class)
	public void loginintoapp1(String Username,String Password) throws InterruptedException
	{
		SauceLoginpage sauceapplogin=new SauceLoginpage(driver);
		
		sauceapplogin.loginintpsauceapp(Username, Password);
		
		Saucehomepage homepage=new Saucehomepage(driver);
		
		Assert.assertTrue(homepage.welcomepagetitle().contains("Products"));
		
		homepage.logout();

		sauceapplogin.loginbutton();

	}}
