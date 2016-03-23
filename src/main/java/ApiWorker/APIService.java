package ApiWorker;

import java.util.Map;

import ApiWorker.APIUtils.GlobalArgs;
import ApiWorker.model.ads.deactivatead.DeactivateAdResponse;
import ApiWorker.model.ads.freepush.FreePushResponse;
import ApiWorker.model.ads.getadbyid.GetAdByIdResponse;
import ApiWorker.model.ads.getads.GetAdsResponse;
import ApiWorker.model.ads.getadurl.GetAdURLByIdResponse;
import ApiWorker.model.ads.getpostfields.GetPostFieldsResponse;
import ApiWorker.model.ads.postad.PostAdResponse;
import ApiWorker.model.chats.addchat.AddChatResponse;
import ApiWorker.model.chats.getchats.GetChatsResponse;
import ApiWorker.model.chats.getmessages.GetMessagesResponse;
import ApiWorker.model.chats.getunreadcount.GetUnreadCountResponse;
import ApiWorker.model.chats.sendmessage.SendMessageResponse;
import ApiWorker.model.chats.updateviewtime.UpdateViewTimeResponse;
import ApiWorker.model.filter.getcategories.GetCategoryResponse;
import ApiWorker.model.filter.getlocation.GetLocationResponse;
import ApiWorker.model.filter.getparams.GetParamsResponse;
import ApiWorker.model.push.AddPushTokenResponse;
import ApiWorker.model.push.DeletePushTokenResponse;
import ApiWorker.model.users.changepass.ChangePassResponse;
import ApiWorker.model.users.checkuser.CheckUserResponse;
import ApiWorker.model.users.getmobileauth.GetMobileAuthResponse;
import ApiWorker.model.users.recoverypass.RecoveryPassResponse;
import ApiWorker.model.users.signup.SignUpResponse;
import ApiWorker.model2.categoryparams.CategoryParamsResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by artem on 2/16/15.
 */
public interface APIService {

    @GET(APIMethods.GET_PARAMS)
    Call<GetParamsResponse> getParams();

    @GET(APIMethods.GET_LOCATIONS)
    Call<GetLocationResponse> getLocation();

    @GET(APIMethods.GET_CATEGORIES)
    Call<GetCategoryResponse> getCategories(@Query("ads") long adsNum, @Query("children") boolean hasChildren);

    @Multipart
    @POST(APIMethods.ADD_TOKEN)
    Call<AddPushTokenResponse> addPushToken(@PartMap() Map<String, RequestBody> map);

    @Multipart
    @POST(APIMethods.ADD_TOKEN)
    Call<DeletePushTokenResponse> deletePushToken(@Header(GlobalArgs.USER_ID_HEADER) long userId, @PartMap() Map<String, RequestBody> map);

    @GET(APIMethods.GET_CHATS)
    Call<GetChatsResponse> getChats();

    @GET(APIMethods.GET_MESSAGES)
    Call<GetMessagesResponse> getMessages(@Query("chat_id") long chatId);

    @Multipart
    @POST(APIMethods.ADD_CHAT)
    Call<AddChatResponse> addChat(@PartMap() Map<String, RequestBody> map);

    @Multipart
    @POST(APIMethods.UPDATE_VIEW_TIME)
    Call<UpdateViewTimeResponse> updateViewTime(@PartMap() Map<String, RequestBody> map);

    @GET(APIMethods.GET_UNREAD_COUNT)
    Call<GetUnreadCountResponse> getUnreadCount();

    @Multipart
    @POST(APIMethods.SEND_MESSAGE)
    Call<SendMessageResponse> sendMessage(@PartMap() Map<String, RequestBody> map);

    @GET(APIMethods.GET_AD_BY_ID)
    Call<GetAdByIdResponse> getAdById(@Query("id") long id);

    @GET(APIMethods.GET_AD_URL_BY_ID)
    Call<GetAdURLByIdResponse> getAdURLById(@Query("id") long id);

    @GET(APIMethods.GET_ADS)
    Call<GetAdsResponse> getAds(@QueryMap Map<String, String> map);

    @GET(APIMethods.GET_POST_FIELDS)
    Call<GetPostFieldsResponse> getPostFields(@Query("category") long category);

    @GET(APIMethods.CATEGORY_PARAMS + "/" + "{id}")
    Call<CategoryParamsResponse> getCategoryParams(@Path("id") long id);

    @Multipart
    @POST(APIMethods.POST_AD)
    Call<PostAdResponse> postAd(@PartMap() Map<String, RequestBody> map);

    @Multipart
    @POST(APIMethods.POST_AD)
    Call<PostAdResponse> postAd(@Header(GlobalArgs.USER_ID_HEADER) String userId, @PartMap() Map<String, RequestBody> map);

    @GET(APIMethods.DEACTIVATE_AD)
    Call<DeactivateAdResponse> deactivateAd(@Query("ad_id") long adId);

    @GET(APIMethods.CHECK_USER)
    Call<CheckUserResponse> checkUser(@Query(value = "mobile", encoded = false) String mobile);

    @GET(APIMethods.RECOVERY_PASS)
    Call<RecoveryPassResponse> recoveryPass(@Query(value = "mobile", encoded = false) String phoneNumber);

    @Multipart
    @POST(APIMethods.CHANGE_PASS)
    Call<ChangePassResponse> changePass(@PartMap() Map<String, RequestBody> map);

    @GET(APIMethods.FREE_PUSH)
    Call<FreePushResponse> freePush(@Query("ad_id") long adId);

    @GET(APIMethods.SIGN_UP)
    Call<SignUpResponse> signUp(@Query("confirmation") boolean confirmation, @Query("autogeneration") boolean autogeneration,
                                @Query(value = "mobile", encoded = false) String mobile, @Query("email") String email);

    @GET(APIMethods.GET_MOBILE_AUTH)
    Call<GetMobileAuthResponse> getMobileAuth(@Query(value = "mobile", encoded = false) String mobile, @Query("password") String password,
                                              @Query("sim_card_number") boolean isFastAuthFlow);
}
