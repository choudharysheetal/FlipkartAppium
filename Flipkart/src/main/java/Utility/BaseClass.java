package Utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
/**
 * This class contains basic common configuration
 * @author 
 *
 */
public class BaseClass {
	public AndroidDriver<WebElement> driver=UtilityObjectClass.getDriver();
	public String packageName;
	public String appActivity;
	public String platformName;
	public String platformVerson;
	public String deviceID;
	public String serverUrl;
	public ExcelUtility excelUtility;
	public String timeouts;
	public JavaUtility javaUtility;
	public long longTimeouts;
	public AndroidDriverUtility androidDriverUtility;
	@BeforeSuite
	public void suiteSetup() {
		androidDriverUtility=new AndroidDriverUtility();
		FileUtility fileUtility=new FileUtility();
		fileUtility.initializePropertyFile(IConstants.PROPERTYFILEPATH);
		excelUtility=new ExcelUtility();
		excelUtility.initializeExcelFile(IConstants.EXCELFILEPATH);
		packageName=fileUtility.getDataFromPropertyfile("packageName");
		appActivity=fileUtility.getDataFromPropertyfile("appActivity");
		platformName=fileUtility.getDataFromPropertyfile("platformName");
		platformVerson=fileUtility.getDataFromPropertyfile("platformVerson");
		deviceID=fileUtility.getDataFromPropertyfile("deviceID");
		serverUrl=fileUtility.getDataFromPropertyfile("url");
		timeouts=fileUtility.getDataFromPropertyfile("timeouts");
		javaUtility=new JavaUtility();
		longTimeouts=javaUtility.convertStringToLong(timeouts);
		
	}
	@AfterSuite()
	public void suiteTeardown(){
		excelUtility.closeExcelWorkbook();
	}
	@BeforeMethod
	public void openApp() throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVerson);
		cap.setCapability(MobileCapabilityType.UDID,deviceID);
		//cap.setCapability("noReset",true);
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		cap.setCapability("appPackage", packageName);
		cap.setCapability("appActivity", appActivity);
		//cap.setCapability("noReset",true);
		driver=new AndroidDriver<WebElement>(new URL(serverUrl),cap);
		UtilityObjectClass.setDriver(driver);
		androidDriverUtility.implicitlyWait(longTimeouts);
		
	}
	@AfterMethod
	public void closeApp() {
		driver.closeApp();
	}
}
