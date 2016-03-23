package ApiWorker.model2.filter;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;
import ApiWorker.model2.KeyValue;

import java.util.List;


/**
 * Created by artem on 3/17/16.
 */
public class Range extends BaseModel  {

    public Range(List<KeyValue> all, List<KeyValue> from, List<KeyValue> to) {
        this.all = all;
        this.from = from;
        this.to = to;
    }

    @SerializedName("all")
    @Expose
    protected List<KeyValue> all;

    @SerializedName("from")
    @Expose
    protected List<KeyValue> from;

    @SerializedName("to")
    @Expose
    protected List<KeyValue> to;

    public List<KeyValue> getAll() {

        return all;
    }

    public List<KeyValue> getTo() {
        return to;
    }

    public List<KeyValue> getFrom() {

        return from;
    }


    public Range() {
    }

}
