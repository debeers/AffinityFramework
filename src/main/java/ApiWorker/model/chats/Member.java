package ApiWorker.model.chats;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by artem on 8/18/15.
 */
public class Member extends BaseModel {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("last_view")
    @Expose
    private long lastView;

    @SerializedName("username")
    @Expose
    private String userName;

    public long getId() {

        return id;
    }

    public Member(String type, long id, long lastView, String userName) {
        this.type = type;
        this.id = id;
        this.lastView = lastView;
        this.userName = userName;
    }
}
