package FacebookAutomate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpAutomation {
    public static void main(String[] args) {
        // Set up the WebDriver and the path to the driver executable
        // For Chrome:
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        // For Firefox:
        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        // WebDriver driver = new FirefoxDriver();
        
        // For Safari (SafariDriver comes bundled with the browser):
        // WebDriver driver = new SafariDriver();
        
        try {
            // Step 1: Open the browser and navigate to Facebook
            driver.get("https://www.facebook.com/");
            
            // Step 2: Verify that the website has been redirected to the Facebook homepage
            if (!driver.getTitle().contains("Facebook")) {
                System.out.println("Failed to load Facebook homepage.");
                return;
            }
            
            // Step 3: Click on the "Create new account" button
            WebElement createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
            createAccountButton.click();
            
            // Wait for the sign-up form to be visible
            Thread.sleep(2000); // Adjust this sleep time as needed
            
            // Step 4: Enter first name, last name, email, and password
            WebElement firstNameField = driver.findElement(By.name("firstname"));
            WebElement lastNameField = driver.findElement(By.name("lastname"));
            WebElement emailField = driver.findElement(By.name("reg_email__"));
            WebElement passwordField = driver.findElement(By.name("reg_passwd__"));
            
            firstNameField.sendKeys("Test");
            lastNameField.sendKeys("User");
            emailField.sendKeys("testuser@test.com");
            passwordField.sendKeys("YourStrongPassword123!");
            
            // Step 5: Enter the date of birth
            Select dayDropdown = new Select(driver.findElement(By.name("birthday_day")));
            Select monthDropdown = new Select(driver.findElement(By.name("birthday_month")));
            Select yearDropdown = new Select(driver.findElement(By.name("birthday_year")));
            
            dayDropdown.selectByVisibleText("11");
            monthDropdown.selectByVisibleText("May");
            yearDropdown.selectByVisibleText("1985");
            
            // Step 6: Select the gender
            WebElement genderRadioButton = driver.findElement(By.xpath("//input[@name='sex' and @value='2']")); // 2 for Female, 1 for Male
            genderRadioButton.click();
            
            // Step 7: Click on the "Sign Up" button
            WebElement signUpButton = driver.findElement(By.name("websubmit"));
            signUpButton.click();
            
            // Step 8: Verify the user registration
            // This step is difficult to automate completely because it involves email verification and CAPTCHA challenges.
            // You can, however, check if the current URL has changed or check for any specific elements on the redirected page.
            
            Thread.sleep(5000); // Adjust this sleep time as needed to allow for page load
            
            if (driver.getCurrentUrl().contains("facebook.com/reg")) {
                System.out.println("User registration appears to have been initiated.");
            } else {
                System.out.println("User registration failed or additional verification is required.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


