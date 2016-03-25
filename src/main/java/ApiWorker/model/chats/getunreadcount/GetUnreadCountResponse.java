package ApiWorker.model.chats.getunreadcount;

import ApiWorker.model.BaseResponse;

/**
 * Created by artem on 9/24/15.
 */
public class GetUnreadCountResponse extends BaseResponse {

    private int unreadCount;

    public int getUnreadCount() {

        return unreadCount;
    }

    public GetUnreadCountResponse(int unreadCount) {
        this.unreadCount = unreadCount;
    }
}
