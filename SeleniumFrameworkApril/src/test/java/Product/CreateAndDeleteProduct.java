package Product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utillity;
import io.github.bonigarcia.wdm.WebDriverManager;

        public class CreateAndDeleteProduct {

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
		 		
		 		driver.findElement(By.linkText("Products")).click();
			     driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			     
			 	
			 		/* ran = new Random();
			 		int rannum = ran.nextInt(1000);*/
			     
			     Java_Utility jlib = new Java_Utility();
		         int ranNum = jlib.getRandonNum();
		         
			 		
			 		/*FileInputStream fes = new FileInputStream("./src/test/resources/ExcelSheet1.xlsx");
			 		Workbook book = WorkbookFactory.create(fes);
			 		 Sheet sheet = book.getSheet("Product");
			 		 Row row = sheet.getRow(0);
			 		 Cell cel =row.getCell(0);
			 		 String exceldata = cel.getStringCellValue()+ranNum;*/
		         
		         
		         Excel_Utility elib = new Excel_Utility();
		         String exceldata = elib.getExcelData("Product", 0, 0)+ranNum;
			 		 
			 		 
			 		 driver.findElement(By.name("productname")).sendKeys(exceldata);
			 		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 		  
			 		 String actData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
	                 
	                 System.out.println(actData);
			 		 
			 		 if(actData.contains(exceldata))
			 		 {
			 			 System.out.println("pass");
			 		 }
			 		 else
			 		 {
			 			 System.out.println("fail");
			
			 		 }
			 		 
			 		
			 		 driver.findElement(By.xpath("//a[text()='Products']")).click();
			 		 
			 		 driver.findElement(By.xpath("//table[@class='lvt small']/tbody//a[text()='"+exceldata+"']/../preceding-sibling::td[2]")).click();
			 		 
			 		driver.findElement(By.xpath("//input[@value='Delete']")).click();
			      	Alert alt = driver.switchTo().alert();
			      	alt.accept();
			      	
			      	
			      	List<WebElement> Lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
			      	
			
				boolean flag = false;
			      for(WebElement wb:Lists)
			      {
			    	 String act = wb.getText();
			    	  if(act.contains(exceldata))
			    	  {
			    		  flag=true;
			    		  break;
			    	  }
			      }
			    	  if(flag)
			    	  {
			    		  System.out.println("Deleted");
			    	  }
			    	  else
			    	  {
			    		  System.out.println("Not Deleted");
			    	  }
			    	  
			    	  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			    	  driver.findElement(By.linkText("Sign Out")).click();
			    	  
	}

}
