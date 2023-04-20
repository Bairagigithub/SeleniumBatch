package Organization;

import java.io.FileInputStream;
import java.time.Duration;
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

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
	

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		
		
		
		/*Random ran = new Random();
		int rannum = ran.nextInt(1000);*/
		
		 Java_Utility jlib = new Java_Utility();
         int ranNum = jlib.getRandonNum();
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		 Sheet sheet = book.getSheet("Organization");
		 Row row = sheet.getRow(2);
		 Cell cel =row.getCell(1);
		 String exceldata = cel.getStringCellValue()+ranNum;*/
         
         
         Excel_Utility elib = new Excel_Utility();
         String exceldata = elib.getExcelData("Organization", 0, 0)+ranNum;
         String PhoneNum = elib.getExcelUsingDataFormatter("Organization", 1, 0)+ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(exceldata);
		driver.findElement(By.name("phone")).sendKeys(PhoneNum);
    
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
      /* String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		 System.out.println(actData);
		 
		 if(actData.contains(exceldata))
		 {
			 System.out.println("pass");
		 }
		 else
		 {
			 System.out.println("fail");
		 }*/
       
       Thread.sleep(3000);
       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       driver.findElement(By.linkText("Sign Out")).click();
	}



	}


