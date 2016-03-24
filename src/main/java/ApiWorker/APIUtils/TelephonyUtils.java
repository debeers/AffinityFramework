package ApiWorker.APIUtils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import classifieds.yalla.api.APIManager;
import classifieds.yalla.logger.MyLogger;
import classifieds.yalla.model.filter.getparams.GetParamsResponse;

/**
 * Created by artem on 7/26/15.
 */
public class TelephonyUtils {

    private static final String TAG = TelephonyUtils.class.getSimpleName();

    public static boolean isPhoneNumberAvailable(Context context) {

        String phoneNum = getPhoneNumber(context);
        return phoneNum != null && !TextUtils.isEmpty(getPhoneNumber(context).trim());
    }

    public static String getPhoneNumber(Context context) {

        if (context == null)
            return null;

        String phoneNumber = null;
        try {

            if (PermissionUtils.checkIfRPSPermissionGranted(context)) {

                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                if (tm != null)
                    phoneNumber = tm.getLine1Number();
            }
        } catch (Throwable th) {

            MyLogger.e(TAG, "Failed to getPhoneNumber! ", th);
        }

        return phoneNumber;
    }

    public static String getServerPhoneCountryCode() {

        GetParamsResponse response = APIManager.getInstance().getGetParamsResponse();
        if (response != null) {

            String phoneMask = response.getPhoneMask();
            if (!TextUtils.isEmpty(phoneMask)) {
                StringBuilder countryCodeSb = new StringBuilder("");
                for (int i = 0; i < phoneMask.length(); i++) {

                    if (phoneMask.charAt(i) == '#')
                        break;
                    else
                        countryCodeSb.append(phoneMask.charAt(i));
                }
                return countryCodeSb.toString();
            }
        }
        return "";
    }
}
