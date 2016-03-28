package Registry;

import java.util.HashMap;

/**
 * Created by DeBeers on 29.03.2016.
 */
public class Registry {

    public static Object get(String key) {
        return storage.get(key);
    }

    public static void set(String key, Object object){
        storage.put(key, object);
    }

    private static HashMap<String, Object> storage = new HashMap<>();
}
