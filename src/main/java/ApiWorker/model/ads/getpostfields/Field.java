package ApiWorker.model.ads.getpostfields;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by artem on 4/5/15.
 */
public class Field extends BaseField implements Parcelable {

    public Field() {

    }

    protected Field(Parcel in) {
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

    public static final Creator<Field> CREATOR = new Creator<Field>() {

        @Override
        public Field createFromParcel(Parcel in) {
            return new Field(in);
        }

        @Override
        public Field[] newArray(int size) {
            return new Field[size];
        }
    };
}
