package ApiWorker.model.users;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

import classifieds.yalla.MyApplication;
import classifieds.yalla.analytics.google.Actions;
import classifieds.yalla.analytics.google.Categories;
import classifieds.yalla.analytics.google.GoogleAnalyticsHelper;
import classifieds.yalla.gcm.GCMManager;
import classifieds.yalla.gcm.UnregisterGCMService;
import classifieds.yalla.location.AppAvailableCountryCodes;
import classifieds.yalla.location.CountryManager;
import classifieds.yalla.logger.MyLogger;
import classifieds.yalla.notification.AppNotificationManager;
import classifieds.yalla.utils.GeneralUtils;
import classifieds.yalla.utils.GlobalArgs;
import classifieds.yalla.utils.PreferenceHelper;

/**
 * Created by artem on 8/16/15.
 */
public class UserManager {

    public static final String TAG = UserManager.class.getSimpleName();

    private static final String SOVDE_CONTENT_URI = "content://az.sovde.contentprovider/users";
    private static final String STENA_CONTENT_URI = "content://kg.stena.contentprovider/users";

    // Fields name
    private static final String CURRENT_USER = "currentUser";

    private static UserManager mInstance = null;

    private User mUser;

    public static UserManager getInstance() {

        if (mInstance == null)
            mInstance = new UserManager();

        return mInstance;
    }

    private UserManager() {

        mUser = PreferenceHelper.getInstance().getUser(CURRENT_USER);
    }

    public long getUserId() {

        return mUser != null ? mUser.getId() : -1;
    }

    public String getUsername() {

        return mUser != null ? mUser.getUserName() : "";
    }

    public void logIn(User user, Context ctx) {

        setCurrentUser(user);
        GCMManager.getInstance().startRegistrationFlow(ctx);
    }

    public void signUp(User user, Context ctx) {

        logIn(user, ctx);
        AppNotificationManager.getInstance().notifyPassword(user);
    }

    public void logOut(Context ctx) {

        MyLogger.d(TAG, "logOut");

        if (mUser == null)
            return;

        if (ctx != null) {

            startUnregisterGCMService(ctx);
            cancelAllNotification(ctx);
        }

        setCurrentUser(null);
    }

    private void startUnregisterGCMService(Context ctx) {

        try {

            Intent intent = new Intent(ctx, UnregisterGCMService.class);
            intent.putExtra(GlobalArgs.USER_ID, getUserId());
            ctx.startService(intent);
        } catch (Throwable th) {

            MyLogger.d(TAG, "Failed to start UnregisterGCMService");
        }
    }

    private void cancelAllNotification(Context ctx) {

        try {

            NotificationManager notificationManager =
                    (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
        } catch (Throwable th) {
            MyLogger.e(TAG, "Failed to cancelAll notifications", th);
        }
    }

    private void setCurrentUser(User user) {

        PreferenceHelper.getInstance().saveUser(CURRENT_USER, user);
        mUser = user;
    }

    public boolean isUserLogged() {

        return mUser != null;
    }

    public boolean tryToLoginWithOldApps(Context ctx) {

        return tryToLoginWithSovde(ctx) || tryToLoginWithStena(ctx);
    }

    private boolean tryToLoginWithStena(Context ctx) {

        try {

            return loginWithStena(ctx);
        } catch (Throwable th) {

            MyLogger.e(TAG, "Failed to execute tryToLoginWithStena!", th);
        }

        return false;
    }

    private boolean loginWithStena(Context ctx) {

        if (!GeneralUtils.isStenaInstalled(ctx))
            return false;

        User user = loadUserByContentURI(ctx, STENA_CONTENT_URI);

        return setForceFromOldApps(user, AppAvailableCountryCodes.KYRGYZSTAN, ctx);
    }

    private boolean tryToLoginWithSovde(Context ctx) {

        try {

            return loginWithSovde(ctx);
        } catch (Throwable th) {

            MyLogger.e(TAG, "Failed to execute tryToLoginWithSovde!", th);
        }

        return false;
    }

    private boolean loginWithSovde(Context ctx) {

        if (!GeneralUtils.isSovdeInstalled(ctx))
            return false;

        User user = loadUserByContentURI(ctx, SOVDE_CONTENT_URI);

        return setForceFromOldApps(user, AppAvailableCountryCodes.AZERBAIJANI, ctx);
    }

    private User loadUserByContentURI(Context ctx, String URI) {

        Cursor cursor = ctx.getContentResolver().query(
                Uri.parse(URI), null, null, null, null);
        return User.fromCursor(cursor);
    }

    private boolean setForceFromOldApps(User user, String countryCode, Context ctx) {

        if (user == null || !user.hasValidId())
            return false;

        logIn(user, ctx);
        CountryManager.getInstance().setCurrentCountry(countryCode, false);
        String languageCode = CountryManager.getInstance().getDefaultCountryLanguageCode(countryCode);
        CountryManager.getInstance().setCurrentLanguage(languageCode);

        GoogleAnalyticsHelper.trackEvent((MyApplication) ctx,
                Categories.REBRANDING, Actions.AUTO_LOGIN);

        return true;
    }
}
