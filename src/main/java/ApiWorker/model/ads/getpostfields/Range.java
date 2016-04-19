package ApiWorker.model.ads.getPostFields;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;

/**
 * Created by artem on 4/5/15.
 */
public class Range extends BaseModel {

    public Range(String id, String alias, String value) {
        this.id = id;
        this.alias = alias;
        this.value = value;
    }

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("alias")
    @Expose
    private String alias;

    @SerializedName("value")
    @Expose
    private String value;

    public Range() {

    }

    public Range(String id) {

        this.id = id;
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

    public String getAlias() {

        return alias;
    }

    public void setAlias(String alias) {

        this.alias = alias;
    }

    @Override
    public int hashCode() {

        int result = 7;
        result = 31 * result + id.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Range))
            return false;

        if (this == o)
            return true;

        return this.id.equalsIgnoreCase(((Range) o).getId());
    }
}
