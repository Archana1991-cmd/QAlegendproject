package AutomationCore;

import java.io.File;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import com.google.common.io.Files;

public class BaseClass {
	
		 public WebDriver driver;
		 public String excelfilepath1="\\src\\main\\java\\resources\\addSalesCommission.xlsx";
		 public String excelfilepath2="\\src\\main\\java\\resources\\userDetails.xlsx";
		 public String excelfilepath3="\\src\\main\\java\\resources\\addSuppliers.xlsx";
		 public String excelfilepath4="\\src\\main\\java\\resources\\addACustomer.xlsx";
		 public String excelfilepath5="\\src\\main\\java\\resources\\addBrands.xlsx";
		 public String excelfilepath6="\\src\\main\\java\\resources\\addCategory.xlsx";
		 public String excelfilepath7="\\src\\main\\java\\resources\\addUnits.xlsx";
		 public String excelfilepath8="\\src\\main\\java\\resources\\addACustomerGroup.xlsx";
		   public WebDriver browserInitilization(String browsername)
		   {
			   if (browsername.equalsIgnoreCase("Chrome"))
			   {
				   driver=new ChromeDriver();
			   }else if (browsername.equalsIgnoreCase("Edge"))
			   {
				   driver=new EdgeDriver();
				 
			   }else if (browsername.equalsIgnoreCase("firefox"))
			   {
				   driver=new FirefoxDriver();
			   }else
			   {
				   System.out.println("Invalid browser");
			   }
			   //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			   return driver;
		   
		   }
		   
		   public String getScreenShotPath(String testcasename,WebDriver driver) throws IOException 
		   {
			  TakesScreenshot ts=(TakesScreenshot)driver;
			  File source=ts.getScreenshotAs(OutputType.FILE);
			  String destinationfile=System.getProperty("user.dir")+"\\test-output\\"+testcasename+".png";
			  Files.copy(source, new File(destinationfile));
			  return destinationfile;
			  
		   }
		
}