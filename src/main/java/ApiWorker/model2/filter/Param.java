package ApiWorker.model2.filter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;
import ApiWorker.model2.KeyValue;

import java.util.List;


/**
 * Created by artem on 3/17/16.
 */
public class Param extends BaseModel {

    @SerializedName("id")
    @Expose
    protected String id;

    @SerializedName("name")
    @Expose
    protected String name;

    @SerializedName("name_from")
    @Expose
    protected String nameFrom;

    @SerializedName("name_to")
    @Expose
    protected String nameTo;

    @SerializedName("hint")
    @Expose
    protected String hint;

    @SerializedName("type")
    @Expose
    protected String type;

    @SerializedName("is_required")
    @Expose
    protected int isRequired;

    @SerializedName("from_to_range")
    @Expose
    protected int fromToRange;

    @SerializedName("suffix")
    @Expose
    protected String suffix;

    public Param(String id, String name, String nameFrom, String nameTo, String hint, String type, int isRequired, int fromToRange, String suffix, Range range) {
        this.id = id;
        this.name = name;
        this.nameFrom = nameFrom;
        this.nameTo = nameTo;
        this.hint = hint;
        this.type = type;
        this.isRequired = isRequired;
        this.fromToRange = fromToRange;
        this.suffix = suffix;
        this.range = range;
    }

    @SerializedName("range")
    @Expose
    protected Range range;

    public String getId() {

        return id;
    }

    public String getType() {

        return type;
    }

    public String getHint() {

        return hint;
    }

    public String getName() {

        return name;
    }

    public String getNameFrom() {

        return nameFrom;
    }

    public String getNameTo() {

        return nameTo;
    }

    public String getSuffix() {

        return suffix;
    }

    public Range getRange() {

        return range;
    }

    public boolean isFromToRange() {

        return fromToRange == 1;
    }

    public List<KeyValue> getAllRange() {

        return range.getAll();
    }

    public List<KeyValue> getFromRange() {

        return range.getFrom();
    }

    public List<KeyValue> getToRange() {

        return range.getTo();
    }



    public Param() {
    }



}
