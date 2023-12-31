package extensions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import providers.SelenideWebDriver;

public class AppiumExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Configuration.browserSize = null;
        Configuration.browser = SelenideWebDriver.class.getName();
        Configuration.timeout = Long.parseLong("15000");
    }
}
