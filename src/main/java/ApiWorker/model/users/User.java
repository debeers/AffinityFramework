package ApiWorker.model.users;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 7/26/15.
 */
public class User extends BaseModel {

    private static final String USER_ID = "user_id";
    private static final String USERNAME = "username";
    private static final String CITY = "city";
    private static final String AVATAR = "avatar";
    private static final String PASSWORD = "password";

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

    @SerializedName(PASSWORD)
    @Expose
    private String password;

    public User() {

    }

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
        this.password = password;
    }

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

    public String getPassword() {

        return password;
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

    public void setPassword(String password) {

        this.password = password;
    }
}
