package LoveAndCo;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import resources.Base;

public class HomePage extends Base{
	
	private static Logger log = LogManager.getLogger(HomePage.class.getName()); //making it static so that during the execution of all the test cases of this
	//file should refer to this "log" object only. Useful for avoiding conflicts that may arise during the execution of the test cases when there are 
	//1000s of test cases present in 100s of classes and all the classes are to be run as a single suite.
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = intialiseDriver(); //No driver declaration here, since driver is declared in the "Base" class and we have inherited that class in this class.
	}
	
	@Test(dataProvider="getData") //provide the getData method here so that before entering, the execution control will go the method and fetch the data sets
	public void BasePageNavigation(String em, String pw) throws IOException {
		driver.get(prop.getProperty("url")); //Unlike in ValidateTitle.java, we are using it inside the test case itself because we want to execute the same
		//test case multiple times with multiple data.
		
		HomePageObjects hp = new HomePageObjects(driver);
		
		hp.loginLink().click();
		
		LoginPageObjects lp = new LoginPageObjects(driver);
		
		lp.EmailID().sendKeys(em);
		lp.Password().sendKeys(pw);
		lp.loginButton().click();
		
//		lp.loginButton.click(); //The reason we cant use the objects created directly because if the corresponding page object file is created in other package
		//then the visibility of the object will not be there since the object is not public, but the method in which we use this object, will always be 
		//made as public and thus the method usage.
	}
	//Parameterising the data so that the same test case (BasePageNavigation) can be executed with multiple test data and not just 
	//hardcoded "Hello" and "Password" data.
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2]; //We will run test case with only one data set (hence [1]) containing two vaues, username and password (hence [2])
		data[0][0] = "User1";
		data[0][1] = "Password1";
		
		data[1][0] = "User2";
		data[1][1] = "Password2";
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null; //bring the driver instance value to null so that the memory does not get wasted. We don't want to keep all driver instances alive.
	}
}
