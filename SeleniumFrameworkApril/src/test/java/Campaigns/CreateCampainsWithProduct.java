package Campaigns;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utillity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampainsWithProduct {
	
	public static void main (String[]args) throws Throwable{
	
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	/*FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData1.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	driver.get(URL);*/
	
	
	Property_Utillity plib = new Property_Utillity();
	String URL = plib.getStringKeyAndValue("url");
	String USERNAME = plib.getStringKeyAndValue("username");
	String PASSWORD = plib.getStringKeyAndValue("password");
	driver.get(URL);
	
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
 		
 		driver.findElement(By.linkText("Products")).click();
	     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	     
	 	
	 		/*Random ran1 = new Random();
	 		int Rannum = ran1.nextInt(1000);*/
	     
	     Java_Utility jlib = new Java_Utility();
         int ranNum = jlib.getRandonNum();
	 		
	 		/*FileInputStream fes1 = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
	 		Workbook book1 = WorkbookFactory.create(fes1);
	 		 Sheet sheet1 = book1.getSheet("Product");
	 		 Row row1 = sheet1.getRow(0);
	 		 Cell cel1 =row1.getCell(0);
	 		 String ProductName = cel1.getStringCellValue()+ranNum;*/
         
         
         Excel_Utility elib = new Excel_Utility();
         String ProductName = elib.getExcelData("Product", 0, 0)+ranNum;
	 		 
	 		 
	 		 driver.findElement(By.name("productname")).sendKeys(ProductName);
	 		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 		  
	 		  
	 		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	         Actions act = new Actions(driver);
	         act.moveToElement(ele).perform();
	         driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
	         driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	         

		 		/*Random ran = new Random();
		 		int rannum = ran.nextInt(1000);*/
	         
	         Java_Utility jlib1 = new Java_Utility();
	         int ranNum1 = jlib1.getRandonNum();
		 		
		 		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
		 		Workbook book = WorkbookFactory.create(fes);
		 		 Sheet sheet = book.getSheet("Campaigns");
		 		 Row row = sheet.getRow(0);
		 		 Cell cel =row.getCell(0);
		 		 String exceldata = cel.getStringCellValue()+ranNum1;*/
	         
	         
	         Excel_Utility elib1 = new Excel_Utility();
	         String exceldata = elib1.getExcelData("Campaigns", 0, 0)+ranNum;
	         
                 driver.findElement(By.name("campaignname")).sendKeys(exceldata);
                 
                 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
                 Thread.sleep(1000);
                 Set<String> allwin = driver.getWindowHandles();
                Iterator<String> id = allwin.iterator();
                
                while(id.hasNext())
                {
                	String wid = id.next();
                	driver.switchTo().window(wid);
                	String title = driver.getTitle();
                if(title.contains("Products&action"))
                {
                	break;
                }
                }
                 
                driver.findElement(By.name("search_text")).sendKeys(ProductName);
                driver.findElement(By.name("search")).click();
                driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
                
                
                Set<String> allwin1 = driver.getWindowHandles();
                Iterator<String> id1 = allwin1.iterator();
                
                while(id1.hasNext())
                {
                	String wid1 = id1.next();
                	driver.switchTo().window(wid1);
                	String title1 = driver.getTitle();
                if(title1.contains("Products&action"))
                {
                	break;
                }
                }
                
               driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
                
               Thread.sleep(3000);
		 		 
		 		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 		 
		 		 driver.findElement(By.linkText("Sign Out")).click();
                
                
                
                
	 		  

}
}