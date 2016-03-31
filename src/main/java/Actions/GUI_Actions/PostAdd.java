package Actions.GUI_Actions;

import Entities.Post;
import PageObjects.PostPage;

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
        ifSetNegotiatablePrice(postPage, post);
        postPage.setRegion(post.getRegion());
        postPage.setPostAs(post.getPrivacyType());
        postPage.setName(post.getName());
        postPage.setTelephoneNumber(post.getPhone());
        postPage.setHidePhoneNumber(post.isHideNumber());
        postPage.setEmail(post.getEmail());

        return postPage;
    }

    public static void ifSetNegotiatablePrice(PostPage postPage, Post post) throws InterruptedException {

        if(!post.isNegotiable()) {
            postPage.setPrice(post.getPrice());
            postPage.setCurrency(post.getCurrencyType());
        }
        else {
            System.out.println("You are set negotiatible price");
            postPage.checkIsNegotiableCheckBox(post.isNegotiable());
        }

        if(isPriceFieldInactive(postPage)){
            System.out.println("Price field is active with negotiatable price setted! Bug catched!");
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


    public static void compareErrors(List<String> actual, List<String> expected) {


        List<String> foundErrors = new ArrayList<>();
        boolean ifFound = false;

        actual.stream().forEach((p) -> {

            for (String expectedError : expected) {

                if (p.equals(expectedError)) {

                    foundErrors.add(p);
                    System.out.println("We are found exact error::: " + p);
                }
            }
        });

//        for (String expectedError : expected){
//
//            if(foundErrors.contains(expectedError))
//                   return true;
//            else   return false;
//
//        }
//
//
//    }

    }
}
