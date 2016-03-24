package ApiWorker.model.chats;


import ApiWorker.APIUtils.FormatUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.BaseModel;


/**
 * Created by artem on 8/18/15.
 */
public class Message extends BaseModel {

    public Message(long id, long chatId, long userFrom, String message, long dateCreate, String userHash, String attachments) {
        this.id = id;
        this.chatId = chatId;
        this.userFrom = userFrom;
        this.message = message;
        this.dateCreate = dateCreate;
        this.userHash = userHash;
        this.attachments = attachments;
    }

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("chat_id")
    @Expose
    private long chatId;

    @SerializedName("user_from")
    @Expose
    private long userFrom;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("date_create")
    @Expose
    private long dateCreate;

    @SerializedName("user_hash")
    @Expose
    private String userHash;

    @SerializedName("attachments")
    @Expose
    private String attachments;

    public String getFormattedDateCreate() {

        return dateCreate > 0 ? FormatUtils.getMessageDateFormat(dateCreate) : "";
    }

    public String getUserHash() {

        return userHash;
    }

    public long getDateCreate() {

        return dateCreate;
    }

    public long getUserFrom() {

        return userFrom;
    }

    public String getMessage() {

        return message;
    }


    public void setMessage(String message) {

        this.message = message;
    }


    public Message() {

    }
}