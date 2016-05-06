package Entities;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Properties;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class User extends BaseModel {

    private static final String USER_ID = "user_id";
    private static final String USERNAME = "username";
    private static final String CITY = "city";
    private static final String AVATAR = "avatar";
    private static final String API_PASSWORD = "password";

    private String phoneNumber  = "";
    private String email        = "";
    private String password     = "";
    private String userPhone    = "";
    private String userPassword = "";

    @SerializedName(USER_ID)
    @Expose
    private long id;

    @SerializedName(USERNAME)
    @Expose
    private String userName;

    @SerializedName(CITY)
    @Expose
    private String city;

    @SerializedName(AVATAR)
    @Expose
    private String avatar;

    @SerializedName(API_PASSWORD)
    @Expose
    private String apiPassword;

    public User(){}

    ////////GUI CONSTRUCTORS///////////
    public User(String userPhone, Properties props, String password) {
        this.userPhone    = userPhone;
        this.email        = props.getProperty("email")
                            .equalsIgnoreCase("auto")
                            ?("TEST_GUI_USER" + RandomStringUtils.randomAlphabetic(9)
                            + "@gmail.com") : props.getProperty("email");
        this.password     = password;
        userLog();
    }

    public User(String userPhone, String password) {
        this.userPhone    = userPhone;
        this.password     = password;
    }
    //////////////////////////////////
    ///////API CONSTRUCTORS///////////

    public User(long id, String userName, String city) {

        this.id = id;
        this.userName = userName;
        this.city = city;
    }

    public User(long id, String userName, String city, String avatar, String password) {
        this.id = id;
        this.userName = userName;
        this.city = city;
        this.avatar = avatar;
        this.apiPassword = password;
    }

    public void userLog(){
        System.out.println("_____________:::USER PARAMETERS LOG:::_____________");
        System.out.println();
        System.out.println("USER PHONE NUMBER......" + this.getPhoneNumber());
        System.out.println("USER PASSWORD.........." + this.getPassword());
        System.out.println("USER EMAIL............." + this.getEmail());
        System.out.println();
        System.out.println("___________________________________________________");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() { return userPhone; }
    public String getUserPassword() { return userPassword; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getApiPassword() {

        return apiPassword;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean hasValidId() {

        return id > 0;
    }

    public void setApiPassword(String apiPassword) {

        this.apiPassword = apiPassword;
    }

}
