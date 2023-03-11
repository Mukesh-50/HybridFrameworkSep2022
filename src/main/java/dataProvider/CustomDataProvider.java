package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "loginDetails")
	public static Object[][] getData() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("Login");
		return arr;
	}

	@DataProvider(name = "creatCourseDetails")
	public static Object[][] getCreateCourseData()
	{
		Object[][] arr = ExcelReader.getDataFromSheet("createCourse");
		return arr;
	}

}
