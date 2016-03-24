package ApiWorker.model.ads.getpostfields;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import classifieds.yalla.model.BaseModel;

/**
 * Created by artem on 4/5/15.
 */
public class GetPostFieldsData extends BaseModel implements Parcelable {

    @SerializedName("fields")
    @Expose
    private List<Field> fieldList;

    @SerializedName("params")
    @Expose
    private List<Param> paramList;

    @SerializedName("user_info")
    @Expose
    private List<UserInfoField> userInfoFieldList;

    public GetPostFieldsData() {

    }

    protected GetPostFieldsData(Parcel in) {

        fieldList = in.createTypedArrayList(Field.CREATOR);
        paramList = in.createTypedArrayList(Param.CREATOR);
        userInfoFieldList = in.createTypedArrayList(UserInfoField.CREATOR);
    }

    public static final Creator<GetPostFieldsData> CREATOR = new Creator<GetPostFieldsData>() {

        @Override
        public GetPostFieldsData createFromParcel(Parcel in) {

            return new GetPostFieldsData(in);
        }

        @Override
        public GetPostFieldsData[] newArray(int size) {

            return new GetPostFieldsData[size];
        }
    };

    public List<UserInfoField> getUserInfoFieldList() {

        return userInfoFieldList;
    }

    public List<Field> getFieldList() {

        return fieldList;
    }

    public List<Param> getParamList() {

        return paramList;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeTypedList(fieldList);
        dest.writeTypedList(paramList);
        dest.writeTypedList(userInfoFieldList);
    }
}
