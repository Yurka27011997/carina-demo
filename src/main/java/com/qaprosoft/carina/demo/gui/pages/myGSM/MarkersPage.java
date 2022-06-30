package com.qaprosoft.carina.demo.gui.pages.myGSM;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MarkersPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarkersPage.class);

    @FindBy(xpath = "//div[@class = 'st-text']//tbody//tr//td")
    private List<ExtendedWebElement> allBrands;

    public MarkersPage(WebDriver driver) {
        super(driver);
        setPageURL("/makers.php3");
    }
    public BrandsInfoPage selectFromAllBrands (String nameBrand) {
        LOGGER.info("selecting '" + nameBrand + "' brand...");
        for (ExtendedWebElement brandNameLink : allBrands) {
            String currentBrand = brandNameLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (nameBrand.equalsIgnoreCase(currentBrand)) {
                brandNameLink.click();
                return new BrandsInfoPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + nameBrand);
    }
}
