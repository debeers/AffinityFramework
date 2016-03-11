package Actions;

import Entities.Post;
import PageObjects.PostPage;

import java.awt.*;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class PostAdd {

    public static PostPage makeNewPost(PostPage postPage, Post post, int countOfFilesToUpload)
            throws InterruptedException, AWTException {

        postPage.setCategory(post.getCategory());
        postPage.setUnderCategory(post.getUnderCategory());
        postPage.UploadImages(post, countOfFilesToUpload);
        postPage.setPostTitle(post.getTitle());
        postPage.setDescription(post.getDescription());
        postPage.setPrice(post.getPrice());
        postPage.setCurrency(post.getCurrencyType());
        postPage.checkIsNegotiableCheckBox(post.isNegotiable());
        postPage.setRegion(post.getRegion());
        postPage.setPostAs(post.getPrivacyType());
        postPage.setName(post.getName());
        postPage.setTelephoneNumber(post.getPhone());
        postPage.setHidePhoneNumber(post.isHideNumber());
        postPage.setEmail(post.getEmail());

        return postPage;
    }
}
