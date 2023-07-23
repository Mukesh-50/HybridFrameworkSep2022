package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name = "loginDetails")
	public static Object[][] getData() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("Login");
		return arr;
	}

	@DataProvider(name = "Usercreation")
	public static Object[][] getData11() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("userdetails");
		return arr;
	}
	
	@DataProvider(name = "checkuser")
	public static Object[][] getData112() 
	{
		Object[][] arr = ExcelReader.getDataFromSheet("checkuser");
		return arr;
	}
	

}
