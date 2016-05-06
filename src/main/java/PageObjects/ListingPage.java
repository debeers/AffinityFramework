package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static Actions.GUI_Actions.PopulateAdverts.populateAdverts;
import static Actions.GUI_Actions.PopulateAdverts.pullListText;
import static GeneralHelpers.DropdownMenuWorker.selectFromDropdawnMenuByIndex;
import static GeneralHelpers.WindowManagement.windowScale;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 13.03.2016.
 */
public class ListingPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//*[@id='search_input']")
    public WebElement searchField;

    @FindBy(xpath = ".//*[@id='search']//a[contains(@class,'btn-search')]")
    public WebElement searchButton;

    @FindBy(xpath = ".//*[@id='categories_select_chosen']/a")
    public WebElement categorieMenu;

    @FindBy(xpath = ".//*[@id='categories_select_chosen']/div/ul/li")
    public List<WebElement> categoriesListDropMenu;

    @FindBy(xpath = ".//*[@id='category-filters']//a[contains(@class,'chosen-single')]")
    public WebElement underCategorieMenu;

    @FindBy(xpath = ".//*[@id='category-filters']//ul[contains(@class,'chosen-results')]/li")
    public List<WebElement> underCategoriesListDropMenu;

    @FindBy(xpath = ".//*[@id='cities_chosen']/a")
    public WebElement cityMenu;

    @FindBy(xpath = ".//*[@id='cities_chosen']/div/ul/li")
    public List<WebElement> citiesList;

    @FindBy(xpath = ".//div[contains(@class,'simple-ad')]")
    public List<WebElement> searchResultsList;

    @FindBy(xpath = ".//*[@id='categories']//ul/li/a")
    public List<WebElement> underCategoriesListLinks;

    @FindBy(xpath = ".//*[@id='yw0']//a[contains(@class,'name')]")//.//*[@id='yw0']//a[contains(@class,'name')]
    public List<WebElement> searchResultTitles;

    @FindBy(xpath = ".//*[@id='expand-cats']/span")
    public WebElement expandAllCategories;

    @FindBy(xpath = ".//*[@id='type_all']")
    public WebElement advertTypeAll;

    @FindBy(xpath = ".//*[@id='type_private']")
    public WebElement advertTypePrivate;

    @FindBy(xpath = ".//*[@id='type_bussiness']")
    public WebElement advertTypeBusiness;

    @FindBy(xpath = ".//*[contains(@class,'vip-ad')]")
    public List<WebElement> vipAdverts;

    @FindBy(xpath = ".//*[@id='vip_tag']")
    public List<WebElement> vipAdvertsIcon;

    @FindBy(xpath = ".//div[@class='details']/div[@class='info']")
    public List<WebElement> advertsInformation;

    private final By vipAdvertisementIcon = By.xpath(".//*[@id='vip_tag']");

    private final By simpleAdvertPrice = By.xpath(".//div[@id='price']");

    @FindBy(xpath = ".//div[@id='price']")
    public WebElement simplAdvertPrice;

    @FindBy(xpath = ".//*[@id='vip_tag']")
    public WebElement vipAdvertIcon;

    @FindBy(xpath = ".//div[@class='details']/a")
    public List<WebElement> titlesOfAdverts;

    @CacheLookup
    @FindBy(xpath = ".//*[contains(@class,'simple-ad')]")
    public List<WebElement> simpleAdverts;

    @FindBy(xpath = ".//*[contains(@class,'vip-ad')]/div[@class='details']/a")
    public List<WebElement> vipAdvertsTitles;

    @FindBy(xpath = ".//*[contains(@class,'vip-ad')]/div[@class='details']/*[@id='price']")
    public List<WebElement> vipAdvertsPrices;

    @FindBy(xpath = ".//*[contains(@class,'vip-ad')]/div[@class='details']/div[@class='info']")
    public List<WebElement> vipAdvertsInfo;

    public List<String> foundEqualsTitlesInSearchResults(String searchRequest) throws InterruptedException {
        List<String> searchResults = new ArrayList<>();

        windowScale(driver, "-", 3);

        searchResultTitles.stream().forEach((s) -> {

            if ($(s).shouldBe(visible)
                    .getText()
                    .toLowerCase()
                    .trim()
                    .contains(searchRequest.toLowerCase())) {
                searchResults.add(s.getText());
            } else System.out.println("No matches found!");
        });
        return searchResults;
    }

    public List<WebElement> pullAllVipAdverts() throws InterruptedException {
        List<WebElement> findVipAdverts = new ArrayList<>();

        if (!$$(vipAdverts).isEmpty()) {
            vipAdverts.stream().forEach((vip) -> {
                if (vip.findElement(vipAdvertisementIcon).isDisplayed()) {
                    findVipAdverts.add(vip);
                }
            });
        }

        return findVipAdverts;
    }

    public List<String> pullSimpleAdvertsWithCorrectPriceFormat(Properties props) throws InterruptedException {

        return populateAdverts(simpleAdverts, simpleAdvertPrice, props);
    }

    public int pullVipAdvertsAmount() throws InterruptedException {
        return $$(vipAdverts).size();
    }

    public ElementsCollection getTitlesOfAdvert() {
        return $$(titlesOfAdverts);
    }

    public List<String> getAdvertsInformation() {
        return pullListText($$(advertsInformation));
    }

    public List<String> pullSimpleAdvertsAmount() throws InterruptedException {
        return pullListText($$(simpleAdverts));
    }

    public void selectCityForSearch(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(cityMenu, citiesList, index);
    }

    public void selectCategories(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(categorieMenu, categoriesListDropMenu, index);
    }

    public void selectUnderCategories(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(underCategorieMenu, underCategoriesListDropMenu, index);
    }

    public void enterSearchRequest(String searchRequest) throws InterruptedException {
        // jsDeleteClassesByClass(driver, "form-input");
        $(searchField).shouldBe(visible).sendKeys(searchRequest);
    }

    public void clickOnSearchButton() {
        $(searchButton).shouldBe(visible).click();
    }

    public List<String> search(String cityIndex, String categoryIndex, String undercatIndex, String searchRequest)
            throws InterruptedException {

        enterSearchRequest(searchRequest);
        selectCityForSearch(cityIndex);
        selectCategories(categoryIndex);
        selectUnderCategories(undercatIndex);
        clickOnSearchButton();

        return foundEqualsTitlesInSearchResults(searchRequest);
    }

    public ListingPage(WebDriver driver) {
        super(driver);
    }
}