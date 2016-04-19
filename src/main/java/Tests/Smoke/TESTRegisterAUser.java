package Tests.Smoke;

import ApiWorker.model.users.User;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import static Actions.API_Actions.RegistrationLogin.registerNewUserViaAPI;

/**
 * Created by Dem on 11.04.2016.
 */
@Test(groups="PRECONDITION")
public class TESTRegisterAUser extends BaseTest {

    @Parameters({"userPhone" , "userLogin"})
    @Test
    public void Register_A_User(String userPhone, String userLogin) throws IOException {

        User user = registerNewUserViaAPI(userPhone, userLogin, false, true);
        Assert.assertEquals(user.getUserName() , userLogin);
    }
}
