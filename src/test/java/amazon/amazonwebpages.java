package amazon;


import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import amazon.commonutils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;

public class amazonwebpages {
public static AndroidDriver driver;
	
public static void launchwebsite() {
driver=commonutils.getDriver();
driver.get("http://www.amazon.com");
}
public static void searchappiumbook() 
{
driver.findElement(By.name("k")).sendKeys("Appium Book");
driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div/input")).click();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

}

public static void seltenthbook()
{
	
driver.findElement(By.xpath("//*[@id=\"search\"]/span[3]/div[2]/div[4]/div/span/div/div/div[1]/a/div/div/div/span/div/img")).click();

}

public static void printrating()
{
WebElement element = null;
if(driver.findElement(By.xpath("//*[@id=\"aw-udpv3-customer-reviews_feature_div\"]/span[1]/div/div/a/div/div/div[1]/span")).isDisplayed())

element = (MobileElement) driver.findElement(By.xpath("//*[@id=\"aw-udpv3-customer-reviews_feature_div\"]/span[1]/div/div/a/div/div/div[1]/span"));
System.out.println(element.getText());

}

public static void addappiumbooktocart()
{

	if (driver.findElements(By.xpath("//android.widget.Button[@text,'Add to Cart']")).isEmpty())
{
	driver.findElement(By.xpath("//*[@id=\"one-click-button\"]")).click();
}
else
{
	
	driver.findElement(By.xpath("//android.widget.Button[@text,'Add to Cart']")).click();

}
}

public static void searchseleniumbook()
{
driver.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]")).click();
driver.findElement(By.name("k")).sendKeys("Selenium Book");
driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div/input")).click();
driver.findElement(By.xpath("//*[@id=\"search\"]/span[3]/div[2]/div[8]/div/span/div/div/div[1]/a/div/div/div/span/div/img")).click();
}

public static void printusercomments()
{
WebElement bb=driver.findElement(By.xpath("//*[@id=\"customer_review-R1DT7V9DYNS9CB\"]/span/div[1]/span[1]"));
}

public static void addseleniumbooktocart()
{

if (!driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).isDisplayed())
{

driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
}

else{

driver.findElement(By.xpath("//*[@id=\"one-click-button\"]")).click();
}
}

public static void pritntotalamount()
{
driver.findElement(By.xpath("//*[@id=\"nav-button-cart\"]/div/i")).click();
WebElement price=driver.findElement(By.xpath("//*[@id=\"sc-proceed-to-checkout-params-form\"]/div[2]/span[2]/span"));
System.out.println(price);
}

}

