package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.WaitUtilities;
import Utilities.fakerUtility;

public class QAlegendCustomerPage {
   WebDriver driver;
   
   @FindBy(id="tour_step4_menu")
   WebElement contactsoption;
   @FindBy(xpath = "(//i[@class='fa fa-star'])[2]")
   WebElement customerOption;
   @FindBy(xpath="(//i[@class='fa fa-plus'])[1]")
   WebElement customerAddOption;
   @FindBy(xpath = "(//*[@id='contact_type'])[2]")
   WebElement Contacttypebox;
   @FindBy(id = "name")
   WebElement Namebox;
   @FindBy(id = "contact_id")
   WebElement Contactidbox;
   @FindBy(id="mobile")
   WebElement Mobilebox;
   @FindBy(xpath="//button[text()='Save']")
   WebElement Savebutton;
   @FindBy(xpath = "(*//input[@class='form-control input-sm'])")
   WebElement searchBox;
   @FindBy(xpath =  "(//tr[@role='row']//td)[2]")
   WebElement nameBoxSuccessMessage;
   
   public QAlegendCustomerPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
   public void clickOnContactsoption() {
	    contactsoption.clear();
    }
   public void clickOnCustomerOption() {
		customerOption.click();
	}
   public void clickOnCustomerAddOption() {
	    customerAddOption.click();
	}
 
	public String insertCustomers(String excelfilepath4, String sheetname) throws IOException{
		 String contacttype=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
    	 String name=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
    	 String contactid=fakerUtility.randomNumberGenerator()+ExcelUtilities.getNumeric(1, 2, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
    	 String mobile=ExcelUtilities.getNumeric(1, 3, "//src//main//java//resources//addACustomer.xlsx","Sheet1");
    	PageUtilities.dropdownSelectByVisibleText(Contacttypebox, "Customers");
		PageUtilities.enterText(Namebox, name);
		PageUtilities.enterText(Contactidbox, contactid);
		PageUtilities.enterText(Mobilebox, mobile);
		return name;
	}
    public void clickOnSaveButton() {
		Savebutton.click();
	}
	public String searchBox(String name) {
		WaitUtilities.waitForElementVisibility(Contactidbox, 5);
		PageUtilities.enterText(searchBox, name);
		return name;
	}
	public String nameCellFinder(String name) {
		nameBoxSuccessMessage.isDisplayed();
		return name;
	}
	
}
