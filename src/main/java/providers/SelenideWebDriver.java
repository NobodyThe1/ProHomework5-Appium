package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class SelenideWebDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        File app = downloadApk();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("device");
        options.setPlatformVersion("5.1");
        options.setAppPackage("com.pyankoff.andy");
        options.setAppActivity(".MainActivity");
        options.setApp(app.getAbsolutePath());

        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
        private File downloadApk () {
            File apk = new File("Andy-253457-d7ad79.apk");
            String url = "https://github.com/NobodyThe1/ProHomework5-Appium/blob/main/Andy-253457-d7ad79.apk";
            InputStream in = null;
            try {
                in = new URL(url).openStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                copyInputStreamToFile(in, apk);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return apk;

        }
    }
