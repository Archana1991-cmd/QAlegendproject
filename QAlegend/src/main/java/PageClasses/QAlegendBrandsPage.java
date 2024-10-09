package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.WaitUtilities;


public class QAlegendBrandsPage {
	    WebDriver driver;
	    
	    @FindBy(xpath = "(//span[@class='pull-right-container'])[3]")
	    WebElement productsoption;
	    
	    @FindBy(xpath = "//span[text()='Brands']")
	    WebElement brandsoption;
	    
	    @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
	    WebElement addbutton;
	    
	    @FindBy(id="name")
	    WebElement BrandNameBox;
	    
	    @FindBy(id = "description")
	    WebElement shortdiscriptionbox;
	    
	    @FindBy(xpath = "//button[text()='Save']")
	    WebElement savebutton;
	    
	    @FindBy(xpath = "*//input[@class='form-control input-sm']")
	    WebElement searchbox;
	    
	    @FindBy(xpath = "(//tr[@role='row']//td)[1]")
	    WebElement brandErrorMessege;

        public QAlegendBrandsPage(WebDriver driver) {
        	this.driver=driver;
        	PageFactory.initElements(driver, this);
       	}

        public void clickOnProductsOption() {
		    productsoption.click();
		}

		public void clickOnBrandsOption() {
			brandsoption.click();
		}
        public void clickOnAddButton() {
        	addbutton.click();
		}

		public String insertOnBrandNameBox(String excelfilepath5, String sheetname) throws IOException {
			 String brandname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addBrands.xlsx", "Sheet1");
			 PageUtilities.enterText(BrandNameBox, brandname);
			 return brandname;
			
		}
		 public void insertOnshortdiscriptionBox() throws IOException {
			String notesBox=ExcelUtilities.getString(1, 1, "//src/main//java//resources//addBrands.xlsx", "Sheet1"); 
			PageUtilities.enterText(shortdiscriptionbox, notesBox);
			
		}
		public void clickOnSaveButton() {
			 PageUtilities.clickOnElement(savebutton);
			
		}
	    public void enterBrandsearchBox(String brandname) {
	    	   
			   PageUtilities.enterText(searchbox, brandname);
		}

		public String brandnameBoxFinder(String brandname) {
			brandErrorMessege.isDisplayed();
			return brandname;
		}
		
}	
