package ApiWorker.model.ads.postad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DeBeers on 29.03.2016.
 */
public class PostAdData {
//    @SerializedName("id")
//    @Expose
    private String id ="";

    public PostAdData() {
    }
    public PostAdData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}