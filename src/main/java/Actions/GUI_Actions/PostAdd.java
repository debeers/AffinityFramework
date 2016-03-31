package Actions.GUI_Actions;

import Entities.Post;
import PageObjects.PostPage;

import java.awt.*;

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
            System.out.println("Additional Parameter 'AREA' is not set");
    }

    public static void setFourthCategoryIfExists(PostPage postPage, Post post) throws InterruptedException {

        if (!post.getFourthCategory().equals("null"))
            postPage.setFourthCategory(post.getFourthCategory());
        else
            System.out.println("Fourth Category is not set");
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

    public static PostPage makeNewPost(PostPage postPage, Post post, int countOfFilesToUpload)
            throws InterruptedException, AWTException {

        postPage.setCategory(post.getCategory());
        setUnderCategoryIfExsist(postPage, post);
        setThirdCategoryIfExists(postPage, post);
        setFourthCategoryIfExists(postPage, post);
        setFifthCategoryIfExists(postPage, post);
        setSixthCategoryIfExists(postPage, post);
        setSeventhCategoryIfExists(postPage,post);
        setAdditionalParameterIfExists(postPage, post);
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

}
