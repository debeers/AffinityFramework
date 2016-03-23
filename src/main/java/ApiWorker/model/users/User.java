package ApiWorker.model.users;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 7/26/15.
 */
public class User extends BaseModel implements Parcelable {

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

    protected User(Parcel in) {
        super(in);
        id = in.readLong();
        userName = in.readString();
        city = in.readString();
        avatar = in.readString();
        password = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(id);
        dest.writeString(userName);
        dest.writeString(city);
        dest.writeString(avatar);
        dest.writeString(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public static User fromCursor(Cursor cursor) {

        if (cursor == null || !cursor.moveToFirst())
            return null;

        User user = new User();

        int columnIndex = cursor.getColumnIndex(USER_ID);
        if (columnIndex != -1)
            user.setId(cursor.getLong(columnIndex));

        columnIndex = cursor.getColumnIndex(USERNAME);
        if (columnIndex != -1)
            user.setUsername(cursor.getString(columnIndex));

        columnIndex = cursor.getColumnIndex(CITY);
        if (columnIndex != -1)
            user.setCity(cursor.getString(columnIndex));

        columnIndex = cursor.getColumnIndex(AVATAR);
        if (columnIndex != -1)
            user.setAvatar(cursor.getString(columnIndex));

        columnIndex = cursor.getColumnIndex(PASSWORD);
        if (columnIndex != -1)
            user.setPassword(cursor.getString(columnIndex));

        return user;
    }
}
