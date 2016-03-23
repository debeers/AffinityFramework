package ApiWorker.model2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by artem on 2/16/15.
 */
public class BaseModel implements Parcelable {

    public BaseModel() {

    }

    protected BaseModel(Parcel in) {

    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static HashMap<String, RequestBody> toRequestBody(Object body) {

        HashMap<String, RequestBody> map = new HashMap<>();

        Object jsonObject;
        if (body instanceof List)
            jsonObject = body;
        else {

            LinkedList<Object> fieldList = new LinkedList<>();
            fieldList.add(body);
            jsonObject = fieldList;
        }

        Gson gson = new Gson();
        String strJson = gson.toJson(jsonObject);
        RequestBody json = RequestBody.create(MediaType.parse("text/plain"), strJson);

        map.put("fields", json);

        return map;
    }
}
