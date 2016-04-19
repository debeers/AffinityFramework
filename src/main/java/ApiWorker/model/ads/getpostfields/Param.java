package ApiWorker.model.ads.getPostFields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 4/5/15.
 */
public class Param extends BaseField  {

    public Param(long typeId) {
        this.typeId = typeId;
    }

    @SerializedName("type_id")
    @Expose
    private long typeId;

    public Param() {

    }
}
