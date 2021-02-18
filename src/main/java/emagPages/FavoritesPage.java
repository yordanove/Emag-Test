package emagPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage extends BasePage{
    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[contains(@class, 'products-number')]")
    private WebElement numberOfProductsInFavoritesAsText;

//  Delete Favorite section list
    public void deleteProductsInFavorites(){
        List<WebElement> elementList = driver.findElements(By.xpath("//span[text()='Изтрий']"));
        if (elementList.size() > 0) {
            for (int i = 0; i < elementList.size(); i++){
                elementList.get(i).click();
            }
        }
    }
}

