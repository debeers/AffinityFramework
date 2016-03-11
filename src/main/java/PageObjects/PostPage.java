package PageObjects;

import Entities.Post;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;
import java.util.List;

import static GeneralHelpers.JSTools.jsDeleteClasses;
import static GeneralHelpers.RobotUpload.uploadFile;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.Collections.*;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class PostPage extends TopMenuGeneralPage {

    @CacheLookup
    @FindBy(xpath = ".//*[@id='categoryId_chosen']/a")
    public WebElement categoriesChoose;

    @FindBy(xpath = "html/body/div[3]/div[2]/div/h3")
    public WebElement dummyClick;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='categoryId_chosen']//ul//li[contains(@class,'active-result')]")
    public List<WebElement> categoriesList;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='subcategory_chosen']/a")
    public WebElement underCategoriesChoose;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='subcategory_chosen']//div//ul//li[contains(@class,'active-result')]")
    public List<WebElement> underCategoriesList;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='1']//input[contains(@class,'yalla-upload-button')]")
    public List<WebElement> uploadPhotoButton;

    @FindBy(xpath = ".//*[@id='first-step']/div[3]/div[3]/input")
    public WebElement titleField;

    @FindBy(xpath = ".//*[@id='decription']")
    public WebElement descriptionField;

    @FindBy(xpath = ".//*[@id='priceBlock']/input")
    public WebElement priceField;

    @FindBy(xpath = ".//*[@id='currencies']")
    public WebElement choseCurrency;

    @FindBy(xpath = ".//*[@id='priceBlock']/label[2]")
    public WebElement isNegotiableCheckBox;

    @FindBy(xpath = ".//*[@id='regionId_chosen']/a")
    public WebElement regionListChoose;

    @FindBy(xpath = ".//*[@id='regionId_chosen']//ul/li[contains(@class,'active-result')]")
    public List<WebElement> regionList;

    @FindBy(xpath = ".//*[@id='first-step']//label[contains(@class,'label-radio')][1]")
    public WebElement radioButtonPrivate;

    @FindBy(xpath = ".//*[@id='first-step']//label[contains(@class,'label-radio')][2]")
    public WebElement radioButtonBusiness;

    @FindBy(xpath = ".//input[contains(@name,'name')]")
    public WebElement nameField;

    @FindBy(xpath = ".//input[contains(@name,'telephone')]")
    public WebElement phoneField;

    @FindBy(xpath = ".//*[@id='first-step']//label[contains(@for,'hideTelephone')]")
    public WebElement hidePhoneCheckBox;

    @FindBy(xpath = ".//input[contains(@name,'email')]")
    public WebElement emailField;

    @FindBy(xpath = ".//*[@id='preview-ad']")
    public WebElement previewButton;

    @FindBy(xpath = ".//*[@id='update-ad']")
    public WebElement submitButton;

    @FindBy(xpath = ".//*[@class='error-message']")
    public List<WebElement> errors;

    @FindBy(xpath = ".//*[@id='1']/div/input")
    public WebElement fileUpload1;

    @FindBy(xpath = ".//*[@id='2']/div/input")
    public WebElement fileUpload2;

    @FindBy(xpath = ".//*[@id='3']/div/input")
    public WebElement fileUpload3;

    @FindBy(xpath = ".//*[@id='4']/div/input")
    public WebElement fileUpload4;

    @FindBy(xpath = ".//*[@id='5']/div/input")
    public WebElement fileUpload5;




    public void selectFromDropdawnMenuByIndex(WebElement element, List<WebElement> list, String index) throws InterruptedException {
        $(element).shouldBe(Condition.visible).click();
        try {
            list
                    .stream()
                    .filter(el -> el.getAttribute("data-option-array-index").equals(index))
                    .forEach(el -> $(el).shouldBe(Condition.visible).click());
        }catch (Exception e){
            System.out.println("We`re catched Stale element exception, but fuck it!)");
        }

    }

    public void setCategory(String categoryIndex) throws InterruptedException {
        selectFromDropdawnMenuByIndex(categoriesChoose, categoriesList, categoryIndex);
    }

    public void setUnderCategory(String underCategoryIndex) throws InterruptedException {

        selectFromDropdawnMenuByIndex(underCategoriesChoose, underCategoriesList, underCategoryIndex);
    }

    public void setPostTitle(String title){
        $(titleField).shouldBe(Condition.visible).sendKeys(title);
    }

    public void setDescription(String description){
        $(descriptionField).shouldBe(Condition.visible).sendKeys(description);
    }

    public void setPrice(String price){
        $(priceField).shouldBe(Condition.visible).clear();
        $(priceField).shouldBe(Condition.visible).sendKeys(price);
    }

    public void setCurrency(String currency) throws InterruptedException {
        jsDeleteClasses(driver);
        Select dropdown = new Select(choseCurrency);
        dropdown.selectByValue(currency);
    }

    public void checkIsNegotiableCheckBox(boolean isNegotiable){
        if(isNegotiable)
            $(isNegotiableCheckBox).click();
    }

    public void setRegion(String regionIndex) throws InterruptedException {
        selectFromDropdawnMenuByIndex(regionListChoose, regionList, regionIndex);
    }

    public void setPrivateTypeAsPrivate(){
        $(radioButtonPrivate).shouldBe(Condition.visible).click();
    }

    public void setPrivateTypeAsBusines(){
        $(radioButtonBusiness).shouldBe(Condition.visible).click();
    }

    public void setPostAs(String privateOrBusines){

        if (privateOrBusines.equals("business")){
            setPrivateTypeAsBusines();
        }else setPrivateTypeAsPrivate();
    }

    public void setName(String name){
        $(nameField).shouldBe(Condition.visible).sendKeys(name);
    }

    public void setTelephoneNumber(String telephoneNumber){
        $(phoneField).shouldBe(Condition.visible).clear();
        $(phoneField).shouldBe(Condition.visible).sendKeys(telephoneNumber);
    }

    public void setHidePhoneNumber(boolean hidePhoneNumber){
        if(hidePhoneNumber)
        $(hidePhoneCheckBox).shouldBe(Condition.visible).click();
    }

    public void setEmail(String email){
        $(emailField).shouldBe(Condition.visible).sendKeys(email);
    }


    public PostPreviewPage clickOnPreviewButton(){
        $(previewButton).shouldBe(Condition.visible).click();
        return new PostPreviewPage(driver);
    }

    public SuccessPostedPage clickOnSubmitButton(){
        $(submitButton).shouldBe(Condition.visible).click();

        try {
            if ($$(errors).shouldBe().size() != 0) {
                errors.stream().forEach((p) ->
                        System.out.println("ERRORS EXIST IN ENTERING REGISTRATION DATA:: " + p.getText()));
            }
            return null;

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering post data");
        }
        return new SuccessPostedPage(driver);
    }

    public void UploadImages(Post post, int countOfFilesToUpload) throws InterruptedException, AWTException {

        List<WebElement> inputs = Arrays.asList(fileUpload1, fileUpload2, fileUpload3, fileUpload4, fileUpload5);
        for(int i = 0; i<countOfFilesToUpload; i++){
            inputs.get(i).click();
            uploadFile(post.getListOfFiles().get(i).getAbsolutePath());
            Thread.sleep(3000);
            dummyClick.click();
            System.out.println(post.getListOfFiles().get(i).getAbsolutePath());
        }


    }

    public PostPage(WebDriver driver) {
        super(driver);
    }
}
