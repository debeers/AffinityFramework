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
import java.util.stream.Collectors;

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
    @FindBy(css = "#categoryId_chosen>a")
    public WebElement categoriesChoose;

    @FindBy(xpath = "html/body/div[3]/div[1]")
    public WebElement dummyClick;

    @CacheLookup
    @FindBy(css = "#categoryId_chosen>.chosen-drop>.chosen-results>.active-result:not(:first-child)")
    public List<WebElement> categoriesList;

    @FindBy(xpath = ".//*[@id='categoryId_chosen']/a")
    public WebElement firstSubCategoryChoose;

    @FindBy(xpath = ".//*[@id='subcategory_chosen']//div//ul//li[@class='active-result result-selected']")
    public WebElement defaultUnderCategoryById;

    @FindBy(xpath = ".//*[@id='1_subcategory_chosen']//div//ul//li[@class='active-result result-selected']")
    public WebElement defaultFirstSubcategory;

    @FindBy(xpath = ".//div//div[@id='1_subcategory_chosen']")
    public WebElement firstSubcategoryDiv;

    @FindBy(xpath = ".//*[@id='1_subcategory']/following-sibling::div/a")
    public WebElement defaultFirstSubcategoryClick;

    @FindBy(xpath = ".//*[@id='1_subcategory_chosen']//div//ul//li[@class='active-result'][position()>0]")
    public List<WebElement> defaultFirstSubcategoriesList;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='categoryId_chosen']//div//ul//li[@class='active-result'][position()>0]")
    public List<WebElement> firstSubCategoriesList;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='2_subcategory_chosen']/a")
    public WebElement secondSubCategorySelect;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='subcategory_chosen']/a")
    public WebElement thirdCategorySelectById;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='2_subcategory_chosen']/div/ul/li[@class='active-result'][position()>0]")
    public List<WebElement> secondSubCategoriesList;

    //Post to Used Cars category --BEGIN--

    @CacheLookup
    @FindBy(xpath = "*//div[4]/div[1]/a")
    public WebElement fifthCategorySelectBody;

    @CacheLookup
    @FindBy(xpath = "*//div[4]/div[1]/div/ul/li[@class='active-result'][position()>0]")
    public List<WebElement> fifthCategoriesListBody;

    @CacheLookup
    @FindBy(xpath = "*//div[2]/div/div[5]/input")
    public WebElement mileage;

    @CacheLookup
    @FindBy(xpath = "*//div[6]/div[1]/a")
    public WebElement sixthCategorySelectGearbox;

    @CacheLookup
    @FindBy(xpath = "*//div[6]/div[1]/div/ul/li")
    public List<WebElement> sixthCategoriesListGearbox;

    @CacheLookup
    @FindBy(xpath = "*//div[7]/div[1]/a")
    public WebElement seventhCategorySelectEngineType;

    @CacheLookup
    @FindBy(xpath = "*//div[7]/div[1]/div/ul/li")
    public List<WebElement> seventhCategoriesListEngine;

    @CacheLookup
    @FindBy(xpath = "*//div[2]/div/div[8]/input")
    public WebElement engineVolume;

    //Post to Used Cars category --END--

    //Parameters
    //
    @CacheLookup
    @FindBy(xpath = ".//select[@name='param_id[4]']/following-sibling::div/a")
    public WebElement fourthCategorySelectYear;

    @CacheLookup
    @FindBy(xpath = ".//select[@name='param_id[4]']/following-sibling::div//ul/li[@class='active-result'][position()>0]")
    public List<WebElement> fourthCategoriesListYear;

    @CacheLookup
    @FindBy(xpath = "*//div/input[@name='param_id[16]']")
    public WebElement areaParameter;

    @FindBy(xpath = ".//select[@name='param_id[11]']/following-sibling::div/a")
    public WebElement propertyParams;

    @FindBy(xpath = ".//select[@name='param_id[11]']/following-sibling::div//ul/li[position()>1]")
    public List<WebElement> propertyParamsList;

    @FindBy(xpath = ".//select[@name='param_id[9]']/following-sibling::div/a")
    public WebElement workingSchedule;

    @FindBy(xpath = ".//select[@name='param_id[9]']/following-sibling::div//ul/li[position()>1]")
    public List<WebElement> workingScheduleList;
    //
    //Parameters --END-

    @CacheLookup
    @FindBy(xpath = "*//div[4]/div[1]/a")
    public WebElement fourthCategorySelect;

    @CacheLookup
    @FindBy(xpath = "*//div[4]/div[1]/div/ul/li")
    public List<WebElement> fourthCategoriesList;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='1']//input[contains(@class,'yalla-upload-button')]")
    public List<WebElement> uploadPhotoButton;

    @FindBy(xpath = ".//*[@id='title']")
    public WebElement titleField;

    @FindBy(id = "loader")
    public WebElement loader;

    @FindBy(xpath = ".//*[@id='decription']")
    public WebElement descriptionField;

    @FindBy(xpath = ".//*[@id='price']")
    public WebElement priceField;

    @FindBy(xpath = ".//*[@id='categories-and-params']//div[1]/a")
    public WebElement underCategoryParameter;

    @FindBy(xpath = ".//*[@id='categories-and-params']//div[1]/div//ul//li[@class='active-result'][position()>0]")
    public List<WebElement> underCategoryParameterList;

    @FindBy(xpath = ".//*[@id='currencies']")
    public WebElement choseCurrency;

    @FindBy(xpath = ".//*[@id='isNegotiable']/..")
    public WebElement isNegotiableCheckBox;

    @FindBy(xpath = ".//*[@id='regionId_chosen']/a")
    public WebElement regionListChoose;

    @FindBy(xpath = ".//*[@id='regionId_chosen']//ul/li[contains(@class,'active-result')]")
    public List<WebElement> regionList;

    @FindBy(xpath = ".//*[@id='for-cities']/div[1]/div/a")
    public WebElement citiesListChoose;

    @FindBy(xpath = ".//*[@id='for-cities']/div[1]/div/div/ul/li[@class='active-result'][position()>0]")
    public List<WebElement> citiesList;

    @FindBy(xpath = ".//*[@id='advert_type_private']")
    public WebElement radioButtonPrivate;

    @FindBy(xpath = ".//*[@id='advert_type_business']/..")
    public WebElement radioButtonBusiness;

    @FindBy(xpath = ".//*[@id='name']")
    public WebElement nameField;

    @FindBy(xpath = ".//*[@id='phone_number']")
    public WebElement phoneField;

    @FindBy(xpath = ".//*[@id='hideTelephone']/..")
    public WebElement hidePhoneCheckBox;

    @FindBy(xpath = ".//*[@id='email']")
    public WebElement emailField;

    @FindBy(xpath = ".//*[@id='preview-ad']")
    public WebElement previewButton;

    @FindBy(xpath = ".//*[@id='update-ad']")
    public WebElement submitButton;

    @FindBy(xpath = ".//*[contains(@id,'error')]")
    public List<WebElement> errors;

    @FindBy(xpath = ".//*[@id='title-errors']")
    public WebElement titleErrorBlock;

    @FindBy(xpath = ".//*[@id='description-errors']")
    public WebElement descriptionErrorBlock;

    @FindBy(xpath = ".//*[@id='name-errors']")
    public WebElement nameErrorBlock;

    @FindBy(xpath = ".//*[@id='email-errors']")
    public WebElement emailErrorBlock;

    @FindBy(xpath = ".//*[@id='telephone-errors']")
    public WebElement phoneErrorBlock;

    @FindBy(xpath = ".//*[@id='price-errors']")
    public WebElement priceErrorBlock;

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


    public String getTextFromDescriptionErrorBlock() {
        return $(descriptionErrorBlock).shouldBe(visible).getText();
    }


    public void waitTillLoaderHides() {

        try {
            driver.findElement(By.id("loader"));
            WebDriverWait wait = new WebDriverWait(driver, 2000);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
        } catch (Exception e) {
            log.info("Timeout while waiting for loader to disappear");
        }
    }


    public void selectFromDropdawnMenuByIndex(WebElement element, List<WebElement> list, String index)
            throws InterruptedException {

        $(element).shouldBe(visible).click();
        try {
            list
                    .stream()
                    .filter(el -> el.getAttribute("data-option-array-index").equals(index))
                    .forEach(el -> $(el).shouldBe(visible).click());
        } catch (Exception e) {
            System.out.println("We have caught STALE element exception. Trying to ignore it");
        }
    }

    public List<String> getListCategoriesFromGUI() {
        $(categoriesChoose).shouldBe(visible).click();
        return categoriesList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
    }

    public List<String> getListUnderCategoriesFromGUI() {
        if ($(defaultFirstSubcategoryClick).isDisplayed()) {
            $(defaultFirstSubcategoryClick).shouldBe(visible).click();
            return defaultFirstSubcategoriesList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
        } else if ($(underCategoryParameter).isDisplayed()){
            $(underCategoryParameter).shouldBe(visible).click();
            return underCategoryParameterList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
        } else {
            $(fourthCategorySelectYear).shouldBe(visible).click();
            return fourthCategoriesListYear.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
        }
    }

    public List<String> getFourthLvlSubCategoryFromGUI() {
        $(fifthCategorySelectBody).shouldBe(visible).click();
        return fifthCategoriesListBody.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
    }

    public List<String> getThirdLvlSubCategoryFromGUI() {

        $(secondSubCategorySelect).shouldBe(visible).click();
        return secondSubCategoriesList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
    }

    public List<String> getYearOfManufactureForMotorcyclesCategory() {
        $(fourthCategorySelectYear).shouldBe(visible).click();
        return fourthCategoriesListYear.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
    }

    public List<String> getPropertyParametersList() {
        if ($(propertyParams).isDisplayed()){
            $(propertyParams).shouldBe(visible).click();
            return propertyParamsList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());}
        else {
            $(secondSubCategorySelect).shouldBe(visible).click();
            return secondSubCategoriesList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
        }
    }

    public List<String> getWorkingScheduleList() {
        $(workingSchedule).shouldBe(visible).click();
        return workingScheduleList.stream().map((webElement) -> webElement.getText().trim()).collect(Collectors.toList());
    }

    public List<String> getListCitiesFromGUI() {
        $(regionListChoose).shouldBe(visible).click();
        return regionList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public PostPage setCategory(String categoryIndex) throws InterruptedException {
//        jsDisableDropdownCompactView(driver);
        selectFromDropdawnMenuByIndex(categoriesChoose, categoriesList, categoryIndex);
        waitTillLoaderHides();
        return this;
    }

    public PostPage setUnderCategory(String underCategoryIndex) throws InterruptedException {
        if ($(defaultUnderCategoryById).exists()) {
            selectFromDropdawnMenuByIndex(firstSubCategoryChoose, firstSubCategoriesList, underCategoryIndex);
        }
        waitTillLoaderHides();
        return this;
    }

    public PostPage setUnderCategoryForCertainPages(String underCategoryIndex) throws InterruptedException {
        //jsDisableDropdownCompactViewForSubcategories(driver);
        if ($(firstSubcategoryDiv).isDisplayed()) {
            selectFromDropdawnMenuByIndex(defaultFirstSubcategoryClick, defaultFirstSubcategoriesList, underCategoryIndex);
        }
            waitTillLoaderHides();
        return this;
    }



    public PostPage setThirdCategory(String thirdCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(secondSubCategorySelect, secondSubCategoriesList, thirdCategory);
        waitTillLoaderHides();
        return this;
    }

    public void setAdditionalParam(String additionalParam) {
        $(areaParameter).
                shouldBe(visible).
                sendKeys(additionalParam);
    }

    public PostPage setFourthCategoryYear(String fourthCategoryYear) throws InterruptedException {
        selectFromDropdawnMenuByIndex(fourthCategorySelectYear, fourthCategoriesListYear, fourthCategoryYear);
        waitTillLoaderHides();
        return this;
    }

    public void setFourthCategory(String fourthCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(fourthCategorySelect, fourthCategoriesList, fourthCategory);
        waitTillLoaderHides();
    }

    public void setFifthCategory(String fifthCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(fifthCategorySelectBody, fifthCategoriesListBody, fifthCategory);
        waitTillLoaderHides();
    }

    public void setSixthCategory(String sixthCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(sixthCategorySelectGearbox, sixthCategoriesListGearbox, sixthCategory);
        waitTillLoaderHides();
    }

    public void setSeventhCategory(String seventhCategory) throws InterruptedException {
        selectFromDropdawnMenuByIndex(seventhCategorySelectEngineType, seventhCategoriesListEngine, seventhCategory);
        waitTillLoaderHides();
    }

    public void setAdditionalParamMileage(String mileageParam) throws InterruptedException {
        $(mileage).
                shouldBe(visible).
                sendKeys(mileageParam);
    }

    public void setAdditionalParamEngine(String engineParam) throws InterruptedException {
        $(engineVolume).
                shouldBe(visible).
                sendKeys(engineParam);
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

    public void setCity(String cityIndex) throws InterruptedException {
        if ($(citiesListChoose).exists()) {
            selectFromDropdawnMenuByIndex(citiesListChoose, citiesList, cityIndex);
            waitTillLoaderHides();
        } else {
            log.info("There is no city field on this locale");
        }
    }

    public void setPrivateTypeAsPrivate() {
        $(radioButtonPrivate).shouldBe(visible).click();
    }

    public void setPrivateTypeAsBusines() {
        $(radioButtonBusiness).click();
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

    public PostPreviewPage clickOnPreviewButtonAndLoadPage() throws InterruptedException {

        clickOnPreviewButton();

        if (getAllFieldsErrors().isEmpty()) {
            return new PostPreviewPage(driver);
        } else {
            System.out.println(
                    "Oops, some errors were detected in entering post data and you take a null pointer)");
            return null;
        }
    }

    public void fillinNegativeDataInTheFieldAndSubmit(String enterData, WebElement input, WebElement button) throws InterruptedException {
        $(input).shouldBe(visible).clear();
        $(input).shouldBe(visible).sendKeys(enterData);
        button.click();
    }

    public SuccessPostedPage clickOnSubmitButton() throws InterruptedException {
        $(submitButton).shouldBe(visible).click();

        if (getAllFieldsErrors().isEmpty()) {
            return new SuccessPostedPage(driver);
        } else {
            System.out.println(
                    "Oops, some errors were detected in entering post data and you take a null pointer)");
            return null;
        }
    }

    @Override
    public List<String> getAllFieldsErrors() throws InterruptedException {

        List<String> errorsList = new ArrayList<>();
        Thread.sleep(4000); //need to implement waiter
        try {
            if (!$$(errors).isEmpty()) {
                errors.stream().forEach((p) -> {
                    if (!p.getText().trim().equalsIgnoreCase("")) {
                        errorsList.add(p.getText());
                        System.out.println("ERRORS EXIST IN ENTERING POST DATA:: " + p.getText());
                    }

                });
                return errorsList;
            }

        } catch (Exception e) {
            System.out.println("Everything looks fine, no error messages was found in entering post data");
        }
        return errorsList;
    }


    public String getFieldError(WebElement errorBlock) {

        String titleError = "";
        try {
            Thread.sleep(4000);
            if ($(errorBlock).isDisplayed()) {

                titleError = $(errorBlock).shouldBe(visible).getText();
                return titleError;
            } else return titleError;


        } catch (Exception e) {
            System.out.println("No error was appear");
        }
        return titleError;
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
