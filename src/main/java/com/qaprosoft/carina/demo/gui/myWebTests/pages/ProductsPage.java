package com.qaprosoft.carina.demo.gui.myWebTests.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractPage {


    @FindBy(id = "item_4_img_link")
    private ExtendedWebElement imageOnePresent;

    @FindBy(id = "item_4_title_link")
    private ExtendedWebElement titleOnePresent;

    @FindBy(xpath = "//div[contains(text(),'carry')]")
    private ExtendedWebElement descriptionOnePresent;

    @FindBy(xpath = "//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div")
    private ExtendedWebElement priceOnePresent;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement cardOnePresent;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select/option[1]")
    private ExtendedWebElement filterAtoZ;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select/option[2]")
    private ExtendedWebElement filterZtoA;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement filterPriceLowtoHigh;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement filterPriceHightoLow;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/span")
    private ExtendedWebElement defaultDropdown;


    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("inventory.html");
    }

    public boolean isImageOnePresent() {
        System.out.println("ok");
        return imageOnePresent.isElementPresent(5);

    }

    public boolean isTitleOnePresent() {
        System.out.println("ok");
        return titleOnePresent.isElementPresent(5);
    }

    public boolean isDescriptionOnePresent() {
        return descriptionOnePresent.isElementPresent(5);
    }

    public boolean isPriceOnePresent() {
        System.out.println("ok");
        return priceOnePresent.isElementPresent(5);
    }

    public boolean isCardOnePresent() {
        System.out.println("ok");
        return cardOnePresent.isElementPresent(5);

    }

    public boolean isfilterNameAToZPresent() {
        System.out.println("ok");
        return filterAtoZ.isElementPresent(5);
    }

    public boolean isfilterNameZToAPresent() {
        System.out.println("ok");
        return filterZtoA.isElementPresent(5);
    }

    public boolean isfilterPriceLowToHighPresent() {
        System.out.println("ok");
        return filterPriceLowtoHigh.isElementPresent(5);
    }

    public boolean isfilterPriceHighToLowPresent() {
        System.out.println("ok");
        return filterPriceHightoLow.isElementPresent(5);
    }

    public String defaultDropdownMenuName() {
        return defaultDropdown.getText();
    }

    public boolean clickOnDropdownMenu() {
        filterZtoA.click();
        return false;
    }

    public String selectDropDownMenu() {
        return filterZtoA.getText();
    }



}
