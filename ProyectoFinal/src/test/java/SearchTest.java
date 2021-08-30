import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass{

    @Description("Case 2")
    @Test
    public void Test_Search() {

        //Setup
        String search ="Macbook";
        String expectedMessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String errorExpectedMessage = "Products marked with *** are not available in the desired quantity or not in stock!\n" +
                "×";

        searchProduct().Search(search);

        //Validations
        Assert.assertEquals(searchProduct().GetProductConfirmationMessage(),expectedMessage);

        searchProduct().CheckCart();

        Assert.assertEquals(searchProduct().GetProductErrorMessage(),errorExpectedMessage);


    }
}
