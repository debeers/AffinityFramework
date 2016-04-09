package Tests.GUITests.TEST_AddPost.DATA;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.DataProvider;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class DataProvider_Categories_BD {


    @DataProvider(name="Undercategory")
    public static Object[][] Undercategory(){
        return new Object[][]{
                {"", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1536) AND lang_id='ru'"},
                {RandomStringUtils.randomAlphabetic(49), "Описание слишком короткий (минимум 50 символов)."},
                {RandomStringUtils.randomAlphabetic(50), ""},
                {RandomStringUtils.randomAlphabetic(2049), ""},
        };
    }


}
