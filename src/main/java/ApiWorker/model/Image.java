package ApiWorker.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.http.util.TextUtils;

/**
 * Created by artem on 8/19/15.
 */
public class Image extends BaseModel   {

    @SerializedName("new_url")
    @Expose
    private String url;

    @SerializedName("new_size")
    @Expose
    private String size;

    @SerializedName("image_id")
    @Expose
    private String id;

    public Image() {

    }

    public Image(String url, String size) {

        this.url = url;
        this.size = size;
    }


    public String getUrl() {

        return url;
    }

    public String getSize() {

        return size;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getId() {

        return id;
    }

    public int getWidth() {

        if (!TextUtils.isEmpty(size)) {

            String[] sizeArray = size.split("x");
            if (sizeArray != null && sizeArray.length == 2) {

                return Integer.valueOf(sizeArray[0]);
            }
        }
        return 0;
    }


    public int getHeight() {

        if (!TextUtils.isEmpty(size)) {

            String[] sizeArray = size.split("x");
            if (sizeArray != null && sizeArray.length == 2) {

                return Integer.valueOf(sizeArray[1]);
            }
        }
        return 0;
    }
}
