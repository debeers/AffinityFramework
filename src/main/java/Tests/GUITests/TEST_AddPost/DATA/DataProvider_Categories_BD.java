package Tests.GUITests.TEST_AddPost.DATA;

import org.testng.annotations.DataProvider;

/**
 * Created by DeBeers on 09.04.2016.
 */
public class DataProvider_Categories_BD {


    @DataProvider(name="Undercategory")
    public static Object[][] Undercategory(){
        return new Object[][]{
                {"2", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=33) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"3", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=381) AND lang_id='ru' AND l_category is NOT NULL"},
                {"4", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1119) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"5", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1120) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"6", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1121) AND lang_id='ru' AND l_category IS NOT NULL"},
                {"7", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1122) AND lang_id='ru'"},
                {"8", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1123) AND lang_id='ru'"},
                {"9", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=36) AND lang_id='ru'"},
                {"10", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=40) AND lang_id='ru'"},
                {"18", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1581) AND lang_id='ru'"},
                {"24", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=313) AND lang_id='ru'"},
                {"45", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=9) AND lang_id='ru'"},
                {"46", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=12) AND lang_id='ru'"},
                {"49", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1011) AND lang_id='ru'"},
                {"51", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1080) AND lang_id='ru'"},
                {"52", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1081) AND lang_id='ru'"},
                {"53", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1082) AND lang_id='ru'"},
                {"54", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1083) AND lang_id='ru'"},
                {"55", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1084) AND lang_id='ru'"},
                {"74", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1536) AND lang_id='ru'"},
                {"75", "SELECT l_name FROM category_lang WHERE category_id IN (SELECT id FROM category WHERE lvl=3 AND parent_id=1537) AND lang_id='ru'"}
        };
    }


}
