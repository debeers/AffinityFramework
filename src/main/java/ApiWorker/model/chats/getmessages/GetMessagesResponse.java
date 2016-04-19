package ApiWorker.model.chats.getMessages;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.chats.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 9/24/15.
 */
public class GetMessagesResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<Message> messageList;

    public List<Message> getMessageList() {

        return messageList;
    }

    public GetMessagesResponse(List<Message> messageList) {
        this.messageList = messageList;
    }
}
