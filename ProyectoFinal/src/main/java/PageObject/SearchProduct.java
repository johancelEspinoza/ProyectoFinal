package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct extends BasePage{

    @FindBy(name = "search")
    WebElement input_Search;

    @FindBy(xpath = "//span[@class = 'input-group-btn']")
    WebElement btn_Search;

    @FindBy(xpath = "//img[@title='MacBook']")
    WebElement img_Result;

    @FindBy(id = "button-cart")
    WebElement btn_AddCart;

    //@FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
    //WebElement msg_Success;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement btn_ShoppingCart;

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    WebElement btn_Checkout;

    //@FindBy(xpath = "//div[@class = 'alert alert-danger alert-dismissible']")
    //WebElement msg_Error;


    private By ConfirmProductMessageLocator = By.xpath("//div[contains(text(),'Success: You have added ')]");
    private By ErrorProductMessageLocator = By.xpath("//div[@class = 'alert alert-danger alert-dismissible']");


    public SearchProduct(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public  void Search(String search) {
    input_Search.sendKeys(search);
    btn_Search.click();
    img_Result.click();
    btn_AddCart.click();

    }

    public String GetProductConfirmationMessage() {
        return driver.findElement(ConfirmProductMessageLocator).getText();
    }


    public void CheckCart() {
        btn_ShoppingCart.click();
        btn_Checkout.click();
    }

    public String GetProductErrorMessage() {
        return driver.findElement(ErrorProductMessageLocator).getText();
    }


}//end
