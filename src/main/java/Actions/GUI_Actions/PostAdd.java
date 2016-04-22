package Actions.GUI_Actions;

import Entities.Post;
import PageObjects.PostPage;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by DeBeers on 08.03.2016.
 */
public class PostAdd {

    public static void setUnderCategoryIfExsist(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getUnderCategory().equals("null"))
            postPage.setUnderCategory(post.getUnderCategory());
        else
            System.out.println("Undercategory is not setted");
    }

    public static void setThirdCategoryIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getThirdCategory().equals("null"))
            postPage.setThirdCategory(post.getThirdCategory());
        else
            System.out.println("Third Category is not set");
    }

    public static void setAdditionalParameterIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getAdditionalParam().equals("null"))
            postPage.setAdditionalParam(post.getAdditionalParam());
        else
            System.out.println("Additional Parameter 'AREA' should not be set in this CATEGORY: " + post.getCategory());
    }

    public static void setFourthCategoryIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getFourthCategory().equals("null"))
            postPage.setFourthCategory(post.getFourthCategory());
        else
            System.out.println("Fourth Category is not set");
    }

    public static void setFourthCategoryYearIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getFourthCategoryYear().equals("null"))
            postPage.setFourthCategoryYear(post.getFourthCategoryYear());
        else
            System.out.println("Fourth Category YEAR OF MANUFACTURE is not set");
    }

    public static void setFifthCategoryIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getFifthCategory().equals("null"))
            postPage.setFifthCategory(post.getFifthCategory());
        else
            System.out.println("Fifth Category is not set");
    }

    public static void setSixthCategoryIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getSixthCategory().equals("null"))
            postPage.setSixthCategory(post.getSixthCategory());
        else
            System.out.println("Sixth Category is not set");
    }

    public static void setSeventhCategoryIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getSeventhCategory().equals("null"))
            postPage.setSeventhCategory(post.getSeventhCategory());
        else
            System.out.println("Seventh Category is not set");
    }

    public static void setAddParamMileageIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getAdditionalParamMileage().equals("null"))
            postPage.setAdditionalParamMileage(post.getAdditionalParamMileage());
        else
            System.out.println("Parameter 'MILEAGE' should not be set in this CATEGORY: " + post.getCategory());
    }

    public static void setAddParamEngineIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getAdditionalParamEngine().equals("null"))
            postPage.setAdditionalParamEngine(post.getAdditionalParamEngine());
        else
            System.out.println("Parameter 'ENGINE' should not be set in this CATEGORY: " + post.getCategory());
    }

    public static void setCityIfExists(PostPage postPage, Post post) throws InterruptedException {
        if (!post.getCity().equals("null"))
            postPage.setCity(post.getCity());
        else
            System.out.println("THERE IS NO REGION ON THIS WEBSITE: ");
    }

    public static PostPage makeNewPost(PostPage postPage, Post post, int countOfFilesToUpload)
            throws InterruptedException, AWTException {

        postPage.setCategory(post.getCategory());
        setUnderCategoryIfExsist(postPage, post);
        setThirdCategoryIfExists(postPage, post);
        setFourthCategoryIfExists(postPage, post);
        setFourthCategoryYearIfExists(postPage, post);
        setFifthCategoryIfExists(postPage, post);
        setSixthCategoryIfExists(postPage, post);
        setSeventhCategoryIfExists(postPage,post);
        setAdditionalParameterIfExists(postPage, post);
        setAddParamMileageIfExists(postPage, post);
        setAddParamEngineIfExists(postPage, post);
        postPage.UploadImages(post, countOfFilesToUpload);
        postPage.setPostTitle(post.getTitle());
        postPage.setDescription(post.getDescription());
        ifSetNegotiablePrice(postPage, post);
        postPage.setRegion(post.getRegion());
        setCityIfExists(postPage, post);
        postPage.setPostAs(post.getPrivacyType());
        postPage.setName(post.getName());
        postPage.setTelephoneNumber(post.getPhone());
        postPage.setHidePhoneNumber(post.isHideNumber());
        postPage.setEmail(post.getEmail());

        return postPage;
    }
    //    public String makeDescription(String descriptionParam){
//
//        if(descriptionParam.equalsIgnoreCase("auto"))
//             return RandomStringUtils.randomAlphabetic(50);
//        else return descriptionParam;
//    }

    public static void ifSetNegotiablePrice(PostPage postPage, Post post) throws InterruptedException {

        if(!post.isNegotiable() && !post.getCurrencyType().equals("null ")) {
            postPage.setPrice(post.getPrice());
            postPage.setCurrency(post.getCurrencyType());
        }
        else {
            System.out.println("You have set negotiable price");
            postPage.checkIsNegotiableCheckBox(post.isNegotiable());
        }

        if(isPriceFieldInactive(postPage)){
            System.out.println("Price field is active with negotiable price set! Bug caught!");
        }

    }

    public static boolean isPriceFieldInactive(PostPage postPage){
        if(!postPage.priceField.isEnabled()){
            System.out.println("Price field is inactive!");
            return true;
        }else
            System.out.println("Price field is active");
            return false;
    }


    public static boolean compareErrors(List<String> actual, List<String> expected) {

        List<String> foundErrors = new ArrayList<>();

        actual.stream().forEach((p) -> {

            for (String expectedError : expected) {

                if (p.contains(expectedError)) {

                    foundErrors.add(p);
                    System.out.println("We are found exact error::: " + p);
                }
            }
        });

        if (foundErrors.isEmpty())
            return false;
        else
            return true;
    }

    public static boolean compareErrors(List<String> actual, String expected) {

        boolean[] r = {false};
        actual.stream().forEach((p) -> {

                 if (p.contains(expected))
                     System.out.println("We are found exact error::: " + p);
                     r[0] = true;
         });
        return r[0];
    }

    public static boolean compareErrors(String actual, String expected) {
        System.out.println("actual error:::" + actual);
        System.out.println("actual expected:::" + expected);
            if (actual.contains(expected)) {
                System.out.println("We are found exact error::: ");
                return true;
            }
            else
                return false;
    }

    public static boolean compeareAllertMessage(WebDriver driver, String allertMessage){

            if(getAllertText(driver).contains(allertMessage))
                return true;
            else
                return false;
    }

    public static String getAllertText(WebDriver driver){
        String actualAllertMessage = "";
        try {

            actualAllertMessage = driver.switchTo().alert().getText();
            return actualAllertMessage;

        }catch (Exception e){
            System.out.println("No allerts appears, test passed");
        }
        return actualAllertMessage;
    }
}
