package amazon.test.java;

import amazon.test.java.appiumSupport.AppiumBaseClass;
import amazon.test.java.appiumSupport.AppiumController;
import amazon.test.java.pageobject.*;
import org.junit.After;
import org.junit.Before;


public class BaseTestClass extends AppiumBaseClass {

    SignInPage signInPage;
    ShoppingPage shoppingPage;

    @Before
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
                signInPage = new SignInPageAndroid(driver());
                shoppingPage = new ShoppingPageAndroid(driver());
                break;
            case IOS:
                //For illustration purpose , iOS is not implemented
                signInPage = new SignInPageIOS(driver());
                break;
        }
    }

    @After
    public void tearDown() {
        AppiumController.instance.stop();
    }
}