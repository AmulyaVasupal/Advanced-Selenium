package Generic_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mysql.cj.jdbc.Driver;

import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	public File_Utility flib =new File_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public Java_Utility jlib = new Java_Utility();
	public Excel_Utility exe = new Excel_Utility();
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void beforeSuiteMethod() throws Throwable {
		System.out.println("database connection open");
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void beforeTestMethod() {
		System.out.println("parallel execution start");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void beforeClassMethod() throws Throwable {
		System.out.println("brpwser launch");
		File_Utility flib =new File_Utility();
		
        String BROWSER = flib.getKeyAndValuePair("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else
		{
			if(BROWSER.equalsIgnoreCase("edge")) {
				 driver= new EdgeDriver();
			}
			else
			{
				driver = new ChromeDriver();
			}
		}
		sDriver = driver;
	}
	
	//@Parameters("USERNAME")
	//@Parameters({"USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void beforeMethodMethod() throws Throwable {
	//public void beforeMethodMethod(String USERNAME) throws Throwable {
		System.out.println("login application");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
	    //String USERNAME = flib.getKeyAndValuePair("username");//comment this if passing parameter
		String PASSWORD = flib.getKeyAndValuePair("password");
		driver.get(URL);
		
		wlib.maximiseWindow(driver);
		wlib.implicitWait(driver);
		
		VtigerLoginPage vlp = new VtigerLoginPage(driver);		
		vlp.loginToVtigerApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void afterMethodMethod() {
		System.out.println("logout application");
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickAdmLink();
		home.clickSignOut();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void afterClassMethod() {
		System.out.println("close browser");
		driver.close();
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void afterTestMethod() {
		System.out.println("parallel execution end");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void afterSuiteMethod() throws Throwable {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details","root","database1");
		conn.close();
		System.out.println("database connection close");
	}
	
	
	
	
	
	


}
