import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * Created by vsinchuk on 27-Jul-16.
 */
public class TestDesktopChromeBrowser {

    WebDriver driver;

    @Test
    public void testGoogleSearch(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\vsinchuk\\Downloads\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("fob solutions");
        searchBox.submit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*
        try {
            driver.quit();
        } catch (Exception e){ System.out.println(" driver.quit() failed");}
*/


    }

    @After
    public void tearDown()
    {
        try {
            driver.quit();
        } catch (Exception e){ System.out.println(" driver.quit() failed");}
    }
}
