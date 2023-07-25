import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ChatPage;
import pages.StartPage;

@ExtendWith(AppiumExtension.class)
public class AndyTests {

    private StartPage startPage = new StartPage();
    private ChatPage chatPage = new ChatPage();

    @Test
    public void sendTextToChatTest() {
        getChatPage();
        chatPage.sendTextToChat("Hi");
    }

    @Test
    public void startGrammarLessons() {
        getChatPage();
        chatPage.chooseItemInGrammarWindow("\"Much - Many\" lesson please");
    }

    private void getChatPage() {
        startPage.open();
        startPage.openChatPage();
        chatPage.unlockChatWindow();
    }
}
