package pageobjectmodel;

import com.baseClass.BaseClass;
import com.interfaceElements.SearchProductInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends BaseClass implements SearchProductInterfaceElements {

    @FindBy(linkText = laptops_xpath)
    private static WebElement laptops;

    @FindBy(linkText = macbook_xpath)
    private static WebElement macbook;

    @FindBy(linkText = addToCart_xpath)
    private static WebElement addToCart;


    public SearchProduct() { PageFactory.initElements(driver,this);}
    public static void validSearch() throws InterruptedException{

        Thread.sleep(10000);
        click(laptops);

        click(macbook);
        click(addToCart);
    }
}
