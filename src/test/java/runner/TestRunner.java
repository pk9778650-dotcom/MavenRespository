package runner;

import com.baseClass.BaseClass;
import com.pageObjectManager.PageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestRunner extends BaseClass {
  public static void main(String[] args) throws InterruptedException {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();

    // public static void main(String[] args) {
      //  launchBrowser("chrome");
        //launchUrl("https://www.facebook.com/");
        //implicitWait("seconds",5);
         //WebElement element = driver.findElement(By.name("email"));
         //explicitWait(element,"visible",5);
         //WebElement element1 = driver.findElement(By.name("email"));
         //sendKeys(element,"abinash1597");
         //selectOptions(element,"index","2");
         //windowsHandling(2);

    }
    }

