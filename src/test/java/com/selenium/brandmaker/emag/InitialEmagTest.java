package com.selenium.brandmaker.emag;

import com.opencsv.exceptions.CsvException;
import com.selenium.brandmaker.base.TestUtil;
import emagPages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

public class InitialEmagTest extends TestUtil {

//  Read data form emag-brand-data.csv using DataProvider
    @DataProvider(name = "brand-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/emag-brand-data.csv");
    }

//  Delete Favorites section before each test
    @BeforeMethod
    public void clearFavorites(){
        HomePage emagHome = new HomePage(driver);
        emagHome.goToFavorites();
        FavoritesPage favorites = new FavoritesPage(driver);
        favorites.deleteProductsInFavorites();
    }

//  DataProvider is used for input data providing - brand and product type
    @Test(dataProvider = "brand-data")
    public void executeEmagTest(String brand, String productType, String expectedBrand, String product1, String product2){

//  Go to Home page and search a brand in the Search area
//  The brand list is provided via csv file emag-brand-data.csv
        HomePage emagHome = new HomePage(driver);
        emagHome.searchBrand(brand);
        emagHome.selectBrand(productType);

        SelectedProductsPage selectedProduct = new SelectedProductsPage(driver);

////  Select products, add to favorites, check for comparison
////  The products are provided via enum classes, possibility for more than 2 products avilable
////  Select the Acer items from enum class ProductsAser, add to Favorites and check for comparison
//        if(brand.equals("Acer")) {
//            ProductsAcer[] acerProducts = ProductsAcer.values();
//            int i = 0;
//            for (ProductsAcer product : acerProducts) {
//                selectedProduct.selectProduct(product.getAcerProducts());
//                selectedProduct.addToFavorite();
//                selectedProduct.checkForComparison();
//
////  If not last iteration go back to the list of selected products
//                if(i++ != acerProducts.length - 1){
//                    driver.navigate().back();
//                }
//            }
//        } else {    //  Select the SanDisk items from enum class ProductsSanDisk, add to Favorites and check for comparison
//                ProductsSanDisk[] sanDiskProducts = ProductsSanDisk.values();
//                int i = 0;
//                for (ProductsSanDisk product : sanDiskProducts) {
//                    selectedProduct.selectProduct(product.getSanDiskProducts());
//                    selectedProduct.addToFavorite();
//                    selectedProduct.checkForComparison();
//
////  If not last iteration go back to the list of selected products
//                    if(i++ != sanDiskProducts.length - 1){
//                        driver.navigate().back();
//                    }
//                }
//            }

//  Select products, add to favorites, check for comparison of 2 products
//  Products are provided via emag-brand-emag.csv file
        selectedProduct.selectProduct(product1);
        selectedProduct.addToFavorite();
        selectedProduct.checkForComparison();
        driver.navigate().back();
        selectedProduct.selectProduct(product2);
        selectedProduct.addToFavorite();
        selectedProduct.checkForComparison();

//  Check that the brand of the products is Acer / SanDisk
        selectedProduct.goToComparisonPage();
        ComparisonPage compare = new ComparisonPage(driver);
        compare.validateBrand(expectedBrand);
    }
}
