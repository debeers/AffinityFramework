package ApiWorker.model.ads.getpostfields;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by artem on 8/23/15.
 */
public class UserInfoField extends BaseField implements Parcelable {

    public UserInfoField() {

    }

    protected UserInfoField(Parcel in) {
        super(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfoField> CREATOR = new Creator<UserInfoField>() {
        @Override
        public UserInfoField createFromParcel(Parcel in) {
            return new UserInfoField(in);
        }

        @Override
        public UserInfoField[] newArray(int size) {
            return new UserInfoField[size];
        }
    };
}
