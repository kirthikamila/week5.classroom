package week5.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnNestedFrame {

	public static void main(String[] args) {
		 ChromeDriver driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         // switch to frame
         driver.switchTo().frame("iframeResult");
        // Click the "Try It" button
         WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
         tryItButton.click();
        // Handle the alert
         Alert alert = driver.switchTo().alert();
         String alertText = alert.getText();
         System.out.println("Alert Text: " + alertText);
       // Accept or dismiss the alert
         alert.accept(); // Use alert.dismiss() to cancel
      // Verify the displayed text
         WebElement resultText = driver.findElement(By.id("demo"));
         String displayedText = resultText.getText();
         System.out.println("Displayed Text: " + displayedText);
      // Conditional verification
         if (displayedText.contains("OK")) {
             System.out.println("Alert accepted successfully!");
         } else if (displayedText.contains("Cancel")) {
             System.out.println("Alert dismissed successfully!");
         } else {
             System.out.println("Unexpected result!");
         }

	}

}
