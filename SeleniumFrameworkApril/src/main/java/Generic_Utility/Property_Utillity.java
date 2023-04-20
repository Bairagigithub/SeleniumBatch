package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utillity {

	public String getStringKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData1.properties");
        Properties pro = new Properties();
        pro.load(fis);
        String value = pro.getProperty(key);	
		return value;
		
	}
	
}
