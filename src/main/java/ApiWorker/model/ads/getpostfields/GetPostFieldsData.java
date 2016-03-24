package ApiWorker.model.ads.getpostfields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 4/5/15.
 */
public class GetPostFieldsData extends ApiWorker.model2.BaseModel {

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

    public GetPostFieldsData(List<Field> fieldList, List<Param> paramList, List<UserInfoField> userInfoFieldList) {
        this.fieldList = fieldList;
        this.paramList = paramList;
        this.userInfoFieldList = userInfoFieldList;
    }

    public List<UserInfoField> getUserInfoFieldList() {

        return userInfoFieldList;
    }

    public List<Field> getFieldList() {

        return fieldList;
    }

    public List<Param> getParamList() {

        return paramList;
    }

    public int describeContents() {

        return 0;
    }

}
