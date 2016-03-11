package PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class MainPage extends TopMenuGeneralPage {

    @FindBy(xpath = ".//ul[contains(@class,'user-nav')]/following-sibling::a[contains(@class,'post-free-ad btn green')]")
    public WebElement addNewPostButtonTop;

    @FindBy(xpath = ".//*[@id='search']/div/a")
    public WebElement searchButton;

    public PostPage clickOnAddNewPostButton(){

        $(addNewPostButtonTop).shouldBe(visible).click();
        return new PostPage(driver);
    }









    public MainPage(WebDriver driver) {
        super(driver);
    }

}
