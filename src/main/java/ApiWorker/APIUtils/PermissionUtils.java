package ApiWorker.APIUtils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

/**
 * Created by artem on 1/15/16.
 */
public class PermissionUtils {


    public static boolean checkIfWESPermissionGranted(Context context) {

        return checkIfPermissionGranted(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static boolean checkIfRPSPermissionGranted(Context context) {

        return checkIfPermissionGranted(context, Manifest.permission.READ_PHONE_STATE);
    }

    public static boolean checkIfPermissionGranted(Context context, String permission) {

        return context != null && ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestWESPermission(FragmentActivity activity) {

        requestPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                GlobalArgs.WES_PERMISSION_REQUEST_CODE);
    }

    public static void requestRPSPermission(FragmentActivity activity) {

        requestPermission(activity, Manifest.permission.READ_PHONE_STATE,
                GlobalArgs.RPS_PERMISSION_REQUEST_CODE);
    }

    public static void requestPermission(FragmentActivity activity, String permission, int requestCode) {

        ActivityCompat.requestPermissions(activity, new String[]{permission},
                requestCode);
    }
}
