package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImpl implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("------taking screenshot------");
		String screenshot = null;
		try {
			screenshot = WebDriver_Utility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentsReportFile/Report"+ranNum+".html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("AutomationTesting");
		spark.config().setReportName("Amulya");
		
		report = new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("Executed By", "Amulya");
		report.setSystemInfo("Reviewed By", "Sai");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
