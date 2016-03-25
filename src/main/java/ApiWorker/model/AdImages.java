package ApiWorker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 2/12/15.
 */
public class AdImages extends BaseModel {

    @SerializedName("original")
    @Expose
    private List<Image> thumbnailImages;

    @SerializedName("fullsize")
    @Expose
    private List<Image> originalImages;

    public AdImages() {

    }

    public AdImages(List<Image> thumbnailImages, List<Image> originalImages) {
        this.thumbnailImages = thumbnailImages;
        this.originalImages = originalImages;
    }

    public List<Image> getThumbnailImages() {

        return thumbnailImages;
    }

    public List<Image> getOriginalImages() {

        return originalImages;
    }
}