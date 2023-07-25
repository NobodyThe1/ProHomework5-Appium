package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ChatPage extends BasePage {

    public void unlockChatWindow() {
        $(By.id("android:id/button1")).click();
    }

    public void sendTextToChat(String text) {
        $(By.className("android.widget.EditText")).sendKeys(text);
        $(By.cssSelector(String.format(selector, "Send"))).click();
        $(By.cssSelector(String.format(selector, text))).shouldBe(Condition.visible);
    }

    public void chooseItemInGrammarWindow(String text) {
        $(By.cssSelector(String.format(selector, "Grammar"))).click();
        $(By.cssSelector(String.format(selector, "Much - Many"))).click();
        $(By.cssSelector(String.format(selector, text))).shouldBe(Condition.visible);
    }
}
