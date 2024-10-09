package QAlegendTestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import AutomationCore.BaseClass;
import PageClasses.QAlegendLoginPage;
import PageClasses.QAlegendRolesPage;
import PageClasses.QAlegendSalesCommissionPage;
import PageClasses.QAlegendSuppliersPage;
import PageClasses.QAlegendUnitsPage;
import PageClasses.QAlegendBrandsPage;
import PageClasses.QAlegendCategoriesPage;
import PageClasses.QAlegendCustomerGroupPage;
import PageClasses.QAlegendCustomerPage;
import PageClasses.QAlegendHomePage;
import PageClasses.QAlegendUserPage;
import Utilities.fakerUtility;


public class TestCases extends BaseClass{

		 WebDriver driver;
		 QAlegendLoginPage loginpage;
		 QAlegendHomePage homepage;
		 QAlegendUserPage userpage;
		 QAlegendCustomerPage customerpage;
		 QAlegendRolesPage rolespage;
		 QAlegendSalesCommissionPage salescommissionpage;
		 QAlegendSuppliersPage supplierspage;
		 QAlegendBrandsPage brandspage;
		 QAlegendCategoriesPage categoriespage;
		 QAlegendUnitsPage unitspage;
		 QAlegendCustomerGroupPage customergrouppage;
		 Properties prop;
		 FileReader reader;
		 String addrolename;
		
        @BeforeMethod(groups= {"smokettest","regression"})
		@Parameters({"Browser"})
		public void initialization(String browser)throws Exception 
		{
			prop=new Properties();
			reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.properties");
			prop.load(reader);
			
			driver=browserInitilization(browser);
			driver.get(prop.getProperty("url"));
			//driver.get("https://qalegend.com/billing/public/login");
			driver.manage().window().maximize();
			loginpage=new QAlegendLoginPage(driver);
			homepage=new QAlegendHomePage(driver);
			userpage=new QAlegendUserPage(driver);
			customerpage=new QAlegendCustomerPage(driver);
			rolespage=new QAlegendRolesPage(driver);
			salescommissionpage=new QAlegendSalesCommissionPage(driver);
			supplierspage=new QAlegendSuppliersPage(driver);
			unitspage=new QAlegendUnitsPage(driver);
			brandspage=new QAlegendBrandsPage(driver);
			categoriespage=new QAlegendCategoriesPage(driver);
			customergrouppage=new QAlegendCustomerGroupPage(driver);
			
		}
        
         @Test(retryAnalyzer = RetryAnalyzer.class,groups={"regression"})
		public void  verifyAddUser() throws IOException{
			
        	loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
			homepage.clickOnUserManagementOption();
			homepage.clickOnUserAction();
			userpage.clickOnUserAddOption();
			String email=userpage.insertUserQAlegent(excelfilepath2,"Sheet1");
			userpage.clickOnSaveButton(); 
		    userpage.enterUsersearch(email);
		    userpage.displayedresultBox();
		    Assert.assertEquals( userpage.enterUsersearch(email), email);
		    
		}
         
         @Test(retryAnalyzer = RetryAnalyzer.class,groups= {"smoketest"})
         public void  verifyDeleteUser() throws IOException{
 			
         	loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
 			homepage.clickOnUserManagementOption();
 			homepage.clickOnUserAction();
 			userpage.clickOnUserAddOption();
 			String deleteUser=userpage.insertUserQAlegent(excelfilepath2,"Sheet1");
 			userpage.clickOnSaveButton(); 
 		    userpage.enterUsersearch(deleteUser);
 			userpage.deleteUser();
 			userpage.pressOkButtonToDelete();
 		    Assert.assertEquals(userpage.noMatchingRecordsFound(),"No matching records found");
 		    
 		}
         
         @Test(retryAnalyzer = RetryAnalyzer.class,groups= {"smoketest"})
         public  void verifyAddRoles() throws IOException, InterruptedException {
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnUserManagementOption();
        	 rolespage.clickOnRolesOption();
        	 rolespage.clickOnRoleAddButton();
 			 String rolename=rolespage.insertRoleName("manager"+fakerUtility.randomNumberGenerator());
 			 rolespage.clickOnUserOption();
             rolespage.clickOnSaveButton();
 		     rolespage.roleAddSearch(rolename);
             Assert.assertEquals(rolespage.roleAddSearch(rolename),rolename);
         }
         
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddSalesCommission() throws IOException{
            
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 salescommissionpage.clickOnUserManagementOption();
 			 salescommissionpage.clickOnsalesCommissionOption();
 			 salescommissionpage.clickOnAddSalesButton();
 			 String email=salescommissionpage.insertSalescommissionDetails(excelfilepath1,"Sheet1");
 		     salescommissionpage.clickOnsaveButton();
 			 salescommissionpage.searchCommissionAgent(email);
 			 salescommissionpage.emailCellFinder(email);
 			 Assert.assertEquals(salescommissionpage.emailCellFinder(email),email);
 			 
		}
        
         @Test//(retryAnalyzer = RetryAnalyzer.class)
         public  void verifyAddSuppliers() throws IOException, InterruptedException {
        	
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 supplierspage.clickOnSuppliersOption();
        	 supplierspage.clickOnAddButton();
             String businessname=supplierspage.insertSuppliers(excelfilepath3,"Sheet1");
  			 supplierspage.clickOnSaveButton();
  			 supplierspage.searchSupplierBox(businessname);
  			 supplierspage.nameinSupplierTextBox();
  			 Assert.assertEquals(supplierspage.searchSupplierBox(businessname),businessname);
  		    
		}
         
       @Test//(retryAnalyzer = RetryAnalyzer.class)
       public void verifyAddCustomer() throws IOException, InterruptedException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 customerpage.clickOnCustomerOption();
        	 customerpage.clickOnCustomerAddOption();
        	 String name=customerpage.insertCustomers(excelfilepath4,"Sheet1");
        	 customerpage.clickOnSaveButton();
        	 customerpage.searchBox(name);
        	 customerpage.nameCellFinder(name);
        	 Assert.assertEquals(customerpage.searchBox(name),customerpage.nameCellFinder(name));
        } 
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddCustomerGroup() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 homepage.clickOnContactsOption();
        	 customergrouppage.clickOnCustomerGroupOption();
        	 customergrouppage.clickOnCustomerGroupAddOption();
        	 String customergroupname=customergrouppage.insertCustomerGroup(excelfilepath8,"Sheet1");
        	 customergrouppage.clickOnSaveButton();
 			 customergrouppage.searchBox(customergroupname);
 			 customergrouppage.CustomergroupboxFinder(customergroupname);
			 Assert.assertEquals(customergrouppage.searchBox(customergroupname),customergrouppage.CustomergroupboxFinder(customergroupname));
 			 
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddUnits() throws IOException {
        	 
			 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 unitspage.clickOnProductsOption();
        	 unitspage.clickOnUnitsOption();
        	 unitspage.clickOnAddbutton();
             String name=unitspage.insertUnits(excelfilepath7,"Sheet1");
 			 unitspage.clickOnSaveButton();
 			 unitspage.enterUserSearchbutton(name);
 			 unitspage.nameBoxFinder(name);
 			 Assert.assertEquals(unitspage.enterUserSearchbutton(name),unitspage.nameBoxFinder(name));
		}
         @Test(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddCategories() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
 			 categoriespage.clickOnProductsOption();
        	 categoriespage.clickOnCategoriesOption();
        	 categoriespage.clickOnAddButton();
 		     String categoriesname=categoriespage.insertOnCategoriesNameBox(excelfilepath6,"Sheet1");
 			 categoriespage.insertOnCategoryCodeBox();
 			 categoriespage.clickOnSaveButton();
 			 categoriespage.enterCategorysearchBox(categoriesname);
 			 categoriespage.brandNameBoxFinder(categoriesname);
 			 Assert.assertEquals(categoriespage.enterCategorysearchBox(categoriesname),categoriespage.brandNameBoxFinder(categoriesname));
 		}
         @Test//(retryAnalyzer = RetryAnalyzer.class)
         public void verifyAddBrand() throws IOException {
        	 
        	 loginpage.loginToQAlegend(prop.getProperty("username"),prop.getProperty("password"));
        	 brandspage.clickOnProductsOption();
 			 brandspage.clickOnBrandsOption();
 			 brandspage.clickOnAddButton();
 			 String brandname=brandspage.insertOnBrandNameBox(excelfilepath5,"Sheet1");
 			 brandspage.insertOnshortdiscriptionBox();
 			 brandspage.clickOnSaveButton();
 			 brandspage.enterBrandsearchBox(brandname);
 			 brandspage.brandnameBoxFinder(brandname);
 		     Assert.assertEquals(brandspage.brandnameBoxFinder(brandname),brandname);   
 		}
         
}
