package emagPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectedProductsPage extends BasePage {
    public SelectedProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_NAME = "//a[contains(@title, '%s')]";

    @FindBy(xpath= "//span[@class='gtm_t95ovv']")
    private WebElement favoriteButton;

    @FindBy(xpath = "//label[@for='compare-checkbox']")
    private WebElement compareCheckbox;

    @FindBy(id = "compare-link")
    private WebElement compareButton;

//  Select an item and go to its page
    public void selectProduct(String productName){
        String xpathFormatted = String.format(PRODUCT_NAME, productName);
        WebElement desiredProduct = driver.findElement(By.xpath(xpathFormatted));
        Actions actions = new Actions(driver);
        actions.moveToElement(desiredProduct);
        actions.click().perform();
    }

//  Add the item to Favorites
    public void addToFavorite(){
        closeVauchers();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", favoriteButton);
        favoriteButton.click();
    }

//  Close the voucher-message if available
    public void closeVauchers(){
        List<WebElement> elementList = driver.findElements(By.xpath("//button[@data-ntf='close']"));
        if (elementList.size() > 0) {
            WebElement close =  driver.findElement(By.xpath("//button[@data-ntf='close']"));
            close.click();
        }
    }

//  Check products for comparison
    public void checkForComparison(){
        compareCheckbox.click();
    }

//  Got to Comparison page
    public ComparisonPage goToComparisonPage(){
        compareButton.click();
        return new ComparisonPage(driver);
    }
}
