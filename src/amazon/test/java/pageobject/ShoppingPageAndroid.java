package amazon.test.java.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPageAndroid implements ShoppingPage {

    private AppiumDriver _driver;
    public ShoppingPageAndroid(AppiumDriver driver) {
        _driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\")")
    private MobileElement searchEditText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"title\")")
    private MobileElement titleTextView;

    //This is the step to scroll into the view area then find the value
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"priceblock_ourprice\"))")
    private MobileElement priceTextView;

    public void validateProductInfo(String productName) {
        searchEditText.click();
        searchEditText.sendKeys(productName);
        ((AndroidDriver) _driver).pressKeyCode(AndroidKeyCode.ENTER);

        //Find any random product by regular expression
        String randomTVUiSelector="new UiSelector().textContains(\"65\").textContains(\"TV\").textContains(\"$\")";

        WebElement randomTvProduct= ((AndroidDriver) _driver).findElementByAndroidUIAutomator(randomTVUiSelector);

        String productDescriptionListing = randomTvProduct.getText();

        randomTvProduct.click();

        String  productDescriptionCheckOut = titleTextView.getText();

        String  productPriceCheckOut = priceTextView.getText();

        Assert.assertTrue("The product description text matched",productDescriptionCheckOut.contains(productDescriptionListing.substring(0, productDescriptionListing.indexOf("..."))));
        Assert.assertTrue("The price matched",productDescriptionListing.contains(productPriceCheckOut));

    }
}
