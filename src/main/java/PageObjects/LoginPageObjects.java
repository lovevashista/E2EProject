package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Defining the objects using Page Object Factory Pattern
public class LoginPageObjects {
	
	public static WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement emailTF;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement passwordTF;
	
	@FindBy(css="input[name='commit']")
	WebElement loginButton;
	
	public WebElement EmailID() {
		return emailTF;
	}
	
	public WebElement Password() {
		return passwordTF;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
}
