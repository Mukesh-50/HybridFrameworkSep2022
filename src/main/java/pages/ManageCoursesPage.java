package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageCoursesPage{
    WebDriver driver;
	
	public ManageCoursesPage(WebDriver driver)
	{
		this.driver=driver;
	}
    By ManageLink = By.xpath("//span[text()='Manage']");
    By clickManageLink = By.xpath("//span[text()='Manage Courses']");

    public void locateManageCoursesLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ManageLink));
		WebElement manageLink = driver.findElement(ManageLink);
		Actions act = new Actions(driver);
		act.moveToElement(manageLink).perform();
    }

    public void clickManageCoursesLink(){
        driver.findElement(clickManageLink).click();
    }
}