package ApiWorker;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ApiWorker.exception.UserAPIException;
import org.apache.http.util.TextUtils;

import java.io.IOException;



public class ItemTypeAdapterFactory implements TypeAdapterFactory {


    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {

            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            public T read(JsonReader in) throws IOException {

                JsonElement jsonElement = elementAdapter.read(in);
                if (jsonElement.isJsonObject()) {

                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("data") && jsonObject.get("data").isJsonObject()) {

                        JsonObject data = jsonObject.getAsJsonObject("data");
                        if (data.has("error")) {

                            JsonArray errors = data.getAsJsonArray("error");
                            String formattedErrors = formatError(errors);
                            if (!TextUtils.isEmpty(formattedErrors))
                                throw new UserAPIException(formattedErrors);
                        }
                    }
                }

                return delegate.fromJsonTree(jsonElement);
            }
        }.nullSafe();
    }


    private String formatError(JsonArray errorList) {

        StringBuilder sb = new StringBuilder("");

        if (errorList != null && errorList.size() > 0) {

            String msg = null;
            for (int i = 0; i < errorList.size(); i++) {

                msg = errorList.get(i).getAsString();
                if (!TextUtils.isEmpty(msg)) {

                    if (sb.length() > 0)
                        sb.append("\n\n");
                    sb.append(msg);
                }
            }
        }

        return sb.toString();
    }
}
