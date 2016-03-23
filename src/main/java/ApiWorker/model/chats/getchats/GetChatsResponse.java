package ApiWorker.model.chats.getchats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import classifieds.yalla.model.BaseResponse;
import classifieds.yalla.model.chats.Chat;

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