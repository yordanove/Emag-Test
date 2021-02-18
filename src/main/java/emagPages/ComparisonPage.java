package emagPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ComparisonPage extends BasePage{

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[text()='Бранд']//ancestor::tr/td[2]")
    private WebElement firstItemBrandFormComparisonTable;

    @FindBy(xpath="//div[text()='Бранд']//ancestor::tr/td[3]")
    private WebElement secondItemBrandFormComparisonTable;

//  Check that the brand of both items is Acer / SanDisk
    public void validateBrand(String expectedBrand){
       SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(firstItemBrandFormComparisonTable.getText(), expectedBrand);
       softAssert.assertEquals(secondItemBrandFormComparisonTable.getText(), expectedBrand);
       softAssert.assertAll();
    }

}
