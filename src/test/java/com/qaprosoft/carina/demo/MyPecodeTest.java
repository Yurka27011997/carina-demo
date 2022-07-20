package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.listener.DriverListener;
import com.qaprosoft.carina.demo.gui.myWebTests.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.pecode.JsonRead;
import com.qaprosoft.carina.demo.gui.pages.pecode.JsonWrite;
import com.qaprosoft.carina.demo.gui.pages.pecode.LoginData;
import com.qaprosoft.carina.demo.gui.pages.pecode.PecodeLoginPage;
import org.postgresql.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyPecodeTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Yurii Hnatiuk")
    public void testLoginUser() {
        JsonWrite jsonWrite = new JsonWrite();
        JsonRead jsonRead = new JsonRead();
        jsonWrite.jsonWriteToFile();
        LoginData loginData = jsonRead.jsonReadFromFile();
        String username = loginData.getUsername();
        String password = loginData.getPassword();
        PecodeLoginPage pecodeLoginPage = new PecodeLoginPage(getDriver());
        pecodeLoginPage.open();
        Assert.assertTrue(pecodeLoginPage.isPageOpened(), "Home page is not opened");
        pecodeLoginPage.setUsernameField(username);
        pecodeLoginPage.setUserPasswordField(password);
        pecodeLoginPage.clickSubmitBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pecodeLoginPage.isUserNameErrorMessagePresent(), "Username Error Message isn't present");
        softAssert.assertAll();

    }

    @Test
    @MethodOwner(owner = "Yurii Hnatiuk")
    public void testElementsOnLoginPage() {
        PecodeLoginPage pecodeLoginPage = new PecodeLoginPage(getDriver());
        pecodeLoginPage.open();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(pecodeLoginPage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(pecodeLoginPage.isLogoPresent(), "Company Logo isn't present");
        softAssert.assertTrue(pecodeLoginPage.isHeaderTextPresent(), "Header text isn't present");
        softAssert.assertTrue(pecodeLoginPage.isUserNameFieldPresent(), "Username Field isn't present");
        softAssert.assertTrue(pecodeLoginPage.isPasswordFieldPresent(), "Password Field isn't present");
        softAssert.assertTrue(pecodeLoginPage.isLoginBtnPresent(), "Login button isn't present");
        softAssert.assertAll();

    }

    @Test
    @MethodOwner(owner = "Yurii Hnatiuk")
    public void testWrongPassword() {
        PecodeLoginPage pecodeLoginPage = new PecodeLoginPage(getDriver());
        pecodeLoginPage.open();
        Assert.assertTrue(pecodeLoginPage.isPageOpened(), "Home page is not opened");
        pecodeLoginPage.setUsernameField("test");
        pecodeLoginPage.setUserPasswordField("123456");
        pecodeLoginPage.clickSubmitBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pecodeLoginPage.isPasswordErrorMessagePresent(), "Password Error Message isn't present");
        softAssert.assertAll();

    }
}
