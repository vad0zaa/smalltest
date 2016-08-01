import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by vsinchuk on 29-Jul-16.
 */
public class TestMobileBrowser {

    @Test
    public void openAndTestMobileBrowser() throws MalformedURLException {

        // Create object of  DesiredCapabilities class and specify android platform
        DesiredCapabilities capabilities=DesiredCapabilities.android();

        // set the capability to execute test in chrome browser
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);

        // set the capability to execute test in default browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "BROWSER");

        // set the capability to execute our test in Android Platform
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);

        // we need to define platform name
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        // Set the device name as well (you can give any name)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"vadim android emulator");

        //android avd 4.4.2 api19 , default browser
        capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.2");

        // Create object of URL class and specify the appium server address
        URL url= new URL("http://127.0.0.1:4723/wd/hub");

        // Create object of  AndroidDriver class and pass the url and capability that we created
        WebDriver driver = new AndroidDriver(url, capabilities);

        // set timeouts
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);

        // Open url
        driver.get("http://www.google.com");

        // print the title
        System.out.println("webpage title "+driver.getTitle());

        // enter text into search window
        driver.findElement(By.name("q")).sendKeys("fob solutions tallinn");

        // click on google otsing button
        driver.findElement(By.name("btnG")).click();

        //make a list of results and get the first one

/*        result = driver.find_elements_by_xpath("//ol[@id='rso']/li")[0];

        //  //click its href
        result.find_element_by_xpath("./div/h3/a").click();*/

        // close the browser
        driver.quit();


    }

}
