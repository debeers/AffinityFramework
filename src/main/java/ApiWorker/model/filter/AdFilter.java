package ApiWorker.model.filter;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import ApiWorker.model.BaseModel;
import ApiWorker.model.filter.getparams.Currency;
import ApiWorker.model2.KeyValue;
import org.apache.http.util.TextUtils;


/**
 * Created by artem on 8/27/15.
 */
public class AdFilter extends BaseModel {

    public static final int LIMIT_DEFAULT_VALUE = 100;

    private static final boolean IS_PHOTO_FIRST_DEFAULT_VALUE = true;
    private static final boolean WITH_PHOTO_DEFAULT_VALUE = true;

    private static final String ALL_AD_TYPE_VALUE = "all";
    private static final String PRIVATE_AD_TYPE_VALUE = "private";
    private static final String BUSINESS_AD_TYPE_VALUE = "business";

    public AdFilter(long categoryId, long locationId, long userId, long since, long before, long priceFrom, long priceTo, int adType, long limit, String query, String username, boolean withPhoto, boolean isPhotoFirst, String filterTitle, boolean isLinearListType, Currency currency, List<KeyValue> params) {
        this.categoryId = categoryId;
        this.locationId = locationId;
        this.userId = userId;
        this.since = since;
        this.before = before;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.adType = adType;
        this.limit = limit;
        this.query = query;
        this.username = username;
        this.withPhoto = withPhoto;
        this.isPhotoFirst = isPhotoFirst;
        this.filterTitle = filterTitle;
        this.isLinearListType = isLinearListType;
        this.currency = currency;
        this.params = params;
    }

    private long categoryId = 0;
    private long locationId = 0;
    private long userId = -1;
    private long since = -1;
    private long before = -1;
    private long priceFrom = -1;
    private long priceTo = -1;
    private int adType = -1;
    private long limit = LIMIT_DEFAULT_VALUE;
    private String query = "";
    private String username;
    private boolean withPhoto = WITH_PHOTO_DEFAULT_VALUE;
    private boolean isPhotoFirst = IS_PHOTO_FIRST_DEFAULT_VALUE;
    private String filterTitle;
    private boolean isLinearListType;
    private Currency currency;

    private List<KeyValue> params;




    public long getLimit() {

        return limit;
    }

    public void setLinearListType(boolean isLinearListType) {
        this.isLinearListType = isLinearListType;
    }

    public boolean isLinearListType() {

        return isLinearListType;
    }

    public long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(long categoryId) {

        this.categoryId = categoryId;
    }

    public void setLocationId(long locationId) {

        this.locationId = locationId;
    }

    public long getLocationId() {

        return locationId;
    }

    public void setBefore(long before) {

        this.before = before;
    }

    public String getFilterTitle() {

        return filterTitle;
    }

    public void setFilterTitle(String filterTitle) {

        this.filterTitle = filterTitle;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public long getUserId() {

        return userId;
    }

    public void setQuery(String query) {

        this.query = query;
    }

    public String getQuery() {

        return query;
    }

    public void setCurrency(Currency currency) {

        this.currency = currency;
    }

    public Currency getCurrency() {

        return currency;
    }

    public void setAdType(int adType) {

        this.adType = adType;
    }

    public int getAdType() {

        return adType;
    }

    public void setPriceFrom(long priceFrom) {

        this.priceFrom = priceFrom;
    }

    public long getPriceFrom() {

        return priceFrom;
    }

    public void setPriceTo(long priceTo) {

        this.priceTo = priceTo;
    }

    public long getPriceTo() {

        return priceTo;
    }

    public List<KeyValue> getParams() {

        if (params == null)
            params = new ArrayList<>();

        return params;
    }

    public AdFilter() {

    }

    public HashMap<String, String> toQueryMap(int pageNum) {

        HashMap<String, String> queryMap = new HashMap<>();

        queryMap.put("offset", (pageNum - 1) * LIMIT_DEFAULT_VALUE + "");
        queryMap.put("limit", limit + "");
        if (!TextUtils.isEmpty(query))
            queryMap.put("q", query);
        if (userId > 0)
            queryMap.put("user_id", userId + "");
        if (categoryId > 0)
            queryMap.put("category", categoryId + "");
        if (locationId > 0)
            queryMap.put("location", locationId + "");
        if (!withPhoto)
            queryMap.put("with_photo", withPhoto + "");
        if (isPhotoFirst)
            queryMap.put("photo_first", isPhotoFirst + "");
        if (adType == 2)
            queryMap.put("type", PRIVATE_AD_TYPE_VALUE);
        else if (adType == 3)
            queryMap.put("type", BUSINESS_AD_TYPE_VALUE);
        if (!TextUtils.isEmpty(username))
            queryMap.put("username", username);
        if (priceFrom > 0)
            queryMap.put("price_from", priceFrom + "");
        if (priceTo > 0)
            queryMap.put("price_to", priceTo + "");
        if (since != -1)
            queryMap.put("since", since + "");
        if (before != -1)
            queryMap.put("before", before + "");
        if (currency != null && !TextUtils.isEmpty(currency.getKey()))
            queryMap.put("currency", currency.getKey());

        if (params != null) {

            for (KeyValue item : params) {

                queryMap.put("params[" + item.getId() + "]", item.getValue());
            }
        }

        return queryMap;
    }
}
