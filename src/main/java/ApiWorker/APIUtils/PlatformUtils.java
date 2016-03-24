package ApiWorker.APIUtils;

import android.os.Build;

/**
 * Created by artem on 9/13/15.
 */
public class PlatformUtils {

    public static final boolean HAS_ELEVATION = android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

    public static final boolean KITKAT_OR_NEWER = android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

}
