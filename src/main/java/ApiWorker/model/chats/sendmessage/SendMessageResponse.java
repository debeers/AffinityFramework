package ApiWorker.model.chats.sendmessage;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.chats.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
