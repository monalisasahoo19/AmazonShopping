package amazon.test.java.appiumSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS
    }

    public static AppiumController instance = new AppiumController();

    public AppiumDriver driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (executionOS) {
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File(appDir, "Amazon_shopping.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "HT6B40203455");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
                capabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
                capabilities.setCapability("noReset","true");
                //If you won't like to un-install the apk before each run
                //So, yo can able to setup one-time username and password for login and will be persisted for all the sessions.
                capabilities.setCapability("fullReset","false");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
                //TODO
                break;
        }

       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
