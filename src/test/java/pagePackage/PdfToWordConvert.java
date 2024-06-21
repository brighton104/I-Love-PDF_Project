package pagePackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PdfToWordConvert {
	
	WebDriver driver;
	
	public PdfToWordConvert(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void convertPDF() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		pdffileUpload("D:\\files\\pdf2.pdf");
		driver.findElement(By.id("processTaskTextBtn")).click();
		Thread.sleep(10000);
		
	}
	
	private void pdffileUpload(String path) throws Exception 
	{
		//to copy path to clipboard
		StringSelection str=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		//to paste into system window
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
