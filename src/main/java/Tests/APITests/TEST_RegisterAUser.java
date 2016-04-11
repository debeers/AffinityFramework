package Tests.APITests;

import ApiWorker.APIManager;
import ApiWorker.model.users.User;
import ApiWorker.model.users.checkuser.CheckUserResponse;
import ApiWorker.model.users.signup.SignUpResponse;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created by Dem on 11.04.2016.
 */
public class TEST_RegisterAUser extends BaseTest {

    @Parameters({"userPhone" , "userLogin"})
    @Test
    public void Register_A_User(String userPhone, String userLogin) throws IOException {
        Call<CheckUserResponse> check = APIManager.getInstance().checkUser(userPhone);
        User userExists = check.execute().body().getUser();
        String userName = userExists.getUserName();
        if (userName.equals(userLogin)) {
            log.info("WE ALREADY HAVE A REGISTERED USER WITH NAME::: " + userLogin);
        } else {
            Call<SignUpResponse> res = APIManager.getInstance().signUp(false, true, userPhone, userLogin);
            res.execute();
            log.info("WE HADN'T A USER IN DATABASE. SO WE HAVE CREATED A NEW ONE::: " + userLogin);
        }
        Assert.assertEquals(userName , userLogin);
    }
}
