package ApiWorker.model.chats;

import ApiWorker.model.BaseModel;

/**
 * Created by artem on 9/21/15.
 */
public class BaseChat extends BaseModel {

    private String title;

    public BaseChat(String title) {

        this.title = title;
    }

    public String getTitle() {

        return title;
    }
}
