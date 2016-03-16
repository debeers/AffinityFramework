package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static GeneralHelpers.DropdownMenuWorker.selectFromDropdawnMenuByIndex;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class MainPage extends TopMenuGeneralPage {

    @FindBy(xpath = "*//ul/following-sibling::a[@class='post-free-ad btn green']")
    public WebElement addNewPostButtonTop;

    @FindBy(xpath = ".//*[@id='search']//input[contains(@class,'form-input form-field-xs form-search-long')]")
    public WebElement searchField;

    @FindBy(xpath = ".//*[@id='search']/div/a")
    public WebElement searchButton;

    @FindBy(xpath = ".//*[@id='usernames_chosen']/a")
    public WebElement city;

    @FindBy(xpath = ".//*[@id='usernames_chosen']//ul/li[contains(@data-option-array-index,'')]")
    public List<WebElement> citiesList;

    @FindBy(xpath = ".//*[@id='expand-cats']")
    public WebElement allCategories;

    @FindBy(xpath = ".//*[@id='categories']//ul/li/a")
    public List<WebElement> underCategoriesList;



    public SecondSearchPage clickOnSearchButton(){
        $(searchButton).shouldBe(visible).click();
        return new SecondSearchPage(driver);
    }

    public void selectCityForSearch(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(city, citiesList, index);
    }

    public PostPage clickOnAddNewPostButton(){

        $(addNewPostButtonTop).shouldBe(visible).click();
        return new PostPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

}
