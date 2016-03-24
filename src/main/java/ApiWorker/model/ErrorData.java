package ApiWorker.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 8/30/15.
 */
public class ErrorData {

    @SerializedName("error")
    @Expose
    List<String> errorList;

    public ErrorData() {

    }
}
