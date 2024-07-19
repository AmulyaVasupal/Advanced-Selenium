package Generic_Utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Java_Utility;

public class ListenerImplementations implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File des= new File("./Screenshots/failed"+ranNum+".png");
		try{
			FileUtils.copyFile(src, des);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
