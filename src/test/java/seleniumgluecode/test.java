package seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class test {
    public static WebDriver driver;
    
    // Set the location of the driver downloaded on your drive
    public static final String Firefox_Driver_Location = "/Users/tourajvaziri/Desktop/geckodriver";

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
    	System.setProperty("webdriver.gecko.driver", Firefox_Driver_Location);
    	driver = new FirefoxDriver();
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tourajvaziri.info/");
    }
    
    @When("^user enters Name, Email, Message and clicks Submit$")
    public void user_enters_Name_Email_Message_and_clicks_Submit() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.id("contactName")).sendKeys("Test");
    	Thread.sleep(1000);
    	driver.findElement(By.id("contactEmail")).sendKeys("Test@test.com");
    	Thread.sleep(1000);
        driver.findElement(By.id("contactMessage")).sendKeys("Test Message");
    	Thread.sleep(1000);
        driver.findElement(By.id("submitEmail")).click();   
    }

    @Then("^submission success message is displayed$")
    public void submission_success_message_is_displayed() throws Throwable {
    	String exp_message = "Your form submission has been received.\n" + 
    			"← Back to our site";
    	String actual = driver.findElement(By.cssSelector(".body")).getText();
        Assert.assertEquals(exp_message, actual);
    	Thread.sleep(2000);
        driver.quit();  
    }

}
