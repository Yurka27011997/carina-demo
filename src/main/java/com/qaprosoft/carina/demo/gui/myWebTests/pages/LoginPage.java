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



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void getUsername(String username) {
        usernameField.type(username);
    }

    public void getPassword(String password) {
        passwordField.type(password);
    }

    public boolean getLogin(){
        loginBtn.click();
        return true;
    }

    public boolean getLocation() {
        Point first = usernameField.getLocation();
        Point second = passwordField.getLocation();
        Point loginButton = loginBtn.getLocation();
        if (first.getY() < second.getY() && second.getY() < loginButton.getY()) {

            return true;

        } else

            return false;
    }



}
