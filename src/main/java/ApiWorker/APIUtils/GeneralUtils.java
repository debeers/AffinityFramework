package ApiWorker.APIUtils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.List;

import classifieds.yalla.api.APIManager;
import classifieds.yalla.model.filter.getparams.GetParamsResponse;

/**
 * Created by artem on 9/24/15.
 */
public class GeneralUtils {

    public static final String SOVDE_PACKAGE = "az.sovde";
    public static final String STENA_PACKAGE = "kg.stena";

    public static String MD5(String md5) {

        try {

            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {

                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }

        return null;
    }

    public static boolean checkPlayServices(Context ctx) {

        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(ctx);
        if (resultCode != ConnectionResult.SUCCESS) {

            return false;
        }
        return true;
    }

    public static boolean isPackageExisted(Context ctx, String targetPackage) {

        List<ApplicationInfo> packages;
        PackageManager pm;

        pm = ctx.getPackageManager();
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {

            if (packageInfo.packageName.equals(targetPackage))

                return true;
        }
        return false;
    }

    public static boolean isStenaInstalled(Context ctx) {

        return isPackageExisted(ctx, STENA_PACKAGE);
    }

    public static boolean isSovdeInstalled(Context ctx) {

        return isPackageExisted(ctx, SOVDE_PACKAGE);
    }

    public static void setPhoneNumHintAndFilter(EditText phoneNumEditText, boolean setLengthFilter) {

        if (phoneNumEditText != null) {

            GetParamsResponse response = APIManager.getInstance().getGetParamsResponse();
            if (response != null) {

                String phoneMask = response.getPhoneMask();
                if (!TextUtils.isEmpty(phoneMask)) {

//                    phoneNumEditText.setHint(phoneMask);
                    if (setLengthFilter)
                        phoneNumEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(phoneMask.length())});
                    phoneNumEditText.setText(TelephonyUtils.getServerPhoneCountryCode());
//                    phoneNumEditText.setSelection(phoneNumEditText.getText().length());
                    phoneNumEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                        @Override
                        public void onFocusChange(View view, boolean hasFocus) {

                            if (hasFocus)
                                ((EditText) view).setSelection(((EditText) view).getText().length());
                        }
                    });
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                phoneNumEditText.setTextDirection(View.TEXT_DIRECTION_LTR);
            }

            phoneNumEditText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        }
    }
}
