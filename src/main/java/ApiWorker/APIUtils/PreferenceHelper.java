package ApiWorker.APIUtils;

import android.content.Context;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import classifieds.yalla.model.users.User;

/**
 * Created by artem on 8/16/15.
 */
public class PreferenceHelper {

    public static final String TAG = PreferenceHelper.class.getSimpleName();

    private static PreferenceHelper mInstance = null;

    private Context mContext;

    private PreferenceHelper(Context context) {

        mContext = context;
    }

    public static void init(Context context) {

        if (mInstance == null)
            mInstance = new PreferenceHelper(context);
    }

    public static PreferenceHelper getInstance() {

        return mInstance;
    }

    public void saveUser(String key, User value) {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString(key, new Gson().toJson(value)).commit();
    }

    public void saveString(String key, String value) {

        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString(key, value).commit();
    }

    public String getString(String key) {

        return PreferenceManager.getDefaultSharedPreferences(mContext).getString(key, null);
    }

    public String getString(int keyStringResId) {

        String key = mContext.getResources().getString(keyStringResId);

        return PreferenceManager.getDefaultSharedPreferences(mContext).getString(key, null);
    }

    public User getUser(String key) {

        return new Gson().fromJson(getString(key), User.class);
    }

    public boolean getBoolean(String key) {

        return PreferenceManager.getDefaultSharedPreferences(mContext).getBoolean(key, false);
    }
}