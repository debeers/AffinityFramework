package ApiWorker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 9/24/15.
 */
public class PostField extends BaseModel {

    public static final String ID = "id";
    public static final String CITY_ID = "city_id";
    public static final String CATEGORY_ID = "category_id";
    public static final String NEW_PASSWORD_ID = "newPassword";
    public static final String CONFIRM_PASSWORD_ID = "passwordConfirm";
    public static final String CHAT_ID = "chat_id";
    public static final String MESSAGE = "message";
    public static final String USER_HASH = "user_hash";
    public static final String AD_ID = "ad_id";
    public static final String MOBILE = "mobile";
    public static final String DESCRIPTION = "description";
    public static final String IS_NEGOTIABLE = "is_negotiable";
    public static final String PRICE = "price";
    public static final String CURRENCY = "currency";
    public static final String TITLE = "title";
    public static final String USERNAME = "username";
    public static final String TOKEN = "token";
    public static final String PLATFORM = "platform";
    public static final String DELETE = "delete";

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("value")
    @Expose
    private String value;

    public PostField() {

    }

    public PostField(String id, String value) {

        this.id = id;
        this.value = (value == null ? "" : value);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }
}
