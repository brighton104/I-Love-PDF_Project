package testPackage;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePackage.HomePage;
import pagePackage.ImageResize;
import pagePackage.ImageToPdfConvert;
import pagePackage.LoginPage;
import pagePackage.SplitPdf;
import pagePackage.PdfToWordConvert;
import pagePackage.SignUpPage;
import utilPackage.ExcelUtilClass;


public class TestClass extends BaseClass
{

	//Login Validation Test
	@Test (priority=1)
	public void loginValidation() throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
		String x1="D:\\files\\datadriven.xlsx";
		String Sheet="Sheet1"; 
		//Last row count
				int rowCount=ExcelUtilClass.getRowCount(x1, Sheet);
				for(int i=1;i<=rowCount;i++)
				{
					
					String username=ExcelUtilClass.getCellValue(x1,Sheet,i,0);
					System.out.println("username---"+ username);
					String password=ExcelUtilClass.getCellValue(x1,Sheet,i,1);
					System.out.println("PAssword---"+password);
					lp.setLoginValues(username, password);
					lp.setLoginButton();
				
					//Logout condition for valid user
					String expected=driver.getCurrentUrl();
					String actual="https://www.ilovepdf.com/";
					if(expected.equals(actual))
					{
						System.out.println(username+" = Login Passed");
						lp.logOut();
						
					}
					else
					{
						System.out.println(username+" = Login Failed");
						File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileHandler.copy(scr, new File("./Screenshot//UserLogin"+i+".png"));
					}
				
				}
				
	}
	
	//Registration Validation Test
	@Test(priority=2)
	public void signUpValidation() throws Exception
	{
		SignUpPage sp=new SignUpPage(driver);
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[3]")).click();
		sp.setRegistration("Brighton MS", "brightonms19@gmail.com", "Pass@123");
		sp.setRegistrationSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String actual=driver.getCurrentUrl();
		System.out.println("url:-" +actual );
		String expected="https://www.ilovepdf.com/register";
		if(expected.equals(actual))
		{
			System.out.println("Registration Failed");
			File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scr, new File("./Screenshot//signupValidation1.png"));
		}
		else
		{
			System.out.println("Registration success");
		}	
				
		
	}
	
	//Home Page
	@Test (priority=3)
	public void homeValidation()
	{
		HomePage hp=new HomePage(driver);
		hp.verifyTitle();
		//hp.verifyResponse();
		hp.switchToImage();
		hp.scrollDown();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hp.changeLanguageItilain();
		hp.scrollDown();
		hp.footerPages();
		hp.scrollDown();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hp.changeLanguageEnglish();
		hp.switchToPdf();
		
	}
	
	@Test (priority=8)
	public void homePageResponse()
	{
		HomePage hp1=new HomePage(driver);
		hp1.verifyResponse();
	}
	
	
	@Test(priority=4)
	public void mergeTwoPdf() throws Exception
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/a")).click();
		SplitPdf mp=new SplitPdf(driver);
		mp.splitFile();
	}
	
	@Test(priority=5)
	public void pdfToWordCheck() throws Exception
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/a")).click();
		PdfToWordConvert pw=new PdfToWordConvert(driver);
		pw.convertPDF();
	}
	
	@Test(priority=6)
	public void imageToPdfCheck() throws Exception
	{
		ImageToPdfConvert ip=new ImageToPdfConvert(driver);
		ip.switchToImage();
		ip.imageToPdf();
	}
	
	@Test(priority=7)
	public void imageResizeCheck() throws Exception
	{
		ImageResize ir=new ImageResize(driver);
		ir.switchToImage();
		ir.resizeImage();
		ir.percentageResize();
	}
	
	@AfterMethod
	public void afterTest()
	{
		System.out.println("Test Execution Completed");
	}
	
	@AfterTest
	public void closeWindow()
	{
	driver.close();	
	}
}
