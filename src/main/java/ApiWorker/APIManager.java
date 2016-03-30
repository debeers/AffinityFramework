package ApiWorker;

import ApiWorker.APIUtils.ToStringConverterFactory;
import ApiWorker.model.BaseModel;
import ApiWorker.model.PostField;
import ApiWorker.model.ads.deactivatead.DeactivateAdResponse;
import ApiWorker.model.ads.freepush.FreePushResponse;
import ApiWorker.model.ads.getadbyid.GetAdByIdResponse;
import ApiWorker.model.ads.getads.GetAdsResponse;
import ApiWorker.model.ads.getadurl.GetAdURLByIdResponse;
import ApiWorker.model.ads.getpostfields.GetPostFieldsResponse;
import ApiWorker.model.ads.postad.PostAdBody;
import ApiWorker.model.ads.postad.PostAdResponse;
import ApiWorker.model.chats.addchat.AddChatResponse;
import ApiWorker.model.chats.getchats.GetChatsResponse;
import ApiWorker.model.chats.getmessages.GetMessagesResponse;
import ApiWorker.model.chats.getunreadcount.GetUnreadCountResponse;
import ApiWorker.model.chats.sendmessage.SendMessageResponse;
import ApiWorker.model.chats.updateviewtime.UpdateViewTimeResponse;
import ApiWorker.model.filter.AdFilter;
import ApiWorker.model.filter.getcategories.Category;
import ApiWorker.model.filter.getcategories.GetCategoryResponse;
import ApiWorker.model.filter.getlocation.GetLocationResponse;
import ApiWorker.model.filter.getlocation.Location;
import ApiWorker.model.filter.getparams.GetParamsResponse;
import ApiWorker.model.users.changepass.ChangePassBody;
import ApiWorker.model.users.changepass.ChangePassResponse;
import ApiWorker.model.users.checkuser.CheckUserResponse;
import ApiWorker.model.users.getmobileauth.GetMobileAuthResponse;
import ApiWorker.model.users.recoverypass.RecoveryPassResponse;
import ApiWorker.model.users.signup.SignUpResponse;
import ApiWorker.model2.categoryparams.CategoryParamsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.http.util.TextUtils;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class APIManager {

    private static final String TAG = APIManager.class.getSimpleName();

    private static final int ADS_AMOUNT_IN_PREVIEW_CATEGORY_LIST = 9;

    private static final int WRITE_TIMEOUT_IN_SECONDS = 30;
    private static final int READ_TIMEOUT_IN_SECONDS = 30;
    private static final int CONNECT_TIMEOUT_IN_SECONDS = 30;

    private static APIManager mInstance;

    private APIService mAPIService;
    private Retrofit mRetrofit;


    private GetParamsResponse mGetParamsResponse;
    private GetLocationResponse mGetLocationResponse;
    private GetCategoryResponse mGetCategoryResponse;

    private HashMap<Long, GetPostFieldsResponse> mPostFieldsResponseCache;
    private HashMap<Long, CategoryParamsResponse> mCategoryParamsResponseCache;

    //private AppRetrofitUrl mRetrofitEndpoint;

    private void clearCache() {

        clearPostFieldsCache();
        clearCategoryParamsCache();
        clearLocationCache();
        clearCategoryCache();
    }

    private OkHttpClient createHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.readTimeout(WRITE_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.writeTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.connectTimeout(CONNECT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        return builder.build();
    }

    private GsonConverterFactory createGsonConverterFactory() {

        Gson gson = new GsonBuilder().create();
        return GsonConverterFactory.create(gson);
    }

    private Retrofit createRestAdapter() {


        return new Retrofit.Builder()
                .baseUrl("http://api.lalafo.az/ru/api/")
                .addConverterFactory(new ToStringConverterFactory()).addConverterFactory(createGsonConverterFactory())
                .client(createHttpClient())
                .build();
    }

    private APIService createAPIService(Retrofit retrofit) {

        return retrofit.create(APIService.class);
    }

    private APIManager() {
        mRetrofit = createRestAdapter();
        mAPIService = createAPIService(mRetrofit);
    }

    public void invalidateOnCountryChanged() {

        updateEndpoint();

        mGetLocationResponse = null;
        mGetCategoryResponse = null;
        mGetParamsResponse = null;

        clearCache();
    }

    public void invalidateOnLanguageChanged() {

        updateEndpoint();

        mGetLocationResponse = null;
        mGetCategoryResponse = null;

        clearCache();
    }

    private void updateEndpoint() {

//        if (mRetrofitEndpoint != null)
//            mRetrofitEndpoint.setEndpoint(getCurrentAppEndpoint());
    }


    public static void init() {

//        if (mInstance == null)
//            mInstance = new APIManager(app);
    }

    public static APIManager getInstance() {
        if (mInstance == null)
            mInstance = new APIManager();
        return mInstance;
    }

    public void putPostFieldsResponse(long categoryId, GetPostFieldsResponse response) {

        if (mPostFieldsResponseCache == null)
            mPostFieldsResponseCache = new HashMap<>();

        mPostFieldsResponseCache.put(categoryId, response);
    }

    public void putCategoryParamsResponse(long categoryId, CategoryParamsResponse response) {

        if (mCategoryParamsResponseCache == null)
            mCategoryParamsResponseCache = new HashMap<>();

        mCategoryParamsResponseCache.put(categoryId, response);
    }

    public CategoryParamsResponse getCategoryParamsResponse(long categoryId) {

        return mCategoryParamsResponseCache != null ?
                mCategoryParamsResponseCache.get(categoryId) : null;
    }

    private void clearPostFieldsCache() {

        if (mPostFieldsResponseCache != null)
            mPostFieldsResponseCache.clear();
    }

    private void clearCategoryParamsCache() {

        if (mCategoryParamsResponseCache != null)
            mCategoryParamsResponseCache.clear();
    }

    public GetPostFieldsResponse getPostFieldsResponse(long categoryId) {

        return mPostFieldsResponseCache != null ?
                mPostFieldsResponseCache.get(categoryId) : null;
    }

    public Call getLocation() throws IOException {

        Call<GetLocationResponse> call = mAPIService.getLocation();
        return call;
    }

    public Call getPreviewCategoryList() throws IOException {

        Call<GetCategoryResponse> call = mAPIService.getCategories(ADS_AMOUNT_IN_PREVIEW_CATEGORY_LIST, false);
        return call;
    }

    public Call getCategories() throws IOException {

        Call<GetCategoryResponse> call = mAPIService.getCategories(0, true);
        return call;
    }

    public Stack<Location> getLocationParents(long locationId) {

        Location current = getLocation(locationId);
        Stack<Location> stack = new Stack<>();

        while (current != null && current.getId() > 0) {

            stack.push(current);
            current = getLocation(current.getParent());
        }

        return stack;
    }

    private HashMap<Long, Location> mLocations;

    private void putLocation(long id, Location location) {

        if (mLocations == null)
            mLocations = new HashMap<>();

        mLocations.put(id, location);
    }

    private void clearLocationCache() {

        if (mLocations != null)
            mLocations.clear();
    }

    public Location getLocation(long locationId) {

        return mLocations != null ? mLocations.get(locationId) : null;
    }

    public Stack<Category> getCategoryParents(long categoryId) {

        Category current = getCategory(categoryId);
        Stack<Category> stack = new Stack<>();

        while (current != null && current.getId() > 0) {

            stack.push(current);
            current = getCategory(current.getParent());
        }

        return stack;
    }

    public void bfs(Location root) {

        Queue<Location> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Location node = queue.poll();

            putLocation(node.getId(), node);

            for (Location location : node.getChildrenList()) {

                if (location.getChildrenList() != null) {

                    location.setParent(node.getId());
                    queue.add(location);
                }
            }
        }
    }

    private HashMap<Long, Category> mCategories;

    private void putCategory(long id, Category category) {

        if (mCategories == null)
            mCategories = new HashMap<>();

        mCategories.put(id, category);
    }

    private void clearCategoryCache() {

        if (mCategories != null)
            mCategories.clear();
    }

    public Category getCategory(long id) {

        return mCategories != null ? mCategories.get(id) : null;
    }

    public void bfs(Category root) {

        Queue<Category> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Category node = queue.poll();

            putCategory(node.getId(), node);

            for (Category category : node.getChildrenList()) {

                if (category.getChildrenList() != null) {

                    category.setParent(node.getId());
                    queue.add(category);
                }
            }
        }
    }

    public Call freePush(long adId) throws IOException {

        Call<FreePushResponse> call = mAPIService.freePush(adId);
        return call;
    }

    public GetParamsResponse getGetParamsResponse() {

        return mGetParamsResponse;
    }

    public Call getParams() throws IOException {

        Call<GetParamsResponse> call = mAPIService.getParams();
        return call;
    }

    public Call deactivateAd(long adId) throws IOException {

        Call<DeactivateAdResponse> call = mAPIService.deactivateAd(adId);
        return call;
    }

    public Call getAdList(AdFilter adFilter, final int pageNum) throws IOException {

        Call<GetAdsResponse> call = mAPIService.getAds(adFilter.toQueryMap(pageNum));
        return call;
    }

    public Call getPostFields(final long categoryId, final RequestListener listener) throws IOException {

        GetPostFieldsResponse cachedResponse = getPostFieldsResponse(categoryId);
        if (cachedResponse != null) {

            if (listener != null)
                listener.onSuccess(cachedResponse);
            return null;
        }

        Call<GetPostFieldsResponse> call = mAPIService.getPostFields(categoryId);

        return call;
    }

//    public boolean addPushToken(String token) throws IOException {
//
//        List<PostField> postFieldList = new LinkedList<>();
//        postFieldList.add(new PostField(PostField.TOKEN, token));
//        postFieldList.add(new PostField(PostField.PLATFORM, "android"));
//
//        Call<String> call = mAPIService.addPushToken(BaseModel.toRequestBody(postFieldList));
//        Response<AddPushTokenResponse> response = call.execute();
//
//        return isStatusOK(response);
//    }
//
//    public boolean deletePushToken(String token, long userId) throws IOException {
//
//        List<PostField> postFieldList = new LinkedList<>();
//        postFieldList.add(new PostField(PostField.TOKEN, token));
//        postFieldList.add(new PostField(PostField.PLATFORM, "android"));
//        postFieldList.add(new PostField(PostField.DELETE, "1"));
//
//        Call<String> call = mAPIService.deletePushToken(userId, BaseModel.toRequestBody(postFieldList));
//        Response<DeletePushTokenResponse> response = call.execute();
//
//        return isStatusOK(response);
//    }

    public Call sendMessage(long chatId, String msg, String userHash) throws IOException {

        List<PostField> postFieldList = new LinkedList<>();
        postFieldList.add(new PostField(PostField.CHAT_ID, chatId + ""));
        postFieldList.add(new PostField(PostField.MESSAGE, msg));
        postFieldList.add(new PostField(PostField.USER_HASH, userHash));
        Call<SendMessageResponse> call = mAPIService.sendMessage(BaseModel.toRequestBody(postFieldList));

        return call;
    }

    public Call addChat(long adId) throws IOException {

        Call<AddChatResponse> call = mAPIService.addChat(BaseModel.toRequestBody(new PostField(PostField.AD_ID, adId + "")));
        return call;
    }

    public Call updateViewTime(long chatId) throws IOException {

        Call<UpdateViewTimeResponse> call = mAPIService.updateViewTime(BaseModel.toRequestBody(new PostField(PostField.CHAT_ID, chatId + "")));
        return call;
    }

    public Call getUnreadCount() throws IOException {

        Call<GetUnreadCountResponse> call = mAPIService.getUnreadCount();
        return call;
    }

    public Call getChats() throws IOException {

        Call<GetChatsResponse> call = mAPIService.getChats();
        return call;
    }

    public Call getMessages(long chatId) throws IOException {

        Call<GetMessagesResponse> call = mAPIService.getMessages(chatId);
        return call;
    }

    public Call getAdURLById(long id) throws IOException {

        Call<GetAdURLByIdResponse> call = mAPIService.getAdURLById(id);
        return call;
    }

    public Call getAdById(String id) throws IOException {

        Call<GetAdByIdResponse> call = mAPIService.getAdById(id);
        return call;
    }

    public Call changePass(ChangePassBody changePassBody) throws IOException {

        Call<ChangePassResponse> call = mAPIService.changePass(
                BaseModel.toRequestBody(changePassBody.getChangePassFieldList())
        );

        return call;
    }

    public Call recoveryPass(String phoneNumber) throws IOException {

        Call<RecoveryPassResponse> call = mAPIService.recoveryPass(phoneNumber);
        return call;
    }

    public Call checkUser(String mobile) throws IOException {

        Call<CheckUserResponse> call = mAPIService.checkUser(mobile);
        return call;
    }

    public Call signUp(boolean confirmation, boolean autogeneration, String mobile, String email) throws IOException {

        Call<SignUpResponse> call = mAPIService.signUp(confirmation, autogeneration, mobile, email);
        return call;
    }

    public Call getMobileAuth(String phoneNumber, String password, boolean isFastAuthFlow) throws IOException {

        Call<GetMobileAuthResponse> call = mAPIService.getMobileAuth(phoneNumber, password, isFastAuthFlow);
        return call;
    }

    public Call getCategoryParams(final long id) throws IOException {

        // CategoryParamsResponse cachedResponse = getCategoryParamsResponse(id);
        Call<CategoryParamsResponse> call = mAPIService.getCategoryParams(id);

        return call;
    }

    public Call postAd(PostAdBody postAdBody, final String userId) throws IOException {

        Call<PostAdResponse> call;
        if (TextUtils.isEmpty(userId))
            call = mAPIService.postAd(postAdBody.toRequestBody());
        else
            call = mAPIService.postAd(userId, postAdBody.toRequestBody());

        return call;
    }

    private Call getErrorMsg(Throwable error, String method) {

//        String errorDesc = "";
//        if (error instanceof UserAPIException)
//            errorDesc = error.getMessage();
//        else {
//
//            CrashlyticsHelper.trackAPIIssue(error, method);
//
//            if (error instanceof IOException)
//                return mApp.getString(R.string.error_internet_connection);
//        }
//
//        if (TextUtils.isEmpty(errorDesc))
//            errorDesc = mApp.getString(R.string.error_something_happened);
//
//        return errorDesc;
        return null;
    }

//    private String getServerErrorMsg(Response response, String method) {
//
//        String errorDesc = "";
//        try {
//
//            CrashlyticsHelper.trackAPIIssue(response, method);
//        } catch (Throwable th) {
//
//            MyLogger.e(TAG, "Failed to execute getServerErrorMsg ", th);
//        } finally {
//
//            if (TextUtils.isEmpty(errorDesc))
//                errorDesc = mApp.getString(R.string.error_something_happened);
//        }
//
//        return null;
//    }


}
