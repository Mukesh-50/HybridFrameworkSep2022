package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class ManageCoursesPage{
    WebDriver driver;
	
	public ManageCoursesPage(WebDriver driver)
	{
		this.driver=driver;
	}
    By ManageLink = By.xpath("//span[text()='Manage']");
    By clickManageLink = By.xpath("//span[text()='Manage Courses']");
    By addNewCourseButton = By.cssSelector("div.header-div div.manage-btns > button:nth-child(3)");

    public void locateManageCoursesLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(ManageLink));
		WebElement manageLink = driver.findElement(ManageLink);
		Actions act = new Actions(driver);
		act.moveToElement(manageLink).perform();
    }

    public void clickManageCoursesLink(){
        driver.findElement(clickManageLink).click();
    }

    public void clickAddNewCourseButton(){
        WebElement addCourse = driver.findElement(addNewCourseButton);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", addCourse);
    }

    public void addNewCourseDetail(String courseName,String description, String instructor, String price, String startDate, String endDate, String category){
       // WebElement chooseFile = driver.findElement(By.id("thumbnail"));
      //  chooseFile.sendKeys("C:/Users/sv70/Documents/GitHub/SeleniumTasks/src/test/resources/UploadImage/thumbnail.png");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//h3[text()='Course Name']//following::input[@id='name']")).sendKeys(courseName);
        driver.findElement(By.xpath("//h3[text()='Description']//following::textarea[@id='description']")).sendKeys(description);
        driver.findElement(By.xpath("//h3[text()='Instructor']//following::input[@id='instructorNameId']")).sendKeys(instructor);
        WebElement elePrice =   driver.findElement(By.xpath("//h3[text()='Price']//following::input[@value='0']"));
        elePrice.sendKeys(Keys.BACK_SPACE);	 
        elePrice.sendKeys(price);
        WebElement startDateEle = driver.findElement(By.xpath("//h3[text()='Starts From']//following::input[@name='startDate']"));
        startDateEle.click();
        Utility.clearTextField(startDateEle);
       // startDateEle.sendKeys(Keys.BACK_SPACE);
        startDateEle.sendKeys(startDate);
        
        WebElement endDateEle = driver.findElement(By.xpath("//h3[text()='Ends On']//following::input[@name='endDate']"));
        endDateEle.click();
      //  endDateEle.sendKeys(Keys.BACK_SPACE);
        Utility.clearTextField(endDateEle);
        endDateEle.sendKeys(endDate);

       List<WebElement> categoryList = driver.findElements(By.xpath("//h3[text()='Category']//following::button[@class='menu-item']"));
       for(WebElement ele: categoryList){
        if(ele.getText()==category){
            ele.click();
            break;
        }
       }
   
        driver.findElement(By.xpath("//h3[text()='Category']//following::div[text()='Select Category']")).click();
        driver.findElement(By.xpath("//div[@class='menu-items']/button[text()='Testing']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }
}