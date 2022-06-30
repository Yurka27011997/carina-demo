package com.qaprosoft.carina.demo.gui.pages.myGSM;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandsInfoPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<MyModelItem> models;


    public BrandsInfoPage(WebDriver driver) {
        super(driver);
    }



    public ModelsInfoPage selectDeviceModel (String modelName) {
        for (MyModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }

        throw new RuntimeException("Unable to open model: " + modelName);
    }
}
