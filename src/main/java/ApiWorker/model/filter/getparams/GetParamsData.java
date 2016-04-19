package ApiWorker.model.filter.getParams;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by artem on 9/14/15.
 */
public class GetParamsData extends BaseModel {

    private static final String TAG = GetParamsData.class.getSimpleName();

    @SerializedName("phoneMask")
    @Expose
    private String phoneMask;

    @SerializedName("defaultCurrency")
    @Expose
    private String defaultCurrency;

    @SerializedName("currencies")
    @Expose
    private Map<String, String> currencies;
    private List<Currency> parsedCurrencies;

    public String getPhoneMask() {

        return phoneMask;
    }

    List<Currency> getCurrencies() {

        if (parsedCurrencies == null) {

            try {

                parsedCurrencies = parseCurrencies();
            } catch (Throwable th) {

                //MyLogger.e(TAG, "Failed to parsed currencies", th);
            }
        }

        return parsedCurrencies;
    }

    private List<Currency> parseCurrencies() {

        List<Currency> result = null;
        if (currencies != null && currencies.size() > 0) {

            result = new LinkedList<>();
            for (Map.Entry<String, String> entry : currencies.entrySet()) {

                result.add(new Currency(entry.getKey(), entry.getValue()));
            }
        }

        return result;
    }
}
