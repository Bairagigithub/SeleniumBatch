package Practice;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utillity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
	 		
	 		driver.findElement(By.linkText("Contacts")).click();
		     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		     
		 	
		 		/*Random ran = new Random();
		 		int rannum = ran.nextInt(1000);*/
		     
		         Java_Utility jlib = new Java_Utility();
		         int ranNum = jlib.getRandonNum();
		 		
		 		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
		 		Workbook book = WorkbookFactory.create(fes);
		 		 Sheet sheet = book.getSheet("Contact");
		 		 Row row = sheet.getRow(0);
		 		 Cell cel =row.getCell(0);
		 		 String exceldata = cel.getStringCellValue()+ranNum;*/
		         
		         Excel_Utility elib = new Excel_Utility();
		         String exceldata = elib.getExcelData("Contact", 0, 0)+ranNum;
		 		 
		 		 driver.findElement(By.name("lastname")).sendKeys(exceldata);
		 		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 		 Thread.sleep(2000);
		 		 
		 		 String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		 		 System.out.println(actData);
		 		 
		 		 if(actData.contains(exceldata))
		 		 {
		 			 System.out.println("pass");
		 		 }
		 		 else
		 		 {
		 			 System.out.println("fail");
		 		 }
		 		 
		 		
		 		/*WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); 
		 		Actions act = new Actions(driver);
		 		act.moveToElement(data).perform();
		 		driver.findElement(By.linkText("Sign Out")).click();*/
		 		
		 		 Thread.sleep(3000);
		 		 
		 		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 		 //driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 		 driver.findElement(By.linkText("Sign Out")).click();
	}

}
