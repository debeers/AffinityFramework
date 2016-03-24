package ApiWorker.model.chats.addchat;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.chats.Chat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
