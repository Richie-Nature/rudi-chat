package com.udacity.jwdnd.c1.review.poj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getUsername(String username) {
      return usernameField.getText();
    }

    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public String getPassword(String password) {
        return passwordField.getText();
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void login(String uname, String password) {
        setUsernameField(uname);
        setPasswordField(password);
        submitButton.submit();
    }
}
