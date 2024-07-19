package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * Reading login data from Properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Amulya
	 */
	public String getKeyAndValuePair(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ProjectProp.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String value = pro.getProperty(key);
		return value;
	}

}
