package PageObjects;

import Entities.Post;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static GeneralHelpers.JSTools.jsDeleteClassesById;
import static GeneralHelpers.RobotUpload.uploadFile;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by DeBeers on 08.03.2016.
 */

public class PostPage extends TopMenuGeneralPage implements ErrorHandler {

    @CacheLookup
    @FindBy(xpath = ".//*[@id='categoryId_chosen']/a")
    public WebElement categoriesChoose;

    @FindBy(xpath = "html/body/div[3]/div[1]")
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
    @FindBy(xpath = "*//div/input[@name='param_id[16]']")
    public WebElement areaParameter;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='1']//input[contains(@class,'yalla-upload-button')]")
    public List<WebElement> uploadPhotoButton;

    @FindBy(xpath = ".//*[@id='first-step']/div[3]/div[3]/input")
    public WebElement titleField;

    @FindBy(id = "loader")
    public WebElement loader;

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


    /**
     * Repeatedly check if the loader is still visible
     */
   /* public void waitTillLoaderFinishes() {
        String loadingDotsPath = "//div[@class='ebLoader-Holder']//span[contains(@class, 'ebLoader-Dots')]";

        try {
            mEventDriver.findElement(By.xpath(loadingDotsPath));
            WebDriverWait wait = new WebDriverWait(mEventDriver, LOADER_WAIT_TIMEOUT);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadingDotsPath)));
        } catch (NoSuchElementException e) {
        } catch (TimeoutException e) {
            Assert.fail("Timeout exception caught while waiting for loader to finish");
        }
    } */

    public void waitTillLoaderHides() {

        try {
            driver.findElement(By.id("loader"));
            WebDriverWait wait = new WebDriverWait(driver, 8000);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
        } catch (Exception e) {
            log.info("Timeout while waiting for loader to disappear");
        }
    }

   /* public void waitTillLoaderDissappear() {
        try {
            if (loader.isDisplayed()) {
                $(loader).should(disappear);
                log.info("Waiting till loader disappear");
            }
        } catch (Exception e) {
            log.info("No loaders were found, go nex step");
        }
    } */

    public void selectFromDropdawnMenuByIndex(WebElement element, List<WebElement> list, String index)
            throws InterruptedException {

        $(element).shouldBe(visible).click();
        try {
            list
                    .stream()
                    .filter(el -> el.getAttribute("data-option-array-index").equals(index))
                    .forEach(el -> $(el).shouldBe(visible).click());
        } catch (Exception e) {
            System.out.println("We`re catched Stale element ApiWorker.exception, but fuck it!)");
        }
    }

    public void setCategory(String categoryIndex) throws InterruptedException {
        selectFromDropdawnMenuByIndex(categoriesChoose, categoriesList, categoryIndex);
        waitTillLoaderHides();
    }

    public void setUnderCategory(String underCategoryIndex) throws InterruptedException {
        selectFromDropdawnMenuByIndex(underCategoriesChoose, underCategoriesList, underCategoryIndex);
        waitTillLoaderHides();
    }

    public void setThirdCategory(String thirdCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(underCategoriesChoose, underCategoriesList, thirdCategory);
        waitTillLoaderHides();
    }

    public void setAdditionalParam(String additionalParam) { $(areaParameter).
            shouldBe(visible).
            sendKeys(additionalParam);

    }

    public void setFourthCategory(String fourthCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(underCategoriesChoose, underCategoriesList, fourthCategory);
        waitTillLoaderHides();
    }

    public void setPostTitle(String title) {
        $(titleField).shouldBe(visible).sendKeys(title);
    }

    public void setDescription(String description) {
        $(descriptionField).shouldBe(visible).sendKeys(description);
    }

    public void setPrice(String price) {
        $(priceField).shouldBe(visible).clear();
        $(priceField).shouldBe(visible).sendKeys(price);
    }

    public void setCurrency(String currency) throws InterruptedException {
        jsDeleteClassesById(driver, "currencies");
        Select dropdown = new Select(choseCurrency);
        dropdown.selectByValue(currency);
    }

    public void checkIsNegotiableCheckBox(boolean isNegotiable) {
        if (isNegotiable)
            $(isNegotiableCheckBox).click();
    }

    public void setRegion(String regionIndex) throws InterruptedException {
        selectFromDropdawnMenuByIndex(regionListChoose, regionList, regionIndex);
        waitTillLoaderHides();
    }

    public void setPrivateTypeAsPrivate() {
        $(radioButtonPrivate).shouldBe(visible).click();
    }

    public void setPrivateTypeAsBusines() {
        $(radioButtonBusiness).shouldBe(visible).click();
    }

    public void setPostAs(String privateOrBusines) {

        if (privateOrBusines.equals("business")) {
            setPrivateTypeAsBusines();
        } else setPrivateTypeAsPrivate();
    }

    public void setName(String name) {
        $(nameField).shouldBe(visible).sendKeys(name);
    }

    public void setTelephoneNumber(String telephoneNumber) {
        $(phoneField).shouldBe(visible).clear();
        $(phoneField).shouldBe(visible).sendKeys(telephoneNumber);
    }

    public void setHidePhoneNumber(boolean hidePhoneNumber) {
        if (hidePhoneNumber)
            $(hidePhoneCheckBox).shouldBe(visible).click();
    }

    public void setEmail(String email) {
        $(emailField).shouldBe(visible).sendKeys(email);
    }

    public void clickOnPreviewButton() {
        $(previewButton).shouldBe(visible).click();
    }

    public PostPreviewPage clickOnPreviewButtonAndLoadPage(){

        clickOnPreviewButton();

        if (getFieldsErrors().size() == 0) {
            return new PostPreviewPage(driver);
        } else {
            System.out.println(
                    "Oops, some errors were detected in entering post data and you take a null pointer)");
            return null;
        }
    }

    public SuccessPostedPage clickOnSubmitButton() {
        $(submitButton).shouldBe(visible).click();

        if (getFieldsErrors().isEmpty()) {
            return new SuccessPostedPage(driver);
        } else {
            System.out.println(
                    "Oops, some errors were detected in entering post data and you take a null pointer)");
            return null;
        }
    }

    @Override
    public List<String> getFieldsErrors() {
        List<String> errorsList = new ArrayList<>();
        try {
            if ($$(errors).isEmpty()) {
                errors.stream().forEach((p) -> {
                    errorsList.add(p.getText());
                    System.out.println("ERRORS EXIST IN ENTERING REGISTRATION DATA:: " + p.getText());
                });
                return errorsList;
            }

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering post data");
        }
        return errorsList;
    }

    public void UploadImages(Post post, int countOfFilesToUpload)
            throws InterruptedException, AWTException {

        if (countOfFilesToUpload == 0) {
            System.out.println("No images will upload");
        } else {
            List<WebElement> inputs =
                    Arrays.asList(
                            fileUpload1,
                            fileUpload2,
                            fileUpload3,
                            fileUpload4,
                            fileUpload5
                    );

            for (int i = 4; i < countOfFilesToUpload; i++) {
                inputs.get(i).click();
                uploadFile(post.getListOfFiles().get(i).getAbsolutePath());
                Thread.sleep(2000);
                dummyClick.click();
                System.out.println(post.getListOfFiles().get(i).getAbsolutePath());
            }
        }
    }

    public PostPage(WebDriver driver) {
        super(driver);
    }
}
