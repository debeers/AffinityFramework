package ApiWorker.model.ads.postAd;


import ApiWorker.model.Image;
import ApiWorker.model.PostField;
import ApiWorker.model.ads.Ad;
import ApiWorker.model.ads.InfoParam;
import ApiWorker.model.ads.getPostFields.BaseField;
import ApiWorker.model.ads.getPostFields.Field;
import ApiWorker.model.ads.getPostFields.Param;
import ApiWorker.model.ads.getPostFields.UserInfoField;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.http.util.TextUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by artem on 4/5/15.
 */
public class PostAdBody  {

    private static final String TAG = PostAdBody.class.getSimpleName();

    private static final int IMAGE_LIST_SIZE = 9;

    public PostAdBody(List<PostField> fieldList, List<PostField> paramList, List<PostField> userInfoList, String[] imageList) {
        this.fieldList = fieldList;
        this.paramList = paramList;
        this.userInfoList = userInfoList;
        this.imageList = imageList;
    }

    @SerializedName("fields")
    @Expose
    private List<PostField> fieldList;

    @SerializedName("params")
    @Expose
    private List<PostField> paramList;

    @SerializedName("user_info")
    @Expose
    private List<PostField> userInfoList;

    private String[] imageList;

    public PostAdBody() {

        imageList = new String[IMAGE_LIST_SIZE];
    }


    public static PostAdBody fromAd(Ad ad) {

        PostAdBody adBody = new PostAdBody();

        adBody.readParams(ad);
        adBody.readFields(ad);
        adBody.readUserInfoFields(ad);
        adBody.readImages(ad);

        return adBody;
    }

    private void readParams(Ad ad) {

        if (ad.getInfoParamList() != null) {

            for (InfoParam param : ad.getInfoParamList()) {

                addParamField(new PostField(param.getParamId(),
                        !TextUtils.isEmpty(param.getValueId()) ? param.getValueId() : param.getValueName()));
            }
        }
    }

    private void readFields(Ad ad) {

        addField(new PostField(PostField.TITLE, ad.getTitle()));
        addField(new PostField(PostField.DESCRIPTION, ad.getDesc()));
        addField(new PostField(PostField.PRICE, ad.getPrice()));
        addField(new PostField(PostField.IS_NEGOTIABLE, ad.isNegotiable() ? "1" : "0"));
        addField(new PostField(PostField.CURRENCY, ad.getCurrency()));
    }

    private void readUserInfoFields(Ad ad) {

        addUserInfoField(new PostField(PostField.USERNAME, ad.getUsername()));
        String adPhoneNum = ad.getMobile();
        if (!TextUtils.isEmpty(adPhoneNum)) {

            addUserInfoField(new PostField(PostField.MOBILE, adPhoneNum));
        }
    }

    private void readImages(Ad ad) {

        if (ad.hasThumbnailImages()) {

            int idx = 0;
            for (Image image : ad.getThumbnailImages()) {

                if (image != null) {

                    imageList[idx] = image.getUrl();
                    idx++;
                }
            }
        }
    }

    public String[] getImageList() {

        return imageList;
    }

    public void setImageList(String[] imageList) {

        this.imageList = imageList;
    }

    public List<PostField> getFieldList() {

        return fieldList;
    }

    public List<PostField> getParamList() {

        return paramList;
    }

    public List<PostField> getUserInfoList() {

        return userInfoList;
    }

    public void clearAllFields() {

        if (fieldList != null)
            fieldList.clear();

        if (paramList != null)
            paramList.clear();

        if (userInfoList != null)
            userInfoList.clear();
    }

    public void addField(PostField postField) {

        if (fieldList == null)
            fieldList = new LinkedList<>();

        fieldList.add(postField);
    }

    public void addUserInfoField(PostField postField) {

        if (userInfoList == null)
            userInfoList = new LinkedList<>();

        userInfoList.add(postField);
    }

    public PostField getPostField(BaseField field) {

        if (field == null || TextUtils.isEmpty(field.getId()))
            return null;

        List<PostField> list = null;

        if (field instanceof UserInfoField) {
            list = userInfoList;
        } else if (field instanceof Param)
            list = paramList;
        else if (field instanceof Field)
            list = fieldList;

        if (list != null) {

            for (PostField item : list) {

                if (item != null) {

                    if (field.getId().equalsIgnoreCase(item.getId()))
                        return item;
                }
            }
        }

        return null;
    }

    public void addParamField(PostField postField) {

        if (paramList == null)
            paramList = new LinkedList<>();

        paramList.add(postField);
    }

    public HashMap<String, RequestBody> toRequestBody() {


        HashMap<String, RequestBody> map = new HashMap<>();

        Object fields = null;

        if (getFieldList() != null) {
            fields = getFieldList();
        }

        Gson gson = new Gson();

        String strJson = gson.toJson(fields);
        RequestBody json = RequestBody.create(MediaType.parse("text/plain"), strJson);

        map.put("fields", json);

        strJson = gson.toJson(getParamList());
        json = RequestBody.create(MediaType.parse("text/plain"), strJson);

        map.put("params", json);

        strJson = gson.toJson(getUserInfoList());
        json = RequestBody.create(MediaType.parse("text/plain"), strJson);

        map.put("user_info", json);

        return map;
    }
}
