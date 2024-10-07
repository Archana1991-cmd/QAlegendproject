package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.ExcelUtilities;
import Utilities.PageUtilities;


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
	    
	    @FindBy(xpath = "(//input[@class='form-control input-sm'])[1]")
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

		public String insertOnBrandNameBox() throws IOException {
			 String brandnameBox=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addBrands.xlsx", "Sheet1");
			 PageUtilities.enterText(BrandNameBox, brandnameBox);
			 return brandnameBox;
			
		}
		 public void insertOnshortdiscriptionBox() throws IOException {
			String notesBox=ExcelUtilities.getString(1, 1, "//src/main//java//resources//addBrands.xlsx", "Sheet1"); 
			PageUtilities.enterText(shortdiscriptionbox, notesBox);
			
		}
		public void clickOnSaveButton() {
			PageUtilities.clickOnElement(savebutton);
			
		}
	    public void enterUsersearch(String brandnameBox) {
			    PageUtilities.enterText(searchbox, brandnameBox);
		}

		public boolean MatchingRecordsFound() {
			return (PageUtilities.isElementDisplayed(brandErrorMessege));
		}
		
}	
