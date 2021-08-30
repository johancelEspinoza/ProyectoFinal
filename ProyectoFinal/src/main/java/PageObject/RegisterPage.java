package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    @FindBy(name = "firstname")
    WebElement input_firstname;

    @FindBy(name = "lastname")
    WebElement input_lastname;

    @FindBy(name = "email")
    WebElement input_email;

    @FindBy(name = "telephone")
    WebElement input_telephone;

    @FindBy(name = "password")
    WebElement input_password;

    @FindBy(name = "confirm")
    WebElement input_confirm;

    //@FindBy(xpath = "//div[@id='content']/h1")
    //WebElement message_confirmRegister;

    @FindBy(name = "agree")
    WebElement checkBox_term;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_continue;

    private By ConfirmRegisterMessageLocator = By.xpath("//div[@id='content']/h1");

    public RegisterPage(WebDriver _driver){
        super(_driver);
        PageFactory.initElements(driver, this);

    }    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }

    public  void FillForm(String firstName, String lastName, String email, String telephone, String password ) {
        input_firstname.sendKeys(firstName);
        input_lastname.sendKeys(lastName);
        input_email.sendKeys(email);
        input_telephone.sendKeys(telephone);
        input_password.sendKeys(password);
        input_confirm.sendKeys(password);
        checkBox_term.click();
        btn_continue.click();
    }
    public String GetConfirmationMessage(){
        return driver.findElement(ConfirmRegisterMessageLocator).getText();
    }



}//end
