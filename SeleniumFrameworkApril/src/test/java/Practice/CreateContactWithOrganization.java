package Practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Property_Utillity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {
		
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
	 		
	 		
	 		  
	 		 driver.findElement(By.linkText("Organizations")).click();
	 		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 		Random ran1 = new Random();
	 		int ranNum1 = ran1.nextInt(1000);
	 		
	 		/*FileInputStream fes1 = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
	 		Workbook book1 = WorkbookFactory.create(fes1);
	 		 Sheet sheet1 = book1.getSheet("Organization");
	 		 Row row1 = sheet1.getRow(2);
	 		 Cell cel1 =row1.getCell(1);
	 		 String Exceldata = cel1.getStringCellValue()+rannum1;*/
	 		
	 		 Excel_Utility elib = new Excel_Utility();
	         String Exceldata = elib.getExcelData("Organization", 0, 0)+ranNum1;
	 		 
	 		 
	 		driver.findElement(By.name("accountname")).sendKeys(Exceldata);
	 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 		Thread.sleep(2000);

	 		
	 		  driver.findElement(By.linkText("Contacts")).click();
		      driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		      Random ran = new Random();
		 		int ranNum = ran.nextInt(1000);
		 		
		 		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
		 		Workbook book = WorkbookFactory.create(fes);
		 		 Sheet sheet = book.getSheet("Contact");
		 		 Row row = sheet.getRow(0);
		 		 Cell cel =row.getCell(0);
		 		 String exceldata = cel.getStringCellValue()+rannum;*/
		 		
		 		 Excel_Utility elib1 = new Excel_Utility();
		         String exceldata = elib1.getExcelData("Contact", 0, 0)+ranNum;
		 		 
		 		 driver.findElement(By.name("lastname")).sendKeys(exceldata);
		 		  //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 		 
		 		 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		 		 driver.findElement(By.name("search_text")).sendKeys("Exceldata");
		 
		 		  
		 		  
		 		
	}

}
