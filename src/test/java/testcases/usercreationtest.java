package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.Loginpage1;
import pages.homepage1;

public class usercreationtest extends BaseClass

{
	@Test(dataProvider = "Usercreation",dataProviderClass = CustomDataProvider.class)
	public void usercreation234(String name,String email,String pwd3) throws InterruptedException
	{
		Loginpage1 loginpage=new Loginpage1(driver);
		
		loginpage.usercreation(name,email, pwd3);
	}
    

	
	@Test(dataProvider = "checkuser",dataProviderClass = CustomDataProvider.class)
	
	public void loginintoapp233(String Username,String Password) throws InterruptedException
	{
		Loginpage1 loginpage=new Loginpage1(driver);
		
		loginpage.loginintapp33(Username, Password);
		
		homepage1 home=new homepage1(driver);
		
		Assert.assertTrue(home.welcomemsg().contains("JAVA"));
		


}}

