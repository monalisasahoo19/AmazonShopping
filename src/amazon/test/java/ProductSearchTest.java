package amazon.test.java;

import org.junit.Test;

public class ProductSearchTest extends BaseTestClass {

    @Test
    public void VerifyTheProductDetailBetweenSearchAndCheckOutScreen()  {

        //Please set your own userName and password while running the test
        //It will ask for the OPT you need to setup that I mentioned in the implementation step.
        //This setup will be skipped to run automatically with the following line if you want to setup the user manually one-off.
        //AppiumController.java - Line41 -- capabilities.setCapability("fullReset","false");
        signInPage.signIn("amazonShoppingUserName","amazonShoppingPassword");

        //Asset the Product details if they match between both search result listing and checkout page.
        shoppingPage.validateProductInfo("65-inch TV");
    }

}
