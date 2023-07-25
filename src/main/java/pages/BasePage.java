package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {

    protected String selector = "[text='%s']";

    public void open() {
        Selenide.open();
    }
}
