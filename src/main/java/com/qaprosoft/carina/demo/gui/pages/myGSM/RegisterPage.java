package com.qaprosoft.carina.demo.gui.pages.myGSM;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.myWebTests.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage {

    @FindBy(xpath = "//fieldset//input[@name = 'sNickname']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//fieldset//input[@name = 'sEmail']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//div[@id = 'user-submit']//form//input[@id = 'upass']")
    ////div[@id = 'user-submit']//form//input[@id = 'upass']
    private ExtendedWebElement userPasswordField;

    @FindBy(xpath = "//div//label[@for='iagree1']")
    private ExtendedWebElement agreeData;

    @FindBy(xpath = "//div//label[@for='iagree2']")
    private ExtendedWebElement agreeAge;

    @FindBy(xpath = "//input[@class='button float-right']")
    private ExtendedWebElement submitBtn;



    public RegisterPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }




    public RegisterPage clickAgreeData(){
        agreeData.click();
        return new RegisterPage(driver);
    }

    public RegisterPage clickAgreeAge(){
        agreeAge.click();
        return new RegisterPage(driver);
    }

    public void setUsernameField(String username) {
        userNameField.type(username);
    }

    public void setEmailField(String email) {
        emailField.type(email);
    }

    public void setUserPasswordField(String password) {
        userPasswordField.type(password);
    }

    public RegisterPage clickSubmitBtn(){
        submitBtn.click();
        return new RegisterPage(driver);
    }
}
