package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vsinchuk on 27-Jul-16.
 */
public class ClientSteps {

    WebDriver driver = new FirefoxDriver();

    @Given("^the user is on landing page$")
    public void setup() throws Throwable {
        driver.get("http://accountsdemo.herokuapp.com");
        driver.manage().window().maximize();
    }


    @When("^he chooses to sign up$")
    public void he_chooses_to_sign_up() throws Throwable {
        driver.findElement(By.linkText("Sign up")).click();

        // website is slow,  need to wait
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @And("^he provides the first name as ([^\"]*)$")
    public void he_provides_the_first_name_as(String firstName) throws Throwable {
        driver.findElement(By.id("user_first_name")).sendKeys(firstName);
    }


    @And("^he provides the last name as ([^\"]*)$")
    public void he_provides_the_last_name_as(String lastName) throws Throwable {
        driver.findElement(By.id("user_last_name")).sendKeys(lastName);
    }

    @And("^he provides the email as ([^\"]*)$")
    public void he_provides_the_email_as(String email) throws Throwable {
        driver.findElement(By.id("user_email")).sendKeys(email);
    }

    @And("^he provides the password as ([^\"]*)$")
    public void he_provides_the_password_as(String password) throws Throwable {
        driver.findElement(By.id("user_password")).sendKeys(password);
    }

    @And("^he provides the confirm password again as ([^\"]*)$")
    public void he_provides_the_confirm_password_again_as(String confirmPassword) throws Throwable {
        driver.findElement(By.id("user_password_confirmation")).sendKeys(confirmPassword);
    }


    @And("^he signs-up$")
    public void he_signs_up() throws Throwable {
        driver.findElement(By.name("commit")).click();
    }

    @Then("^he should be logged in to the application$")
    public void he_should_be_logged_in_to_the_application() throws Throwable {
        boolean signOutLinkDisplayed = driver.findElement(By.cssSelector("a[href='/users/sign_out']")).isDisplayed();
        Assert.assertTrue(signOutLinkDisplayed);
    }
}
