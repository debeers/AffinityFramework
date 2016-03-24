package ApiWorker.model.chats.sendmessage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;
import classifieds.yalla.model.chats.Message;

/**
 * Created by artem on 8/23/15.
 */
public class SendMessageResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private Message message;

    public Message getMessage() {

        return message;
    }

    public SendMessageResponse() {

    }
}
