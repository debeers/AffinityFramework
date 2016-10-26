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

    @FindBy(xpath = ".//a[@id='post_advert']")
    public WebElement addNewPostButtonTop;

    @FindBy(xpath = ".//input[@id='search_input']")
    public WebElement searchField;

    @FindBy(xpath = ".//a[@id='search_button']")
    public WebElement searchButton;

    @FindBy(xpath = ".//*[@id='usernames_chosen']/a")
    public WebElement city;

    @FindBy(xpath = ".//*[@id='usernames_chosen']//ul/li[contains(@data-option-array-index,'')]")
    public List<WebElement> citiesList;

    @FindBy(xpath = ".//*[@id='expand-cats']")
    public WebElement allCategories;

    @FindBy(xpath = ".//*[@id='categories']//ul/li/a")
    public List<WebElement> underCategoriesList;

    @FindBy(xpath = ".//*[@id='category_otdam-darom']")
    public WebElement categoryFreebies;



    public ListingPage clickOnSearchButton(){
        $(searchButton).shouldBe(visible).click();
        return new ListingPage(driver);
    }

    public void selectCityForSearch(String index) throws InterruptedException {
        selectFromDropdawnMenuByIndex(city, citiesList, index);
    }

    public PostPage clickOnAddNewPostButton(){

         if ($(addNewPostButtonTop).isDisplayed()) {
             $(addNewPostButtonTop).click();
         } else {
             $(addNewPostButtonTop).waitUntil(visible, 3).click();
         }
        return new PostPage(driver);
    }

    public ListingPage clickOnFreebiesCategory(){
        if ($(categoryFreebies).isDisplayed()) {
            $(categoryFreebies).click();
        } else {
            $(categoryFreebies).waitUntil(visible, 3).click();
        }
        return new ListingPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

}
