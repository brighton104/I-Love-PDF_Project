package pagePackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SplitPdf {

	
	WebDriver driver;
	
	public SplitPdf(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void splitFile() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		fileUpload("D:\\files\\pdf1.pdf");
		driver.findElement(By.xpath("//*[@id=\"processTask\"]")).click();
		Thread.sleep(10000);
	}

	private void fileUpload(String file) throws Exception 
	{
		StringSelection str=new StringSelection(file);
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
