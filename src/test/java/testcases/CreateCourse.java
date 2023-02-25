package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;
import pages.ManageCoursesPage;

public class CreateCourse extends BaseClass
{
	@Test(dataProvider ="loginDetails", dataProviderClass = CustomDataProvider.class)
	public void loginToApp(String Username, String Password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(Username, Password);		
		ManageCoursesPage manage = new ManageCoursesPage(driver);
		manage.locateManageCoursesLink();

		manage.clickManageCoursesLink();
	}
	
	// @Test
	// public void addCourse()
	// {
	// 	ManageCoursesPage manage = new ManageCoursesPage(driver);
	// 	manage.clickManageCoursesLink();
		
	// }
	
	// public void test3()
	// {
		
	// }
	

}
