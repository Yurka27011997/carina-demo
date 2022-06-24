package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.myWebTests.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.myWebTests.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qaprosoft.carina.demo.gui.myWebTests.pages.HomePage;


public class MyWebTest implements IAbstractTest {
    String usernameData = "standard_user";
    String passwordData = "secret_sauce";
    @Test
    public void testElementsOnHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(homePage.isUsernameFieldPresent(), "isn't present");
        softAssert.assertTrue(homePage.isPasswordFieldPresent(), "isn't present");
        softAssert.assertTrue(homePage.isLoginButtonPresent(), "Login button is null");
        softAssert.assertAll();
    }

    @Test
    public void testLoginUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        loginPage.open();
        loginPage.getUsername(usernameData);
        loginPage.getPassword(passwordData);
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(loginPage.getLogin(), "Login NOK");
        softAssert.assertFalse(productsPage.isPageOpened(),"Products page is not opened");
        softAssert.assertTrue(productsPage.isImageOnePresent(), "Image isn't present");
        softAssert.assertTrue(productsPage.isTitleOnePresent(), "Title isn't present");
        softAssert.assertTrue(productsPage.isDescriptionOnePresent(), "Description isn't present");
        softAssert.assertTrue(productsPage.isPriceOnePresent(), "Price isn't present");
        softAssert.assertTrue(productsPage.isCardOnePresent(), "Add to cart isn't present");
        softAssert.assertAll();
    }
    @Test
    public void testLocationElements() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(loginPage.getLocation(), "Location of elements failed");
        softAssert.assertAll();
    }

    @Test
    public void testDropDownFilterMenu() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        loginPage.open();
        loginPage.getUsername(usernameData);
        loginPage.getPassword(passwordData);
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(loginPage.getLogin(), "Login NOK");
        softAssert.assertFalse(productsPage.isPageOpened(),"Products page is not opened");
        softAssert.assertTrue(productsPage.isfilterNameAToZPresent(), "FilterAtoZ isn't present");
        softAssert.assertTrue(productsPage.isfilterNameZToAPresent(), "FilterZtoA isn't present");
        softAssert.assertTrue(productsPage.isfilterPriceLowToHighPresent(), "FilterLowtoHigh isn't present");
        softAssert.assertTrue(productsPage.isfilterPriceHighToLowPresent(), "FilterHightoLow isn't present");
        softAssert.assertAll();
    }

    @Test
    public void testChooseDropDownFilterMenu() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        loginPage.open();
        loginPage.getUsername(usernameData);
        loginPage.getPassword(passwordData);
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        softAssert.assertTrue(loginPage.getLogin(), "Login NOK");
        softAssert.assertFalse(productsPage.isPageOpened(),"Products page is not opened");
        Assert.assertEquals(productsPage.defaultDropdownMenuName(), "NAME (A TO Z)", "Default dropdown name is wrong");
        softAssert.assertFalse(productsPage.clickOnDropdownMenu(), "Choose of dropDownMEnu failed");
        Assert.assertEquals(productsPage.selectDropDownMenu(), "Name (Z to A)", "Option doesn't choose");
        softAssert.assertAll();

    }


}
