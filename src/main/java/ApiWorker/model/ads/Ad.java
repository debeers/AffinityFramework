package ApiWorker.model.ads;


import ApiWorker.APIUtils.FormatUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.AdImages;
import ApiWorker.model.BaseModel;
import ApiWorker.model.Image;

import javax.naming.Context;
import java.io.Serializable;
import java.util.List;



/**
 * Created by artem on 2/12/15.
 */
public class Ad extends BaseModel implements Serializable {

    private int ACCEPTED = 0;
    private int WAITING = 1;
    private int REJECTED = 2;
    private int REMODERATION = 3;
    private int BANNED = 4;
    private int DEACTIVATED = 5;

    public Ad(int ACCEPTED, int WAITING, int REJECTED, int REMODERATION, int BANNED, int DEACTIVATED, long id,
              String title, String desc, String price, String currency, String username, String mobile, int negotiable,
              String city, long views, long categoryId, long locationId, long createTime, long[] userList, long userId,
              AdImages images, String image, boolean freePush, String status, int statusId, int active,
              List<InfoParam> mInfoParamList, boolean isDetail, String shareLink) {

        this.ACCEPTED = ACCEPTED;
        this.WAITING = WAITING;
        this.REJECTED = REJECTED;
        this.REMODERATION = REMODERATION;
        this.BANNED = BANNED;
        this.DEACTIVATED = DEACTIVATED;
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.currency = currency;
        this.username = username;
        this.mobile = mobile;
        this.negotiable = negotiable;
        this.city = city;
        this.views = views;
        this.categoryId = categoryId;
        this.locationId = locationId;
        this.createTime = createTime;
        this.userList = userList;
        this.userId = userId;
        this.images = images;
        this.image = image;
        this.freePush = freePush;
        this.status = status;
        this.statusId = statusId;
        this.active = active;
        this.mInfoParamList = mInfoParamList;
        this.isDetail = isDetail;
        this.shareLink = shareLink;
    }

    @SerializedName("id")
    @Expose
    private long id;

    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String desc;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("is_negotiable")
    @Expose
    private int negotiable;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("views")
    @Expose
    private long views;

    @SerializedName("category_id")
    @Expose
    private long categoryId;

    @SerializedName("location_id")
    @Expose
    private long locationId;

    @SerializedName("create_time")
    @Expose
    private long createTime;

    @SerializedName("users_list")
    @Expose
    private long[] userList;

    @SerializedName("user_id")
    @Expose
    private long userId;

    @SerializedName("images")
    @Expose
    private AdImages images;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("free_push")
    private boolean freePush;

    @SerializedName("status")
    private String status;

    @SerializedName("status_id")
    private int statusId;

    @SerializedName("active")
    private int active;

    @SerializedName("params")
    private List<InfoParam> mInfoParamList;

    private boolean isDetail;

    private String shareLink;

    public Ad() {

    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long[] getUserList() {

        return userList;
    }

    public boolean isCurrentUser(long myUserId) {

        boolean isCurrentUser = false;
        isCurrentUser = userId > 0 && userId == myUserId;

        if (!isCurrentUser) {

            if (userList != null) {

                for (long userId : userList) {

                    if (userId == myUserId) {

                        isCurrentUser = true;
                        break;
                    }
                }
            }
        }

        return isCurrentUser;
    }

    public long getId() {

        return id;
    }

    public String getImage() {

        return image;
    }

    private boolean isActive() {

        return active == 1;
    }

    public void setActive(int active) {

        this.active = active;
    }

    public List<InfoParam> getInfoParamList() {

        return mInfoParamList;
    }

    public boolean isDetail() {

        return isDetail;
    }

    public void setDetail(boolean isDetail) {

        this.isDetail = isDetail;
    }

    public void setShareLink(String share) {

        this.shareLink = share;
    }

    public String getShareLink() {

        return shareLink;
    }

    public boolean isFreePush() {

        return freePush;
    }

    public void setFreePush(boolean freePush) {

        this.freePush = freePush;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public String getCurrency() {

        return currency;
    }

    public void setCurrency(String currency) {

        this.currency = currency;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public long getViews() {

        return views;
    }

    public void setViews(long views) {

        this.views = views;
    }

    public boolean isNegotiable() {

        return negotiable == 1;
    }

    public String getCreateTime() {

        return createTime > 0 ? FormatUtils.getAdDateFormat(createTime) : "";
    }

    public long getCreateTimeInMillis() {

        return createTime;
    }

    public boolean canEdit() {

        return statusId != DEACTIVATED && statusId != BANNED;
    }

    public boolean canFreePush() {

        return isActive() && freePush;
    }

    public boolean canDeactivate() {

        return statusId != DEACTIVATED && statusId != BANNED;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public long getLocationId() {

        return locationId;
    }

    public void setLocationId(long locationId) {

        this.locationId = locationId;
    }

    public long getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(long categoryId) {

        this.categoryId = categoryId;
    }

    public boolean hasOriginalImages() {

        List<Image> images = getOriginalImages();

        return images != null && !images.isEmpty();
    }

    public boolean hashImages() {

        return hasThumbnailImages() || hasOriginalImages();
    }

    public List<Image> getOriginalImages() {

        return images != null ? images.getOriginalImages() : null;
    }

    public boolean hasThumbnailImages() {

        List<Image> images = getThumbnailImages();

        return images != null && !images.isEmpty();
    }

    public List<Image> getThumbnailImages() {

        return images != null ? images.getThumbnailImages() : null;
    }

    public List<Image> getImagesForFullscreenView() {

        return hasOriginalImages() ? getOriginalImages() : getThumbnailImages();
    }

    public int getFirstThumbnailImageWidth() {

//        if (images != null) {
//
//            List<Image> adImageList = images.getThumbnailImages();
//            if (adImageList != null && !adImageList.isEmpty()) {
//
//                Image firstImage = adImageList.get(0);
//                return firstImage.getWidth();
//            }
//        }
        return 0;
    }

    public int getFirstThumbnailHeight() {

//        if (images != null) {
//
//            List<Image> adImageList = images.getThumbnailImages();
//            if (adImageList != null && !adImageList.isEmpty()) {
//
//                Image firstImage = adImageList.get(0);
//                return firstImage.getHeight();
//            }
//        }
        return 0;
    }

    public String getFirstThumbnailImageUrl() {

//        if (images != null) {
//
//            List<Image> adImageList = images.getThumbnailImages();
//            if (adImageList != null && !adImageList.isEmpty()) {
//
//                Image firstImage = adImageList.get(0);
//                return firstImage.getUrl();
//            }
//        }
        return "";
    }

    public String getFormattedPrice(Context context, boolean showNegotiable) {

//        if (isNegotiable())
//            return showNegotiable ? context.getString(R.string.negotiable) : "";
//
//        long parsedPrice;
//        try {
//
//            parsedPrice = Long.parseLong(price);
//        } catch (NumberFormatException nfe) {
//
//            return "";
//        }
//
//        StringBuilder priceSb = new StringBuilder("");
//        if (parsedPrice > 0) {
//
//            priceSb.append(FormatUtils.getDecimalFormattedNumber(parsedPrice));
//            if (!TextUtils.isEmpty(getCurrency())) {
//
//                priceSb.append(" ");
//                priceSb.append(getCurrency().toUpperCase());
//            }
//        }
//
//        return priceSb.toString();
        return null;
    }
}
