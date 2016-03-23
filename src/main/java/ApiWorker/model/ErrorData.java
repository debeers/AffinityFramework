package ApiWorker.model;

import android.text.TextUtils;

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
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("");

        for (String msg : errorList) {

            if (!TextUtils.isEmpty(msg)) {

                if (sb.length() > 0)
                    sb.append("\n\n");
                sb.append(msg);
            }
        }
        return sb.toString();
    }
}
