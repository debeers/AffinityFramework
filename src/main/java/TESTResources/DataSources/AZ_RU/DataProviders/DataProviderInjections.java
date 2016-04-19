package TESTResources.DataSources.AZ_RU.DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by DeBeers on 16.04.2016.
 */
public class DataProviderInjections {

    @DataProvider(name="Injections")
    public static Object[][] Injections(){
        return new Object[][]{
                {"<script>alert(‘hello, Amigo’)</script>", "hello, Amigo"}
        };
    }


}
