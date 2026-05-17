package pageobjectmodel;

import com.baseClass.BaseClass;
import com.interfaceElements.LoginInterfaceElements;
import com.pageObjectManager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass implements LoginInterfaceElements {

    @FindBy(linkText = login_linkText)
    private static WebElement login;

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy(id = password_id)
    private static WebElement password;

    @FindBy(xpath = signin_xpath)
    private static WebElement signin;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
    public static void validLogin() throws InterruptedException{
        click(login);
        Thread.sleep(5000);
        sendKeys(username,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
        sendKeys(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
        click(signin);

    }





}







