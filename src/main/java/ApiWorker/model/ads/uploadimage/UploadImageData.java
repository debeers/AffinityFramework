package ApiWorker.model.ads.uploadimage;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.SerializedName;


/**
 * Created by artem on 12/28/15.
 */
public class UploadImageData extends BaseModel {

    @SerializedName("fileName")
    private String fileName;

    @SerializedName("id")
    private String id;

    @SerializedName("removeKey")
    private String removeKey;

    public String getId() {

        return id;
    }

    public UploadImageData(String fileName, String id, String removeKey) {
        this.fileName = fileName;
        this.id = id;
        this.removeKey = removeKey;
    }
}
