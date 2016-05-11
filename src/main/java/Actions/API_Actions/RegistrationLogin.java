package Actions.API_Actions;

import ApiWorker.APIManager;
import ApiWorker.model.users.checkUser.CheckUserResponse;
import ApiWorker.model.users.signUp.SignUpResponse;
import Entities.User;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created by DeBeers on 12.04.2016.
 */
public class RegistrationLogin {

    public static User checkUserViaApi(String userPhone) throws IOException {
        Call<CheckUserResponse> check = APIManager.getInstance().checkUser(userPhone);
        User userExists = check.execute().body().getUser();
        return userExists;
    }

    public static boolean isUserExist(String userPhone, String userLogin) throws IOException {

        User user = checkUserViaApi(userPhone);

        return user.getUserName() != null && user.getUserName().equals(userLogin);
    }

    public static User registerNewUserViaAPI(String userPhone, String userLogin, boolean confirmation, boolean autogeneration) throws IOException {
        if(!isUserExist(userPhone, userLogin)) {

            System.out.println("WE HADN'T A USER IN DATABASE. SO WE HAVE CREATED A NEW ONE::: " + userLogin);
            Call<SignUpResponse> res = APIManager.getInstance().signUp(confirmation, autogeneration, userPhone, userLogin); //false true
            res.execute();

        }else {
            System.out.println("WE ALREADY HAVE A REGISTERED USER WITH NAME::: " + userLogin);
        }

        return checkUserViaApi(userPhone);
    }
}
