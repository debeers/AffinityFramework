package ApiWorker.model;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public class BaseModel  {

    public BaseModel() {

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
