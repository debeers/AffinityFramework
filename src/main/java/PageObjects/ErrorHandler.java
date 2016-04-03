package PageObjects;

import java.util.List;

/**
 * Created by DeBeers on 13.03.2016.
 */
public interface ErrorHandler {

    List<String> getAllFieldsErrors() throws InterruptedException;

     static boolean compareErrors(String actual, String expected) {

        System.out.println("actual error::::::" + actual);
        System.out.println("expected error::::" + expected);

        if (actual.contains(expected)) {
            System.out.println("We are found exact error::: ");
               return true;
        } else return false;
    }

}
