package PageObjects;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import static GeneralHelpers.DropdownMenuWorker.selectFromDropdawnMenuByIndex;
import static GeneralHelpers.WindowManagement.windowScale;
import static com.codeborne.selenide.Selenide.$;
/**
 * Created by DeBeers on 13.03.2016.
 */
public class SecondSearchPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//*[@id='search']/div[1]/div[2]/input")
    public WebElement searchField;

    @FindBy(xpath = ".//*[@id='search']//a[contains(@class,'btn-search')]")
    public WebElement searchButton;

    @FindBy(xpath = ".//*[@id='search']/div[1]/div[1]/div/a")
    public WebElement categorieMenu;

    @FindBy(xpath = ".//*[@id='search']/div[1]/div[1]/div/div/ul/li")
    public List<WebElement> categoriesListDropMenu;

    @FindBy(xpath = ".//*[@id='category-filters']//a[contains(@class,'chosen-single')]")
    public WebElement underCategorieMenu;

    @FindBy(xpath = ".//*[@id='category-filters']//ul[contains(@class,'chosen-results')]/li")
    public List<WebElement> underCategoriesListDropMenu;

    @FindBy(xpath = ".//*[@id='search']//div[3]/div/a[contains(@class,'chosen-single')]")
    public WebElement cityMenu;

    @FindBy(xpath = ".//*[@id='search']/div[1]/div[3]/div/div/ul/li")
    public List<WebElement> citiesList;

    @FindBy(xpath = "//div[contains(@class,'category-items')]//div[contains(@class,'category-item clearfix')]")
    public List<WebElement> searchResultsList;

    @FindBy(xpath = ".//*[@id='categories']//ul/li/a")
    public List<WebElement> underCategoriesListLinks;

    @FindBy(xpath = ".//*[@id='yw0']//a[contains(@class,'name')]")//.//*[@id='yw0']//a[contains(@class,'name')]
    public List<WebElement> searchResultTitles;

    public List<String> foundEqualsTitlesInSearchResults(String searchRequest) throws InterruptedException {
        List<String> searchResults = new ArrayList<>();

        windowScale(driver, "-", 3);

        searchResultTitles.stream().forEach((s) -> {

            if ($(s).shouldBe(Condition.visible)
                    .getText()
                    .toLowerCase()
                    .trim()
                    .contains(searchRequest.toLowerCase())) {
                searchResults.add(s.getText());
            } else System.out.println("No mutches found!");
        });
        return searchResults;
    }

    public void selectCityForSearch(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(cityMenu, citiesList, index);
    }

    public void selectCategorie(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(categorieMenu, categoriesListDropMenu, index);
    }

    public void selectUnderCategorie(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(underCategorieMenu, underCategoriesListDropMenu, index);
    }

    public void enterSearchRequest(String searchRequest) throws InterruptedException {
       // jsDeleteClassesByClass(driver, "form-input");
        $(searchField).shouldBe(Condition.visible).sendKeys(searchRequest);
    }

    public void clickOnSeaqrchButton(){
        $(searchButton).shouldBe(Condition.visible).click();
    }

    public List<String> search(String cityIndex, String categoryIndex, String undercatIndex, String searchRequest)
            throws InterruptedException {

        enterSearchRequest(searchRequest);
        selectCityForSearch(cityIndex);
        selectCategorie(categoryIndex);
        selectUnderCategorie(undercatIndex);
        clickOnSeaqrchButton();

        return foundEqualsTitlesInSearchResults(searchRequest);
    }

    public SecondSearchPage(WebDriver driver) {
        super(driver);
    }
}
