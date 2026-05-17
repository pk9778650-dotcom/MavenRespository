package runner;

import com.utility.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunnerClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String username = ReadExcelData.readParticularData(2,1);
        driver.findElement(By.name("email")).sendKeys(username);
        String password = ReadExcelData.readParticularData(2,2);
        driver.findElement(By.name("pass")).sendKeys(password);

        System.out.println("asdfghjhgfdsa");
    }
}
