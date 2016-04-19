package ApiWorker.model.ads.uploadImage;

import ApiWorker.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 12/28/15.
 */
public class UploadImageResponse extends BaseResponse {

    @SerializedName("data")
    private UploadImageData data;

    public UploadImageData getData() {

        return data;
    }

    public UploadImageResponse() {

    }
}
