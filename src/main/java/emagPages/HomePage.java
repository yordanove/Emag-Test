package emagPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final String BRAND_BY_NAME = "//span[text()= '%s']//ancestor::span[@class='searchbox-suggestion-category']";

    @FindBy(id="searchboxTrigger")
    private WebElement searchArea;

    @FindBy(xpath = "//i[@class='em em-heart navbar-icon']")
    private WebElement favorites;

//  Search for a brand
    public void searchBrand(String brand){
        searchArea.clear();
        searchArea.sendKeys(brand);
    }

//  Find and select the searched brand
    public SelectedProductsPage selectBrand(String productType){
        String xpathFormatted = String.format(BRAND_BY_NAME, productType);
        WebElement searchedBrand = driver.findElement(By.xpath(xpathFormatted));
        searchedBrand.click();
        return new SelectedProductsPage(driver);
    }

//  Go to Favorites page
    public FavoritesPage goToFavorites(){
        favorites.click();
        return new FavoritesPage(driver);
    }

}
