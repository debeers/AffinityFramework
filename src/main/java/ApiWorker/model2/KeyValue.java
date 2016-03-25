package ApiWorker.model2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 3/17/16.
 */
public class KeyValue extends BaseModel {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("value")
    @Expose
    private String value;

    public KeyValue(String id) {

        this.id = id;
    }

    public KeyValue(String id, String value) {

        this.id = id;
        this.value = value;
    }

    public String getId() {

        return id;
    }

    public String getValue() {

        return value;
    }

    public KeyValue() {

    }
}
