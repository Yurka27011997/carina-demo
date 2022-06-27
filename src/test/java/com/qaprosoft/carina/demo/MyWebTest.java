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
        softAssert.assertTrue(homePage.isUsernameFieldPresent(), "UserName field isn't present");
        softAssert.assertTrue(homePage.isPasswordFieldPresent(), "Password field isn't present");
        softAssert.assertTrue(homePage.isLoginButtonPresent(), "Login button isn't present");
        softAssert.assertAll();
    }

    @Test
    public void testLoginUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(usernameData);
        loginPage.setPassword(passwordData);
        SoftAssert softAssert = new SoftAssert();
        ProductsPage productsPage = loginPage.clickLogin();
        softAssert.assertFalse(productsPage.isPageOpened(), "Product page is not opened");
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
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(usernameData);
        loginPage.setPassword(passwordData);
        SoftAssert softAssert = new SoftAssert();
        ProductsPage productsPage = loginPage.clickLogin();
        softAssert.assertFalse(productsPage.isPageOpened(), "Product page is not opened");
        productsPage.clickOnDropdownMenu();
        softAssert.assertEquals(productsPage.isFilterNameAToZPresent(), "Name (A to Z)", "Filter Name A to Z is Lost");
        softAssert.assertEquals(productsPage.isFilterNameZToAPresent(), "Name (Z to A)", "Filter Name Z to A is Lost");
        softAssert.assertEquals(productsPage.isFilterPriceLowToHighPresent(), "Price (low to high)", "Filter Price Low to High Lost");
        softAssert.assertEquals(productsPage.isFilterPriceHighToLowPresent(), "Price (high to low)", "Filter Price High to Low Lost");
        softAssert.assertAll();
    }

    @Test
    public void testChooseDropDownFilterMenu() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername(usernameData);
        loginPage.setPassword(passwordData);
        SoftAssert softAssert = new SoftAssert();
        ProductsPage productsPage = loginPage.clickLogin();
        softAssert.assertFalse(productsPage.isPageOpened(), "Product page is not opened");
        softAssert.assertEquals(productsPage.getDefaultDropdownMenuName(), "NAME (A TO Z)", "Default dropdown name is wrong");
        softAssert.assertTrue(productsPage.isDropDownMenuIsPresent(), "DropDownMenu, isn't present");
        productsPage.clickOnDropdownMenu();
        softAssert.assertEquals(productsPage.getChooseDownMenu(), "Name (Z to A)", "Filter Z to A don't choose");
        softAssert.assertAll();

    }

    @Test
    public void testLoginFail() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername("standard_user");
        loginPage.setPassword("123");
        loginPage.clickLogin();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isErrorMessagePresent(), "Error message isn't present");
    }

    @Test
    public void testHomeTitle() {//Перейменувати
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isTitlePresent(), "Home page title isn`t present");
    }

    @Test
    public void testCorrectUserName() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened");
        loginPage.setUsername("problem_user");
        loginPage.setPassword("123");
        loginPage.clickLogin();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isErrorMessagePresent(), "Error message isn't present");
        loginPage.setUsername(usernameData);
        loginPage.setPassword(passwordData);
        loginPage.clickLogin();
        softAssert.assertAll();
    }

    @Test
    public void testLoginCorrectPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(loginPage.isErrorButtonPresent(), "Error button is absent");
        Assert.assertTrue(loginPage.isErrorIconPresent(), "Error icon is absent");
        String errorMessageActual = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessageActual, "Epic sadface: Username is required", "Different actual and expecte results");
    }

    @Test
    public void testLoginCorrectUserName() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.setUsername("standard_user");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        Assert.assertTrue(loginPage.isErrorButtonPresent(), "Error button is absent");
        Assert.assertTrue(loginPage.isErrorIconPresent(), "Error icon is absent");
        String errorMessageActual = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessageActual, "Epic sadface: Password is required", "Different actual and expecte results");
    }

    @Test
    public void testLoginPageEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Home page is not opened!");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorButtonPresent(), "Error button is absent");
        Assert.assertTrue(loginPage.isErrorIconPresent(), "Error icon is absent");
        String errorMessageActual = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessageActual, "Epic sadface: Username is required", "Different actual and expecte results");
    }











    }
