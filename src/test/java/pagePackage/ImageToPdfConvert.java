package pagePackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ImageToPdfConvert {
	WebDriver driver;
	
	public ImageToPdfConvert(WebDriver driver)
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
	
	public void imageToPdf() throws Exception
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		fileuploadimage("D:\\files\\image.png");
		driver.findElement(By.xpath("//*[@id=\"processTask\"]")).click();
		Thread.sleep(10000);
		
	}

	private void fileuploadimage(String image) throws Exception {
		StringSelection str=new StringSelection(image);
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
	
	
}
