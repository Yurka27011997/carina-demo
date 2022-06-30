package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.myGSM.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyGSMTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testForChoosePhoneModelFromAllBrands() {
        // Open GSM Arena home page and verify page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        MarkersPage makersPage = homePage.clickAllBrands();
        Assert.assertTrue(makersPage.isPageOpened(), "Markers page is not opened");
        BrandsInfoPage modelsPage = makersPage.selectFromAllBrands("SONY\n" + "154 devices");
        modelsPage.selectDeviceModel("Xperia 1 III");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testRegistration() {
        String username = "testUser25552156";
        String email = "test123@gmail.com";
        String password = "123456789";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        RegisterPage registerPage = homePage.clickRegistration();
        Assert.assertTrue(registerPage.isPageOpened(), "Register page is not opened");
        SoftAssert softAssert = new SoftAssert();
        registerPage.setUsernameField(username);
        registerPage.setEmailField(email);
        registerPage.setUserPasswordField(password);
        registerPage.clickAgreeData();
        registerPage.clickAgreeAge();
        registerPage.clickSubmitBtn();
        Assert.assertTrue(registerPage.isPageOpened(), "Register page is not opened");


    }
}
