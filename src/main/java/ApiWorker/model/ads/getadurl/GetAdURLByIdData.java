package ApiWorker.model.ads.getAdUrl;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;


/**
 * Created by artem on 9/24/15.
 */
public class GetAdURLByIdData extends BaseModel  {

    public GetAdURLByIdData(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("url")
    @Expose
    private String url;



}
