package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class StartPage extends BasePage {

private SelenideElement menuSelector = $(By.cssSelector(String.format(selector, "Next")));

public ChatPage openChatPage() {
    menuSelector.click();
    menuSelector.click();
    $(By.cssSelector(String.format(selector, "Skip >"))).click();
    return new ChatPage();
}

}
