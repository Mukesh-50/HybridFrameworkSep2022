package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;
import pages.ManageCoursesPage;

public class CreateCourse extends BaseClass
{

	@Test(dataProvider ="loginDetails", dataProviderClass = CustomDataProvider.class,priority = 0)
	public void loginToApp(String Username, String Password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(Username, Password);
		
	}
	
	@Test(priority = 1)
	public void clickManageCourse(){
		ManageCoursesPage manage = new ManageCoursesPage(driver);		
		manage.locateManageCoursesLink();
		manage.clickManageCoursesLink();
		manage.clickAddNewCourseButton();

	}
	
	@Test(dataProvider ="creatCourseDetails", dataProviderClass = CustomDataProvider.class, priority = 2)
	public void addCourse(String CourseName, String Description, String Instructor,String Price, String StartsFrom, String EndsOn, String Category)
	{
		//ManageCoursesPage manage = new ManageCoursesPage(driver);
		new ManageCoursesPage(driver).addNewCourseDetail(CourseName, Description, Instructor, Price, StartsFrom, EndsOn,Category);
		
	}
	
	public void test3()
	{
		
	}
	

}
