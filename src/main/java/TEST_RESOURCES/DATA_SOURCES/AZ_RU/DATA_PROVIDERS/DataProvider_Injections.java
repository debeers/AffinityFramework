package TEST_RESOURCES.DATA_SOURCES.AZ_RU.DATA_PROVIDERS;

import org.testng.annotations.DataProvider;

/**
 * Created by DeBeers on 16.04.2016.
 */
public class DataProvider_Injections {

    @DataProvider(name="Injections")
    public static Object[][] Injections(){
        return new Object[][]{
                {"<script>alert(‘hello, Amigo’)</script>", "hello, Amigo"}
        };
    }


}
