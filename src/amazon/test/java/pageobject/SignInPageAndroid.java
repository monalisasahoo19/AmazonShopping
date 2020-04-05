package amazon.test.java.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class SignInPageAndroid implements SignInPage {

    public SignInPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/sign_in_button\")")
    private MobileElement alreadyACustomerSignButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_accordion_header\").text(\"Sign-In. Already a customer?\")")
    private MobileElement alreadyACustomerSignRadioButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_email_login\")")
    private MobileElement emailUserNameEditText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"continue\")")
    private MobileElement continueButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_password\")")
    private MobileElement passwordEditText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"signInSubmit\")")
    private MobileElement signInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Email a one-time passcode to\")")
    private MobileElement emailOTPRadioButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private MobileElement emailOTPEditText;


    public void signIn(String amazonUserName,String amazonPassword) {

        try {
            alreadyACustomerSignButton.click();
            alreadyACustomerSignRadioButton.click();
            emailUserNameEditText.sendKeys(amazonUserName);
            continueButton.click();
            passwordEditText.sendKeys(amazonPassword);
            signInButton.click();
            //This can be automated through Push
            //For the given apk push notification is not being received
            //Hence considered email with manual intervention
            emailOTPRadioButton.click();
            continueButton.click();

            String otp = "1234";

            passwordEditText.sendKeys(otp);
            continueButton.click();
        }catch (NoSuchElementException ex){

            System.out.println("User is already logged in");

        }

    }
}
