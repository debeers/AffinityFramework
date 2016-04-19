package ApiWorker.model.ads.getPostFields;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;

import java.util.List;

/**
 * Created by artem on 4/5/15.
 */
public class BaseField extends BaseModel {

    public static final String TEXTAREA_TYPE = "textarea";
    public static final String INT_TYPE = "int";
    public static final String RADIO_TYPE = "radio";
    public static final String TEXT_TYPE = "text";
    public static final String PHONE_TYPE = "phone";
    public static final String EMAIL_TYPE = "email";
    public static final String SELECT_TYPE = "select";
    public static final String CHECKBOX_TYPE = "checkbox";

    public BaseField(String id, String name, String hint, String type, int isRequired, String suffix, List<Range> rangeList) {
        this.id = id;
        this.name = name;
        this.hint = hint;
        this.type = type;
        this.isRequired = isRequired;
        this.suffix = suffix;
        this.rangeList = rangeList;
    }

    @SerializedName("id")
    @Expose
    protected String id;

    @SerializedName("name")
    @Expose
    protected String name;

    @SerializedName("hint")
    @Expose
    protected String hint;

    @SerializedName("type")
    @Expose
    protected String type;

    @SerializedName("is_required")
    @Expose
    protected int isRequired;

    @SerializedName("suffix")
    @Expose
    protected String suffix;

    @SerializedName("range")
    @Expose
    protected List<Range> rangeList;

    public BaseField() {

    }

    public String getHint() {

        return hint;
    }

    public void setHint(String hint) {

        this.hint = hint;
    }

    public String getSuffix() {

        return suffix;
    }

    public void setSuffix(String suffix) {

        this.suffix = suffix;
    }

    public int isRequired() {

        return isRequired;
    }

    public void setRequired(int isRequired) {

        this.isRequired = isRequired;
    }

    public static String getTextareaType() {

        return TEXTAREA_TYPE;
    }

    public static String getIntType() {

        return INT_TYPE;
    }

    public static String getRadioType() {

        return RADIO_TYPE;
    }

    public static String getTextType() {

        return TEXT_TYPE;
    }

    public static String getSelectType() {

        return SELECT_TYPE;
    }

    public static String getCheckboxType() {

        return CHECKBOX_TYPE;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Range> getRangeList() {

        return rangeList;
    }

    public void setRangeList(List<Range> rangeList) {

        this.rangeList = rangeList;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }
}
