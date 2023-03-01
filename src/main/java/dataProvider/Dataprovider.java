package dataProvider;

public class Dataprovider {

	@org.testng.annotations.DataProvider (name = "browsers")
	public static Object[][] browsers() {
		 return new Object[][] {{"chrome"}};
	}

}
