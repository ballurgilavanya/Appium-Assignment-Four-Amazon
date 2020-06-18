package amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonutils {
	public static AndroidDriver driver;
	

	public static Properties prop=new Properties();
	public static String device_name;
	public static String automation_name;
	public static String platform_version;
	public static String platform_name;
	public static String browser_name;

	public static void loadproperties(String propertyFileName) throws IOException
	
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		
		FileInputStream fis=new FileInputStream((classpathRoot)+"/src/test/java/amazon/global.properties");
		prop.load(fis);
		device_name=prop.getProperty("device.name");
		automation_name=prop.getProperty("automation.name");
		platform_version=prop.getProperty("platform.version");
		platform_name=prop.getProperty("platform.name");
		browser_name=prop.getProperty("browser.name");
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void setCapabilities() throws MalformedURLException
	{
		
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"/src/main/drivers/chromedriver.exe");
		Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation_name);
		Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		Capabilities.setCapability("platformName", platform_name);
	    Capabilities.setCapability("browserName",browser_name);
	    Capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		
	}
	
	public static AndroidDriver getDriver() {
		return driver;
	}
}
