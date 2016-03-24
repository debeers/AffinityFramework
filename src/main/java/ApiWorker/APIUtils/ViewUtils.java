package ApiWorker.APIUtils;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;

/**
 * Created by artem on 9/15/15.
 */
public class ViewUtils {

    public static long getLongValue(EditText editText) {

        return editText == null || TextUtils.isEmpty(editText.getText()) ?
                0 : Long.parseLong(editText.getText().toString());
    }

    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp) {
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}