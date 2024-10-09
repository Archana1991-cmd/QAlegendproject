package PageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtilities;
import Utilities.PageUtilities;
import Utilities.WaitUtilities;

public class QAlegendCategoriesPage {
           WebDriver driver;
           
           @FindBy(xpath = "(//span[@class='pull-right-container'])[3]")
   	       WebElement productsoption; 
           @FindBy(xpath = "//i[@class='fa fa-tags']")
           WebElement categoriesoption;
           @FindBy(xpath = "//button[@class='btn btn-block btn-primary btn-modal']")
           WebElement addbutton;
           @FindBy(id="name")
           WebElement CategoriesNamebox;
           @FindBy(id="short_code")
           WebElement CategoriesCodebox;
           @FindBy(xpath = "//button[text()='Save']")
           WebElement savebutton;
           @FindBy(xpath = "//input[@class='form-control input-sm']")
   	       WebElement searchBox;
           @FindBy(xpath = "//th[@class='sorting_asc']")
   	       WebElement errorMessege;
   	    
           public QAlegendCategoriesPage(WebDriver driver) {
          	  this.driver=driver;
        	  PageFactory.initElements(driver, this);
      	}

        public void clickOnProductsOption() {
			  productsoption.click();
		}

        public void clickOnCategoriesOption() {
			  categoriesoption.click();
			
		}
        public void clickOnAddButton() {
			  addbutton.click();
			
		}
		public String insertOnCategoriesNameBox(String excelfilepath6, String sheetname) throws IOException {
			 String categoriesname=ExcelUtilities.getString(1, 0, "//src//main//java//resources//addCategory.xlsx", "Sheet1");
			 PageUtilities.enterText(CategoriesNamebox, categoriesname);
			 return categoriesname;
			
		}
		public void insertOnCategoryCodeBox() throws IOException {
			String categoriescode=ExcelUtilities.getString(1, 1, "//src//main//java//resources//addCategory.xlsx", "Sheet1");
			PageUtilities.enterText(CategoriesCodebox, categoriescode);
			
		}

        public void clickOnSaveButton() {
			savebutton.click();
			
		}
        public String enterCategorysearchBox(String categoriesname) {
        	WaitUtilities.waitForElementVisibility(searchBox, 5);
		    PageUtilities.enterText(searchBox,  categoriesname);
		    return categoriesname;
	     }

		public String brandNameBoxFinder(String categoriesname) {
		    errorMessege.isDisplayed();
		    return categoriesname;
		}
		 
}
