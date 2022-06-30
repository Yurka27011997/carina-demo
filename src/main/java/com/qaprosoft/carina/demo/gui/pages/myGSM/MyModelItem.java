package com.qaprosoft.carina.demo.gui.pages.myGSM;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.ModelInfoPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class MyModelItem extends AbstractUIObject {


    @FindBy(xpath = ".//strong/span")
    private ExtendedWebElement modelName;

    @FindBy(xpath = "//div[@class = 'makers']//ul//li//a")
    private ExtendedWebElement modelLink;

    public MyModelItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String readModel() {
        return modelName.getText();
    }

    public ModelsInfoPage openModelPage() {
        modelLink.click();
        return new ModelsInfoPage(driver);
    }

}
