package ApiWorker.model.chats.getchats;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.chats.Chat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 8/16/15.
 */
public class GetChatsResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<Chat> chatList;

    public GetChatsResponse() {

    }

    public List<Chat> getChatList() {

        return chatList;
    }

    public void setChatList(List<Chat> chatList) {

        this.chatList = chatList;
    }
}