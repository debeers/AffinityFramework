package Actions;

import Entities.Post;
import PageObjects.PostPage;
import com.codeborne.selenide.Condition;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$;

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

    public static PostPage makeNewPost(PostPage postPage, Post post, int countOfFilesToUpload)
            throws InterruptedException, AWTException {

        postPage.setCategory(post.getCategory());
        setUnderCategoryIfExsist(postPage, post);
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
//        System.out.println("================"+postPage.priceField.getAttribute("disabled").trim());
        if(!postPage.priceField.isEnabled()){
            System.out.println("Price field is inactive!");
            return true;
        }else
            System.out.println("Price field is active");
            return false;
    }

}
