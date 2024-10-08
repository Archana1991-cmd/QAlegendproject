package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtilities;


public class QAlegendRolesPage {
       WebDriver driver;
      
       @FindBy(xpath="(//span[@class='title'])[3]")
       WebElement roles;
   	
   	   @FindBy(xpath ="//a[@class='btn btn-block btn-primary']")
       WebElement roleAddButton;
   	
   	   @FindBy(xpath = "//input[@class='form-control']")
   	   WebElement AddRoleName;
   	   
   	   @FindBy(xpath ="(//ins[@class='iCheck-helper'])[2]")
   	   WebElement userOption;
   	
   	   @FindBy(xpath = "//button[text()='Save']")
       WebElement saveButton; 
       
       @FindBy(xpath="//input[@class='form-control input-sm']")
       WebElement SearchButton;

       
    public QAlegendRolesPage(WebDriver driver) {
     	  this.driver=driver;
   		   PageFactory.initElements(driver, this);
 	}
    public void clickOnRolesOption() {
    	roles.click();
   		
   	}
   	public String insertRoleName(String rolename) {
	    PageUtilities.enterText(AddRoleName, rolename);
	    return rolename;
    }
   	 public void clickOnRoleAddButton() {
      	roleAddButton.click();	
  	}
	public void clickOnUserOption() {
		userOption.click();
	}
	 public void clickOnSaveButton() {
	   	saveButton.click();	
  	}
	 public String roleAddSearch(String rolename) {
	    PageUtilities.enterText(SearchButton,rolename);
		return rolename;
	}
}
