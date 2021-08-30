import PageObject.Utils;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass{

    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: no match for e-mail address and/or password.";

    public By logOutButtonLocator = By.linkText("Logout");

    @Description("Case 1")
    @Test
    public void Test_Create_New_Account(){

        //SETUP
        String firstName = "Johancel";
        String lastName = "Espinoza";
        String email = Utils.generateRandomEmail();
        String telephone = "154879658";
        String password = "asdf";
        String expectedMessage = "Your Account Has Been Created!";

        //RUN
        registerPage().GoTo();
        registerPage().FillForm(firstName, lastName, email, telephone, password);

        //Validations
        Assert.assertEquals(registerPage().GetConfirmationMessage(), expectedMessage);

        //User logged
        WebElement logOutButton = driver.findElement(logOutButtonLocator);
        Assert.assertTrue(logOutButton.isDisplayed());
    }

}//end
