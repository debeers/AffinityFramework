package Tests.GUITests.TESTPasswordRecovery;

import TESTResources.DataSources.AZ_AZ.DataProviders.DataProviderPasswordRecoveryErrors;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Actions.GUI_Actions.RestorePassword.restorePassword;

/**
 * Created by Dem on 19.06.2016.
 */
public class TESTPasswordRecoveryErrorsCheck extends BaseTest {

    @Test(dataProvider = "passwordConfirmFieldErrors" , dataProviderClass = DataProviderPasswordRecoveryErrors.class)
    public void testPasswordRecoveryErrorsCheck(String username , String passwordRecoveryError) throws InterruptedException, IOException {

        Assert.assertEquals(restorePassword(driver, username).getErrorTextOfUserLogin() , passwordRecoveryError);
    }
}
