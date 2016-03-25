package ApiWorker.APIUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by artem on 9/17/15.
 */
public class FormatUtils {

    private static final SimpleDateFormat AD_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
    private static final SimpleDateFormat MESSAGE_DATE_FORMAT = new SimpleDateFormat("HH:mm dd.MM", Locale.getDefault());
    private static final Date DATE = new Date();

    private static DecimalFormat DECIMAL_FORMAT;
    private static DecimalFormatSymbols DECIMAL_FORMAT_SYMBOLS;

    static {

        DECIMAL_FORMAT = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DECIMAL_FORMAT_SYMBOLS = DECIMAL_FORMAT.getDecimalFormatSymbols();
        DECIMAL_FORMAT_SYMBOLS.setGroupingSeparator(' ');
        DECIMAL_FORMAT.setDecimalFormatSymbols(DECIMAL_FORMAT_SYMBOLS);
    }

    public static final String getAdDateFormat(long timeInMilliseconds) {

        DATE.setTime(1000 * timeInMilliseconds);
        return AD_DATE_FORMAT.format(DATE);
    }

    public static final String getMessageDateFormat(long timeInMilliseconds) {

        DATE.setTime(1000 * timeInMilliseconds);
        return MESSAGE_DATE_FORMAT.format(DATE);
    }


    public static String getDecimalFormattedNumber(long number) {

        return DECIMAL_FORMAT.format(number);
    }

//    public final static boolean isValidEmail(CharSequence target) {
//
//        if (target == null) {
//
//            return false;
//        } else {
//
//            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
//        }
//    }
}
