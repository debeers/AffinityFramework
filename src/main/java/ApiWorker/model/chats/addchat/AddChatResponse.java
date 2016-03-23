package ApiWorker.model.chats.addchat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import classifieds.yalla.model.BaseResponse;
import classifieds.yalla.model.chats.Chat;

/**
 * Created by artem on 9/23/15.
 */
public class AddChatResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private Chat chat;


    public Chat getChat() {

        return chat;
    }
}
