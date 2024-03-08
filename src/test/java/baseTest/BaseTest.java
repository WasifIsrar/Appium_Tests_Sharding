package baseTest;

import org.testng.annotations.AfterMethod;
import java.net.URL;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	AndroidDriver driver;
	private ThreadLocal<AndroidDriver> driverThreadLocal = new ThreadLocal<>();

	
	@BeforeMethod
	@Parameters({"udid","systemPort"})
	public void setup(String udid,int systemPort) {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setCapability("udid",udid);
		options.setApp("App Path");
		options.setCapability("autoGrantPermissions",true);
		options.setSystemPort(systemPort);
		try {
			driver = new AndroidDriver(new URL("http://localhost:4723"), options);
		    setDriver(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public void tearDown() {
		AndroidDriver driver=getDriver();
		if(driver!=null) {
				driver.quit();
		        driverThreadLocal.remove();
				}
			}
	
	protected AndroidDriver getDriver() {
	    return driverThreadLocal.get();
	}

	protected void setDriver(AndroidDriver driver) {
	    driverThreadLocal.set(driver);
	}
}