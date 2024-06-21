package pagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
	
	
	WebDriver driver;
	
	//Object Repository
	By loginEmail=By.id("loginEmail");
	By loginPassword=By.id("inputPasswordAuth");
	By login=By.id("loginBtn");
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Login Method
	public void setLoginValues(String email,String password)
	{
		driver.findElement(loginEmail).clear();
		driver.findElement(loginEmail).sendKeys(email);
		driver.findElement(loginPassword).clear();
		driver.findElement(loginPassword).sendKeys(password);
	}

	public void setLoginButton()
	{
		driver.findElement(login).click();
	}
	
	public void logOut()
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul[1]/li/a/img"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul[1]/li/div/ul/li[7]/a")).click();
		driver.get("https://www.ilovepdf.com/login");
		
	}
	
}
