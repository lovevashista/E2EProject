package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Creating objects using normal object pattern*/
public class HomePageObjects {
	
	public static WebDriver driver; //making it static so that during execution of one class file, the same driver instance will be reffered by the test cases
	//of that class only. This is useful to avoid conflict and full proofing the execution when 1000s of test cases in 100s of files are to be executed.
	
	//create a constructor
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By loginLink = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
	By fCoursesText = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigationBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	
	public WebElement loginLink() {
		return driver.findElement(loginLink);
	}
	
	public WebElement fCText() {
		return driver.findElement(fCoursesText);
	}
	
	public WebElement navigationBar() {
		return driver.findElement(navigationBar);
	}
}
