package FacebookAutomate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class DragAndDropAutomation {
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
            // Step 1: Open the browser and navigate to the jQueryUI droppable website
            driver.get("https://jqueryui.com/droppable/");
            
            // Switch to the frame that contains the droppable elements
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
            
            // Step 2: Find the source and target elements
            WebElement sourceElement = driver.findElement(By.id("draggable"));
            WebElement targetElement = driver.findElement(By.id("droppable"));
            
            // Step 3: Perform the drag and drop operation
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();
            
            // Step 4: Verify that the drag and drop operation is successful
            String targetText = targetElement.getText();
            if (targetText.equals("Dropped!")) {
                System.out.println("Drag and drop operation was successful.");
            } else {
                System.out.println("Drag and drop operation failed.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

