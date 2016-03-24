package ApiWorker;

import ApiWorker.APIUtils.GlobalArgs;

//import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import ApiWorker.model.*;
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
import ApiWorker.model.push.AddPushTokenResponse;
import ApiWorker.model.push.DeletePushTokenResponse;
import ApiWorker.model.users.UserManager;
import ApiWorker.model.users.changepass.ChangePassBody;
import ApiWorker.model.users.changepass.ChangePassResponse;
import ApiWorker.model.users.checkuser.CheckUserResponse;
import ApiWorker.model.users.getmobileauth.GetMobileAuthResponse;
import ApiWorker.model.users.recoverypass.RecoveryPassResponse;
import ApiWorker.model.users.signup.SignUpResponse;
import ApiWorker.model2.categoryparams.CategoryParamsResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.http.util.TextUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ApiWorker.model.BaseResponse.*;


/**
 * Created by artem on 2/16/15.
 */
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

    private AppRetrofitUrl mRetrofitEndpoint;

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
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);

        Interceptor headersInterceptor = new Interceptor() {

            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request request = chain.request().newBuilder().addHeader(GlobalArgs.USER_ID_HEADER,
                        UserManager.getInstance().getUserId() + "").build();

                return chain.proceed(request);
            }
        };

        builder.addInterceptor(headersInterceptor);
        builder.addInterceptor(loggingInterceptor);
//        builder.addNetworkInterceptor(new StethoInterceptor());

        return builder.build();
    }

    private GsonConverterFactory createGsonConverterFactory() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        return GsonConverterFactory.create(gson);
    }

    private Retrofit createRestAdapter() {


        return new Retrofit.Builder()
                .baseUrl("dfgdfg/fdg")
                .addConverterFactory(createGsonConverterFactory())
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

    public Call getLocation(final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        if (mGetLocationResponse != null) {

            if (listener != null)
                listener.onSuccess(mGetLocationResponse);

            return null;
        }

        Call<GetLocationResponse> call = mAPIService.getLocation();
        call.enqueue(new Callback<GetLocationResponse>() {
            @Override
            public void onResponse(Call<GetLocationResponse> call, Response<GetLocationResponse> serverResponse) {

                if (BaseResponse.isStatusOK(serverResponse)) {

                    bfs(new Location(0, "all", serverResponse.body().getData().getAllLocationList()));

                    mGetLocationResponse = serverResponse.body();

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    mGetLocationResponse = null;
                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_LOCATIONS));
                }
            }

            @Override
            public void onFailure(Call<GetLocationResponse> call, Throwable error) {

                mGetLocationResponse = null;

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_LOCATIONS));
            }
        });

        return call;
    }

    public Call getPreviewCategoryList(final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetCategoryResponse> call = mAPIService.getCategories(ADS_AMOUNT_IN_PREVIEW_CATEGORY_LIST, false);
        call.enqueue(new Callback<GetCategoryResponse>() {

            @Override
            public void onResponse(Call<GetCategoryResponse> call, Response<GetCategoryResponse> serverResponse) {

                if (BaseResponse.isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_CATEGORIES));
                }
            }

            @Override
            public void onFailure(Call<GetCategoryResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_CATEGORIES));
            }
        });

        return call;
    }

    public Call getCategories(final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        if (mGetCategoryResponse != null) {

            if (listener != null)
                listener.onSuccess(mGetCategoryResponse);

            return null;
        }

        Call<GetCategoryResponse> call = mAPIService.getCategories(0, true);
        call.enqueue(new Callback<GetCategoryResponse>() {

            @Override
            public void onResponse(Call<GetCategoryResponse> call, Response<GetCategoryResponse> serverResponse) {

                if (BaseResponse.isStatusOK(serverResponse)) {

                    mGetCategoryResponse = serverResponse.body();

                    bfs(new Category(0, "all", serverResponse.body().getCategoryList()));

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    mGetCategoryResponse = null;

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_CATEGORIES));
                }
            }

            @Override
            public void onFailure(Call<GetCategoryResponse> call, Throwable error) {

                mGetCategoryResponse = null;

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_CATEGORIES));
            }
        });

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

    public Call freePush(final RequestListener listener, long adId) {

        if (listener != null)
            listener.onStartRequest();

        Call<FreePushResponse> call = mAPIService.freePush(adId);
        call.enqueue(new Callback<FreePushResponse>() {

            @Override
            public void onResponse(Call<FreePushResponse> call, Response<FreePushResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.FREE_PUSH));
                }
            }

            @Override
            public void onFailure(Call<FreePushResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.FREE_PUSH));
            }
        });

        return call;
    }

    public GetParamsResponse getGetParamsResponse() {

        return mGetParamsResponse;
    }

    public Call getParams(final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        if (mGetParamsResponse != null) {

            if (listener != null)
                listener.onSuccess(mGetParamsResponse);

            return null;
        }

        Call<GetParamsResponse> call = mAPIService.getParams();
        call.enqueue(new Callback<GetParamsResponse>() {
            @Override
            public void onResponse(Call<GetParamsResponse> call, Response<GetParamsResponse> serverResponse) {

                if (ApiWorker.model2.BaseResponse.isStatusOK(serverResponse)) {

                    mGetParamsResponse = serverResponse.body();

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    mGetParamsResponse = null;

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_PARAMS));
                }
            }

            @Override
            public void onFailure(Call<GetParamsResponse> call, Throwable error) {

                mGetParamsResponse = null;

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_PARAMS));
            }
        });

        return call;
    }

    public Call deactivateAd(final RequestListener listener, long adId) {

        if (listener != null)
            listener.onStartRequest();

        Call<DeactivateAdResponse> call = mAPIService.deactivateAd(adId);
        call.enqueue(new Callback<DeactivateAdResponse>() {

            @Override
            public void onResponse(Call<DeactivateAdResponse> call, Response<DeactivateAdResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.DEACTIVATE_AD));
                }
            }

            @Override
            public void onFailure(Call<DeactivateAdResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.DEACTIVATE_AD));
            }
        });

        return call;
    }

    public Call getAdList(final PullToRefreshRequestListener listener, AdFilter adFilter, final int pageNum) {

        if (listener != null)
            listener.onStartRequest(pageNum);

        Call<GetAdsResponse> call = mAPIService.getAds(adFilter.toQueryMap(pageNum));
        call.enqueue(new Callback<GetAdsResponse>() {

            @Override
            public void onResponse(Call<GetAdsResponse> call, Response<GetAdsResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body(), pageNum);
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_ADS));
                }
            }

            @Override
            public void onFailure(Call<GetAdsResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_ADS));
            }
        });

        return call;
    }

    public Call getPostFields(final long categoryId, final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        GetPostFieldsResponse cachedResponse = getPostFieldsResponse(categoryId);
        if (cachedResponse != null) {

            if (listener != null)
                listener.onSuccess(cachedResponse);
            return null;
        }

        Call<GetPostFieldsResponse> call = mAPIService.getPostFields(categoryId);
        call.enqueue(new Callback<GetPostFieldsResponse>() {

            @Override
            public void onResponse(Call<GetPostFieldsResponse> call, Response<GetPostFieldsResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    putPostFieldsResponse(categoryId, serverResponse.body());

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());

                } else {
                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_POST_FIELDS));
                }
            }

            @Override
            public void onFailure(Call<GetPostFieldsResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_POST_FIELDS));
            }
        });

        return call;
    }

    public boolean addPushToken(String token) throws IOException {

        List<PostField> postFieldList = new LinkedList<>();
        postFieldList.add(new PostField(PostField.TOKEN, token));
        postFieldList.add(new PostField(PostField.PLATFORM, "android"));

        Call<AddPushTokenResponse> call = mAPIService.addPushToken(BaseModel.toRequestBody(postFieldList));
        Response<AddPushTokenResponse> response = call.execute();

        return isStatusOK(response);
    }

    public boolean deletePushToken(String token, long userId) throws IOException {

        List<PostField> postFieldList = new LinkedList<>();
        postFieldList.add(new PostField(PostField.TOKEN, token));
        postFieldList.add(new PostField(PostField.PLATFORM, "android"));
        postFieldList.add(new PostField(PostField.DELETE, "1"));

        Call<DeletePushTokenResponse> call = mAPIService.deletePushToken(userId, BaseModel.toRequestBody(postFieldList));
        Response<DeletePushTokenResponse> response = call.execute();

        return isStatusOK(response);
    }

    public Call sendMessage(final RequestListener listener, long chatId, String msg, String userHash) {

        if (listener != null)
            listener.onStartRequest();

        List<PostField> postFieldList = new LinkedList<>();
        postFieldList.add(new PostField(PostField.CHAT_ID, chatId + ""));
        postFieldList.add(new PostField(PostField.MESSAGE, msg));
        postFieldList.add(new PostField(PostField.USER_HASH, userHash));
        Call<SendMessageResponse> call = mAPIService.sendMessage(BaseModel.toRequestBody(postFieldList));
        call.enqueue(new Callback<SendMessageResponse>() {
            @Override
            public void onResponse(Call<SendMessageResponse> call, Response<SendMessageResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.SEND_MESSAGE));
                }
            }

            @Override
            public void onFailure(Call<SendMessageResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.SEND_MESSAGE));
            }
        });

        return call;
    }

    public Call addChat(final RequestListener listener, long adId) {

        if (listener != null)
            listener.onStartRequest();

        Call<AddChatResponse> call = mAPIService.addChat(BaseModel.toRequestBody(new PostField(PostField.AD_ID, adId + "")));
        call.enqueue(new Callback<AddChatResponse>() {
            @Override
            public void onResponse(Call<AddChatResponse> call, Response<AddChatResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.ADD_CHAT));
                }
            }

            @Override
            public void onFailure(Call<AddChatResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.ADD_CHAT));
            }
        });

        return call;
    }

    public Call updateViewTime(final RequestListener listener, long chatId) {

        if (listener != null)
            listener.onStartRequest();

        Call<UpdateViewTimeResponse> call = mAPIService.updateViewTime(BaseModel.toRequestBody(new PostField(PostField.CHAT_ID, chatId + "")));
        call.enqueue(new Callback<UpdateViewTimeResponse>() {
            @Override
            public void onResponse(Call<UpdateViewTimeResponse> call, Response<UpdateViewTimeResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.UPDATE_VIEW_TIME));
                }
            }

            @Override
            public void onFailure(Call<UpdateViewTimeResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.UPDATE_VIEW_TIME));
            }
        });

        return call;
    }

    public Call getUnreadCount(final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetUnreadCountResponse> call = mAPIService.getUnreadCount();
        call.enqueue(new Callback<GetUnreadCountResponse>() {

            @Override
            public void onResponse(Call<GetUnreadCountResponse> call, Response<GetUnreadCountResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_UNREAD_COUNT));
                }
            }

            @Override
            public void onFailure(Call<GetUnreadCountResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_UNREAD_COUNT));
            }
        });

        return call;
    }

    public Call getChats(final RequestListener listener) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetChatsResponse> call = mAPIService.getChats();
        call.enqueue(new Callback<GetChatsResponse>() {
            @Override
            public void onResponse(Call<GetChatsResponse> call, Response<GetChatsResponse> serverResponse) {
                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_CHATS));
                }
            }

            @Override
            public void onFailure(Call<GetChatsResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_CHATS));
            }
        });

        return call;
    }

    public Call getMessages(final RequestListener listener, long chatId) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetMessagesResponse> call = mAPIService.getMessages(chatId);
        call.enqueue(new Callback<GetMessagesResponse>() {

            @Override
            public void onResponse(Call<GetMessagesResponse> call, Response<GetMessagesResponse> serverResponse) {


                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_MESSAGES));
                }
            }

            @Override
            public void onFailure(Call<GetMessagesResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_MESSAGES));
            }
        });

        return call;
    }

    public Call getAdURLById(final RequestListener listener, long id) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetAdURLByIdResponse> call = mAPIService.getAdURLById(id);
        call.enqueue(new Callback<GetAdURLByIdResponse>() {
            @Override
            public void onResponse(Call<GetAdURLByIdResponse> call, Response<GetAdURLByIdResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_AD_URL_BY_ID));
                }
            }

            @Override
            public void onFailure(Call<GetAdURLByIdResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_AD_URL_BY_ID));
            }
        });

        return call;
    }

    public Call getAdById(final RequestListener listener, long id) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetAdByIdResponse> call = mAPIService.getAdById(id);
        call.enqueue(new Callback<GetAdByIdResponse>() {

            @Override
            public void onResponse(Call<GetAdByIdResponse> call, Response<GetAdByIdResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_AD_BY_ID));
                }
            }

            @Override
            public void onFailure(Call<GetAdByIdResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_AD_BY_ID));
            }
        });

        return call;
    }

    public Call changePass(final RequestListener listener, ChangePassBody changePassBody) {

        if (listener != null)
            listener.onStartRequest();

        Call<ChangePassResponse> call = mAPIService.changePass(BaseModel.toRequestBody(changePassBody.getChangePassFieldList()));
        call.enqueue(new Callback<ChangePassResponse>() {

            @Override
            public void onResponse(Call<ChangePassResponse> call, Response<ChangePassResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.CHANGE_PASS));
                }
            }

            @Override
            public void onFailure(Call<ChangePassResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.CHANGE_PASS));
            }
        });

        return call;
    }

    public Call recoveryPass(final RequestListener listener, String phoneNumber) {

        if (listener != null)
            listener.onStartRequest();

        Call<RecoveryPassResponse> call = mAPIService.recoveryPass(phoneNumber);
        call.enqueue(new Callback<RecoveryPassResponse>() {

            @Override
            public void onResponse(Call<RecoveryPassResponse> call, Response<RecoveryPassResponse> serverResponse) {
                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.RECOVERY_PASS));
                }
            }

            @Override
            public void onFailure(Call<RecoveryPassResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.RECOVERY_PASS));
            }
        });

        return call;
    }

    public Call checkUser(final RequestListener listener, String mobile) {

        if (listener != null)
            listener.onStartRequest();

        Call<CheckUserResponse> call = mAPIService.checkUser(mobile);
        call.enqueue(new Callback<CheckUserResponse>() {
            @Override
            public void onResponse(Call<CheckUserResponse> call, Response<CheckUserResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.CHECK_USER));
                }
            }

            @Override
            public void onFailure(Call<CheckUserResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.CHECK_USER));
            }
        });

        return call;
    }

    public Call signUp(final RequestListener listener, boolean confirmation,
                       boolean autogeneration, String mobile, String email) {

        if (listener != null)
            listener.onStartRequest();


        Call<SignUpResponse> call = mAPIService.signUp(confirmation, autogeneration, mobile, email);
        call.enqueue(new Callback<SignUpResponse>() {

            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.SIGN_UP));
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.SIGN_UP));
            }
        });

        return call;
    }

    public Call getMobileAuth(final RequestListener listener, String phoneNumber, String password, boolean isFastAuthFlow) {

        if (listener != null)
            listener.onStartRequest();

        Call<GetMobileAuthResponse> call = mAPIService.getMobileAuth(phoneNumber, password, isFastAuthFlow);
        call.enqueue(new Callback<GetMobileAuthResponse>() {
            @Override
            public void onResponse(Call<GetMobileAuthResponse> call, Response<GetMobileAuthResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.GET_MOBILE_AUTH));
                }
            }

            @Override
            public void onFailure(Call<GetMobileAuthResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.GET_MOBILE_AUTH));
            }
        });

        return call;
    }

    public Call getCategoryParams(final RequestListener listener, final long id) {

        if (listener != null)
            listener.onStartRequest();


        CategoryParamsResponse cachedResponse = getCategoryParamsResponse(id);
        if (cachedResponse != null) {

            if (listener != null)
                listener.onSuccess(cachedResponse);

            return null;
        }

        Call<CategoryParamsResponse> call = mAPIService.getCategoryParams(id);
        call.enqueue(new Callback<CategoryParamsResponse>() {

            @Override
            public void onResponse(Call<CategoryParamsResponse> call, Response<CategoryParamsResponse> serverResponse) {

                if (isStatusOK(serverResponse)) { //ApiWorker.model2

                    putCategoryParamsResponse(id, serverResponse.body());

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.CATEGORY_PARAMS));
                }
            }

            @Override
            public void onFailure(Call<CategoryParamsResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.CATEGORY_PARAMS));
            }
        });

        return call;
    }

    public Call postAd(final RequestListener listener, PostAdBody postAdBody, final String userId) {

        if (listener != null)
            listener.onStartRequest();

        Call<PostAdResponse> call;
        if (TextUtils.isEmpty(userId))
            call = mAPIService.postAd(postAdBody.toRequestBody());
        else
            call = mAPIService.postAd(userId, postAdBody.toRequestBody());
        call.enqueue(new Callback<PostAdResponse>() {

            @Override
            public void onResponse(Call<PostAdResponse> call, Response<PostAdResponse> serverResponse) {

                if (isStatusOK(serverResponse)) {

                    if (listener != null)
                        listener.onSuccess(serverResponse.body());
                } else {

                    if (listener != null)
                        listener.onError(getServerErrorMsg(serverResponse, APIMethods.POST_AD));
                }
            }

            @Override
            public void onFailure(Call<PostAdResponse> call, Throwable error) {

                if (listener != null)
                    listener.onError(getErrorMsg(error, APIMethods.POST_AD));
            }
        });

        return call;
    }

    private String getErrorMsg(Throwable error, String method) {

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

    private String getServerErrorMsg(Response response, String method) {

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

        return null;
    }
}
