package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage 
{
	WebDriver driver;
	
	//Object Repository
	By regName=By.id("name");
	By regEmail=By.id("signupEmail");
	By regPassword=By.id("password");
	By regSubmit=By.id("registerButton");
	
	//Constructor
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Registration Methods
	public void setRegistration(String nameReg,String emailReg,String passwordReg)
	{
		driver.findElement(regName).sendKeys(nameReg);
		driver.findElement(regEmail).sendKeys(emailReg);
		driver.findElement(regPassword).sendKeys(passwordReg);
	}
	
	//Registration Submit
	public void setRegistrationSubmit()
	{
		driver.findElement(regSubmit).click();
	}
	
	
	

}