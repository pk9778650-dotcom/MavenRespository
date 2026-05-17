package com.baseClass;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseClass {
    public static WebDriver driver;

    protected static void launchBrowser(String browser){

        try{
            if(browser.equalsIgnoreCase("Chrome")){
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING LAUNCH BROWSER");
        }
        driver.manage().window().maximize();

    }
       //Launch Url
    protected static void launchUrl(String url){

        try{
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING LAUNCH URL");
        }
    }
    //NavigateTo
protected static void navigateTo(String url){
try{
    driver.navigate().to(url);
} catch (Exception e){
    Assert.fail("ERROR : OCCURED DURING NAVIGATION TO");
}
        }
        //Navigation Methods
    protected static void navigationMethods(String type){
        try{
            if(type.equalsIgnoreCase("forward")){
                driver.navigate().forward();
            } else if (type.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if (type.equalsIgnoreCase("refresh")) {
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING NAVIGATION METHODS");
        }
    }
    //SendKeys
    protected static void sendKeys(WebElement element,String value){
        try{
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE SENDKEYS");
        }
    }
    //CLICKS
    protected static void click(WebElement element){
        try{
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE CLICK");
        }
    }
    //ACTIONS
    protected static void performActions(WebElement element,String actionType){
        try{
            Actions action =new Actions(driver);
            if (actionType.equalsIgnoreCase("move")){
                action.moveToElement(element).perform();
            } else if (actionType.equalsIgnoreCase("rightClick")) {
                action.contextClick(element).perform();
            } else if (actionType.equalsIgnoreCase("doubleClick")) {
                action.doubleClick(element).perform();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE ACTIONS");
        }
    }
    //ROBOT
    protected static void robot(int keycode){
        try{
            Robot key =new Robot();
            key.keyPress(keycode);
        } catch (AWTException e) {
            Assert.fail("ERROR : OCCURED DURING THE KEYPRESS");
        }
    }
    //FRAMES
    protected static void switchToFrames(WebElement element,String frameType,int num){
   try{
       if (frameType.equalsIgnoreCase("index")){
           driver.switchTo().frame(Integer.parseInt(frameType));
       } else if (frameType.equalsIgnoreCase("name")) {
           driver.switchTo().frame(frameType);
       } else if (frameType.equalsIgnoreCase("element")) {
           driver.switchTo().frame(element);
       }
   } catch (Exception e) {
       Assert.fail("ERROR : OCCURED DURING THE SWITCH TO FRAMES");
   }
    }
    //DRAG AND DROP
    protected static void dragAndDrop(WebElement element,WebElement element1){
        try{
            Actions action = new Actions(driver);
            action.dragAndDrop(element, element1).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE DRAG AND DROP");
        }
    }
    //WINDOWS HANDLING
    protected static void windowsHandling(int number){
        try{
           List<String> allwindows = new ArrayList<>(driver.getWindowHandles());
           driver.switchTo().window(allwindows.get(number));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE WINDOWS HANDLNG");
        }
    }
    //SELECT OPTIONS
protected static void selectOptions(WebElement element,String type,String value){
        try{
            Select select = new Select(element);
            boolean multiple = select.isMultiple();
            System.out.print(multiple);
            if (type.equalsIgnoreCase("text")){
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE SELECT OPTIONS");
        }
}
//DESELECT OPTIONS
    protected static void deselectOptions(WebElement element,String type,String value){
        try{
            Select select = new Select(element);
            if (type.equalsIgnoreCase("text")){
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE DESELECT OPTIONS");
        }
    }
    //IMPLICIT WAIT
    protected static void implicitWait(String type,int num){
        try{
            if (type.equalsIgnoreCase("seconds")){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
            } else if (type.equalsIgnoreCase("minutes")) {
                driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(num));
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE IMPLICIT WAIT");
        }
    }
    //EXPLICIT WAIT
    protected static void explicitWait(WebElement element,String waitType,int num){
        try{
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(num));
            if (waitType.equalsIgnoreCase("vsible")){
            wait.until(ExpectedConditions.visibilityOf(element));
        } else if (waitType.equalsIgnoreCase("clikable")) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } else if (waitType.equalsIgnoreCase("presence")) {
            wait.until(ExpectedConditions.presenceOfElementLocated((By)element));
        }
    } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE EXPLICIT WAIT");
        }
    }
    //SCROLL DOWN
    protected static void scrollDown(int pixel){
        try{
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeAsyncScript("window.scrollBy(0," + pixel + ")","");
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE SCROLL DOWN");
        }
    }
    //SCROLL UP
    protected static void scrollUp(int pixel){
        try{
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeAsyncScript("window.scrollBy(0,-"+ pixel + ")","");
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE SCROLLUP");
        }
    }
    //IS ENABLED
    protected static void isEnabled(WebElement element){
        try{
            element.isEnabled();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE IS ENABLED");
        }
    }
    //IS DISABLED
    protected static void isDisplayed(WebElement element){
        try{
            element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE IS DISABLED");
        }
    }
    //GET TEXT
    protected static String getText(By locator){
        try{
            WebElement element = driver.findElement(locator);
            return element.getText();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE GET TEXT");
        }
        return "UNABLE TO GET TEXT";
    }
    //GET CURRENT URL
    protected static String getCurrentUrl(){
        try{
            return driver.getCurrentUrl();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURED DURING THE GET CURRENT URL");
        }
        return "UNABLE TO GET CURRENT URL";
    }
    //ALERT
    protected static void alert(String action,String value){
        try{
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(value);
            if(action.equalsIgnoreCase("accept")){
                alert.accept();
            } else if (action.equalsIgnoreCase("dsimiss")) {
                alert.dismiss();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING THE ALERTS");
        }
    }
}



















