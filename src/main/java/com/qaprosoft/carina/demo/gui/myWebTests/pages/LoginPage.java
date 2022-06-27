package com.qaprosoft.carina.demo.gui.myWebTests.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user-name")
    private ExtendedWebElement usernameField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@class='submit-button btn_action']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private ExtendedWebElement errorMessage;

    @FindBy(className = "login_logo")
    private ExtendedWebElement title;

    @FindBy(className = "error_icon")
    private ExtendedWebElement errorIcon;

    @FindBy(className = "error-button")
    private ExtendedWebElement errorButton;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]")
    private ExtendedWebElement errorMessageLogin;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        usernameField.type(username);
    }

    public void setPassword(String password) {
        passwordField.type(password);
    }

    public ProductsPage clickLogin(){
        loginBtn.click();
        return new ProductsPage(getDriver());
    }

    public boolean getLocation() {
        Point userNameFieldPoint = usernameField.getLocation();
        Point passwordFieldPoint = passwordField.getLocation();
        Point loginButtonPoint = loginBtn.getLocation();
        return userNameFieldPoint.getY() < passwordFieldPoint.getY() && passwordFieldPoint.getY() < loginButtonPoint.getY();
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    public boolean isTitlePresent() {
        return title.isElementPresent(5);
    }

    public String getErrorMessage() {
        return errorMessageLogin.getText();
    }

    public boolean isErrorIconPresent() {
        return errorIcon.isElementPresent();
    }

    public boolean isErrorButtonPresent() {
        return errorButton.isElementPresent();
    }





}
