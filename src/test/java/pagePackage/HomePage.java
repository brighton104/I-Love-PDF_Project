package pagePackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage 
{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyTitle()
	{
		String act=driver.getTitle();
		String exp="iLovePDF | Online PDF tools for PDF lovers";
		if(exp.equals(act))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title Verification Failed");
		}
		
	}
	
	public void verifyResponse()
	{
		List<WebElement>li=driver.findElements(By.tagName("a"));
		for (WebElement s:li)
		{
			//System.out.println(s);
			String link=s.getAttribute("href");
			System.out.println(link);
			verify(link);//Method call
		}
	}
	
	public void verify(String link)
	{
				try
				{
					URL ob=new URL(link);
					HttpURLConnection con=(HttpURLConnection)ob.openConnection();
					//To get response code
					
					if(con.getResponseCode()==200)
					{
						System.out.println("Connection valid");
					}
					else if(con.getResponseCode()==404)
					{
						System.out.println("Broken Link");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
					
	}
	
	public void switchToImage()
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li/div/ul/li[9]/a")).click();
	}
	
	public void scrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}
	
	public void changeLanguageItilain()
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/span"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/ul/li[5]/a")).click();
	}
	
	public void footerPages()
	{
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/header/nav/a/img")).click();
		
	}
	
	public void changeLanguageEnglish()
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/span"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/ul/li[1]/a")).click();
	}
	
	public void switchToPdf()
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li/div/ul/li[8]/a")).click();
	}
	

}
