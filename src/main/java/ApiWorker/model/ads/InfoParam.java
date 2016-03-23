package ApiWorker.model.ads;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;


/**
 * Created by artem on 9/23/15.
 */
public class InfoParam extends BaseModel {

    public InfoParam(String paramName, String valueName, String paramId, String valueId) {
        this.paramName = paramName;
        this.valueName = valueName;
        this.paramId = paramId;
        this.valueId = valueId;
    }

    @SerializedName("param_name")
    @Expose
    private String paramName;

    @SerializedName("value_name")
    @Expose
    private String valueName;


    @SerializedName("param_id")
    @Expose
    private String paramId;

    @SerializedName("value_id")
    @Expose
    private String valueId;

    public String getParamName() {

        return paramName;
    }

    public String getValueName() {

        return valueName;
    }

    public String getParamId() {

        return paramId;
    }

    public String getValueId() {

        return valueId;
    }

}

