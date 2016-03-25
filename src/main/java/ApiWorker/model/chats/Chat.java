package ApiWorker.model.chats;

import ApiWorker.model.ads.Ad;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 8/17/15.
 */
public class Chat extends BaseChat {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("user_from")
    @Expose
    private long userFrom;

    @SerializedName("ad_id")
    @Expose
    private long adId;

    @SerializedName("user_to")
    @Expose
    private long userTo;

    @SerializedName("last_message_id")
    @Expose
    private long lastMessageId;

    @SerializedName("date_create")
    @Expose
    private long dateCreate;

    @SerializedName("user_from_lastview")
    @Expose
    private long userFromLastView;

    @SerializedName("user_to_lastview")
    @Expose
    private long userToLastView;

    @SerializedName("user_from_deleted")
    @Expose
    private long userFromDeleted;

    @SerializedName("user_to_deleted")
    @Expose
    private long userToDeleted;

    @SerializedName("members")
    @Expose
    private List<Member> memberList;

    @SerializedName("last_message")
    @Expose
    private Message lastMessage;

    @SerializedName("unread_count")
    @Expose
    private long unreadCount;

    @SerializedName("ad")
    @Expose
    private Ad ad;

    @SerializedName("answer")
    @Expose
    private boolean answer;


    public Chat(String title, long id, long userFrom,
                long adId, long userTo, long lastMessageId,
                long dateCreate, long userFromLastView, long userToLastView,
                long userFromDeleted, long userToDeleted, List<Member> memberList,
                Message lastMessage, long unreadCount, Ad ad, boolean answer) {

        super(title);
        this.id = id;
        this.userFrom = userFrom;
        this.adId = adId;
        this.userTo = userTo;
        this.lastMessageId = lastMessageId;
        this.dateCreate = dateCreate;
        this.userFromLastView = userFromLastView;
        this.userToLastView = userToLastView;
        this.userFromDeleted = userFromDeleted;
        this.userToDeleted = userToDeleted;
        this.memberList = memberList;
        this.lastMessage = lastMessage;
        this.unreadCount = unreadCount;
        this.ad = ad;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(long userFrom) {
        this.userFrom = userFrom;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public long getUserTo() {
        return userTo;
    }

    public void setUserTo(long userTo) {
        this.userTo = userTo;
    }

    public long getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(long lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public long getUserFromLastView() {
        return userFromLastView;
    }

    public void setUserFromLastView(long userFromLastView) {
        this.userFromLastView = userFromLastView;
    }

    public long getUserToLastView() {
        return userToLastView;
    }

    public void setUserToLastView(long userToLastView) {
        this.userToLastView = userToLastView;
    }

    public long getUserFromDeleted() {
        return userFromDeleted;
    }

    public void setUserFromDeleted(long userFromDeleted) {
        this.userFromDeleted = userFromDeleted;
    }

    public long getUserToDeleted() {
        return userToDeleted;
    }

    public void setUserToDeleted(long userToDeleted) {
        this.userToDeleted = userToDeleted;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }

    public long getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(long unreadCount) {
        this.unreadCount = unreadCount;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String getTitle() {

        if (ad != null)
            return ad.getTitle();

        return null;
    }
}
