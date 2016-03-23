package ApiWorker.model.chats;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ApiWorker.model.ads.Ad;

/**
 * Created by artem on 8/17/15.
 */
public class Chat extends BaseChat implements Parcelable {

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


    protected Chat(Parcel in) {
        super(in);
        id = in.readLong();
        userFrom = in.readLong();
        adId = in.readLong();
        userTo = in.readLong();
        lastMessageId = in.readLong();
        dateCreate = in.readLong();
        userFromLastView = in.readLong();
        userToLastView = in.readLong();
        userFromDeleted = in.readLong();
        userToDeleted = in.readLong();
        memberList = in.createTypedArrayList(Member.CREATOR);
        lastMessage = in.readParcelable(Message.class.getClassLoader());
        unreadCount = in.readLong();
        ad = in.readParcelable(Ad.class.getClassLoader());
        answer = in.readInt() == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(id);
        dest.writeLong(userFrom);
        dest.writeLong(adId);
        dest.writeLong(userTo);
        dest.writeLong(lastMessageId);
        dest.writeLong(dateCreate);
        dest.writeLong(userFromLastView);
        dest.writeLong(userToLastView);
        dest.writeLong(userFromDeleted);
        dest.writeLong(userToDeleted);
        dest.writeTypedList(memberList);
        dest.writeParcelable(lastMessage, flags);
        dest.writeLong(unreadCount);
        dest.writeParcelable(ad, flags);
        dest.writeInt(answer ? 1 : 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Chat> CREATOR = new Creator<Chat>() {
        @Override
        public Chat createFromParcel(Parcel in) {
            return new Chat(in);
        }

        @Override
        public Chat[] newArray(int size) {
            return new Chat[size];
        }
    };

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
