package browserFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserInstance()
	{
		return driver;	
	}
	
	
	public static WebDriver startBrowser(String browserName,String applicationURL)
	{

		
		if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome"))
		{
			//ChromeOptions opt=new ChromeOptions();
			//opt.addArguments("--headless");
			//opt.addArguments("--no-sandbox");
			driver=new ChromeDriver();
			//driver=new ChromeDriver();
		}
		else if(browserName.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.contains("Safari"))
		{
			driver=new SafariDriver();
		}
		else if(browserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		
		driver.get(applicationURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		return driver;
	}

}
