package ApiWorker;

/**
 * Created by artem on 1/12/16.
 */
public interface APIMethods {

    String GET_PARAMS = "getParams";
    String GET_LOCATIONS = "getLocations";
    String GET_CATEGORIES = "getCategories";
    String ADD_TOKEN = "addToken";
    String GET_CHATS = "getChats";
    String GET_MESSAGES = "getMessages";
    String ADD_CHAT = "addChat";
    String UPDATE_VIEW_TIME = "updateViewTime";
    String GET_UNREAD_COUNT = "getUnreadCount";
    String SEND_MESSAGE = "sendMessage";
    String GET_AD_BY_ID = "getAdById";
    String GET_AD_URL_BY_ID = "getAdURLById";
    String GET_ADS = "getAds";
    String GET_POST_FIELDS = "getPostFields";
    String POST_AD = "postAd";
    String DEACTIVATE_AD = "deactivateAd";
    String CHECK_USER = "checkUser";
    String RECOVERY_PASS = "recoveryPass";
    String CHANGE_PASS = "changePass";
    String FREE_PUSH = "freePush";
    String SIGN_UP = "signUp";
    String GET_MOBILE_AUTH = "getMobileAuth";
    String UPLOAD_IMAGE = "uploadImage";
    String CATEGORY_PARAMS = "v2/categoryparams";

}
