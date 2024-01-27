package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;

public class OrangeHRM {
	
	public static void main(String[] args) {
		
	}
	@Test
    public void Test() throws InterruptedException {
    	
        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver-win64/chromedriver.exe");

        String username = "Admin";
        String password = "admin123";

        // Open browser and navigate to the website
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);

        // Login with Admin account
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
        
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));   
        loginButton.click();

        // Wait for the login to complete
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the account name after login successfully
        WebElement welcomeMessage = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        String accountName = welcomeMessage.getText();
        System.out.println("Account Name: " + accountName);
        
        //Navigate to Admin page
        WebElement adminButton = driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']"));   
        adminButton.click();
        Thread.sleep(5000);


        // Close the browser
        driver.quit();
    }
}
