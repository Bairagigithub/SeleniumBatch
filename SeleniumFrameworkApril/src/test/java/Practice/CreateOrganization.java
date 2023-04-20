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

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		
		/*String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();*/
		
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();*/
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		/*driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();*/
		
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        /* FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData1.properties");
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
 		
 		
 		
 		Random ran = new Random();
 		int ranNum = ran.nextInt(1000);
 		
 		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
 		Workbook book = WorkbookFactory.create(fes);
 		 Sheet sheet = book.getSheet("Organization");
 		 Row row = sheet.getRow(2);
 		 Cell cel =row.getCell(1);
 		 String exceldata = cel.getStringCellValue()+rannum;*/
 		
 		 Excel_Utility elib = new Excel_Utility();
         String exceldata = elib.getExcelData("Organization", 0, 0)+ranNum;
 		
 		driver.findElement(By.name("accountname")).sendKeys(exceldata);
     
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        driver.findElement(By.linkText("Sign Out")).click();

	}
	
	}


