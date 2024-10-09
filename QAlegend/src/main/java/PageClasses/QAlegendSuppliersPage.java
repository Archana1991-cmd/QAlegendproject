package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.fakerUtility;

public class QAlegendSuppliersPage {
 
	WebDriver driver;
	
	@FindBy(xpath="(//i[@class='fa fa-star'])[1]")
	WebElement suppliersoption;
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addbutton;
	@FindBy(xpath  = "(//*[@id='contact_type'])[2]")
	WebElement Contacttype;
	@FindBy(id ="name")
	WebElement Name;
	@FindBy(id = "supplier_business_name")
	WebElement Businessname;
	@FindBy(id = "mobile")
	WebElement Mobile;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath = "(*//input[@class='form-control input-sm'])")
	WebElement searchbox;
	@FindBy(xpath = "//th[text()='Business Name']")
    WebElement businessnamemesseger;
	@FindBy(xpath = "//th[@class='sorting_asc']")
	WebElement namebox;
	
	public QAlegendSuppliersPage(WebDriver driver) {
		    this.driver=driver;
			PageFactory.initElements(driver, this);
		
	}
    public void clickOnSuppliersOption() {
		suppliersoption.click();
	}

	public void clickOnAddButton() {
		addbutton.click();
	}
	public String insertSuppliers(String excelfilepath3, String sheetname) throws IOException {
		 String contacttype=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
		 String name=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
		 String businessname=fakerUtility.randomNumberGenerator()+ExcelUtilities.getString(1, 2, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1");
		 String mobile= fakerUtility.randomNumberGenerator()+ExcelUtilities.getNumeric(1, 3, "//src//main//java//resources//addSuppliers.xlsx", "Sheet1"); 
		    PageUtilities.dropdownSelectByVisibleText(Contacttype, "Suppliers");
			PageUtilities.enterText( Name, name);
			PageUtilities.enterText(Businessname, businessname);
			PageUtilities.enterText(Mobile, mobile);
			return businessname;   
	    
    }
    public void clickOnSaveButton() {
		savebutton.click();
	}
    public String searchSupplierBox(String businessname) {
		PageUtilities.enterText(searchbox, businessname);
		return businessname;
	}
    public boolean businessnamemesseger() {
		return businessnamemesseger.isDisplayed();
	}
	public void nameinSupplierTextBox() {
		PageUtilities.clickOnElement(namebox);
		
	}
	
	
}
