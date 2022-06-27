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

    @FindBy(xpath = "//option[@value='az']")
    private ExtendedWebElement filterAtoZ;

    @FindBy(xpath = "//option[@value='za']")
    private ExtendedWebElement filterZtoA;

    @FindBy(xpath = "//option[@value='lohi']")
    private ExtendedWebElement filterPriceLowtoHigh;

    @FindBy(xpath = "//option[@value='hilo']")
    private ExtendedWebElement filterPriceHightoLow;

    @FindBy(xpath = "//span[@class='active_option' and 'Name (A to Z)']")
    private ExtendedWebElement defaultDropdown;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private ExtendedWebElement dropDownMenu;



    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    public boolean isImageOnePresent() {
        return imageOnePresent.isElementPresent(5);

    }

    public boolean isTitleOnePresent() {
        return titleOnePresent.isElementPresent(5);
    }

    public boolean isDescriptionOnePresent() {
        return descriptionOnePresent.isElementPresent(5);
    }

    public boolean isPriceOnePresent() {
        return priceOnePresent.isElementPresent(5);
    }

    public boolean isCardOnePresent() {
        return cardOnePresent.isElementPresent(5);

    }

    public String isFilterNameAToZPresent() {
        return filterAtoZ.getText();
    }

    public String isFilterNameZToAPresent() {
        return filterZtoA.getText();
    }

    public String isFilterPriceLowToHighPresent() {
        return filterPriceLowtoHigh.getText();
    }

    public String isFilterPriceHighToLowPresent() {
        return filterPriceHightoLow.getText();
    }

    public String getDefaultDropdownMenuName() {
        return defaultDropdown.getText();
    }

    public ProductsPage clickOnDropdownMenu() {
        dropDownMenu.click(5);
        return new ProductsPage(getDriver());
    }

    public String getChooseDownMenu() {
        filterZtoA.click(5);
        return filterZtoA.getText();
    }

    public boolean isDropDownMenuIsPresent() {
        return dropDownMenu.isElementPresent(5);
    }




}
