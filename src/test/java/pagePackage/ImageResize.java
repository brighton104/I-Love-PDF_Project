package pagePackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ImageResize {

	
	WebDriver driver;
	
	public ImageResize(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchToImage()
	{
		WebElement ele=driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li/div/ul/li[9]/a")).click();
	}
	
	public void resizeImage() throws Exception
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		imageFileUpload("D:\\files\\image.png");
	}

	private void imageFileUpload(String resize) throws Exception 
	{
		StringSelection str=new StringSelection(resize);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void percentageResize() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"tab-percentage\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"tab-content-percentage\"]/ul/li[3]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"processTask\"]")).click();
		Thread.sleep(10000);
	}
}
