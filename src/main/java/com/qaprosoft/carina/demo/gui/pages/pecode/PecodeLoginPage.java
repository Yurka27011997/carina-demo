package com.qaprosoft.carina.demo.gui.pages.pecode;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.myGSM.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PecodeLoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name = 'username']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//input[@name = 'password']")
    private ExtendedWebElement userPasswordField;

    @FindBy(xpath = "//h1")
    private ExtendedWebElement headerTextPresent;

    @FindBy(xpath = "//input[@class = 'btn btn-success']")
    private ExtendedWebElement submitBtn;

    @FindBy(id = "logomini")
    private ExtendedWebElement logoMini;

    @FindBy(xpath = "//span[contains(text(),\"No\")]")
    private ExtendedWebElement usernameErrorMessage;

    @FindBy(xpath = "//span[contains(text(),\"The\")]")
    private ExtendedWebElement passwordErrorMessage;






    public PecodeLoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsernameField(String username) {
        userNameField.type(username);
    }

    public void setUserPasswordField(String password) {
        userPasswordField.type(password);
    }

    public PecodeLoginPage clickSubmitBtn(){
        submitBtn.click();
        return new PecodeLoginPage(driver);
    }

    public boolean isLogoPresent() {
        return logoMini.isElementPresent();
    }

    public boolean isHeaderTextPresent() {
        return headerTextPresent.isElementPresent();
    }

    public boolean isUserNameErrorMessagePresent() {
        return usernameErrorMessage.isElementPresent();
    }

    public boolean isPasswordErrorMessagePresent() {
        return passwordErrorMessage.isElementPresent();
    }

    public boolean isUserNameFieldPresent() {
        return userNameField.isElementPresent();
    }

    public boolean isPasswordFieldPresent() {
        return userPasswordField.isElementPresent();
    }

    public boolean isLoginBtnPresent() {
        return submitBtn.isElementPresent();
    }
}
