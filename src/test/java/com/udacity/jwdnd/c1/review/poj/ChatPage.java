package com.udacity.jwdnd.c1.review.poj;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(id = "messageType")
    private WebElement messageTypeField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(className = "chatUsername")
    private WebElement chatUsername;

    @FindBy(className = "chatMessage")
    private WebElement chatMessage;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setMessageField(String message) {
        messageField.sendKeys(message);
    }

    public String getMessageField() {
        return messageField.getText();
    }

    public void setMessageTypeField(String messageType) {
        messageTypeField.sendKeys(messageType);
    }

    public void submitChat() {
        submitButton.submit();
    }

    public ChatMessage getChatMessage() {
        ChatMessage cm = new ChatMessage();
        cm.setMessage(chatMessage.getText());
        cm.setUsername(chatUsername.getText());
        return cm;
    }
}
