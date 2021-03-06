package ApiWorker.model.users.changepass;

import java.util.LinkedList;
import java.util.List;

import classifieds.yalla.model.BaseModel;
import classifieds.yalla.model.PostField;

/**
 * Created by artem on 9/1/15.
 */
public class ChangePassBody extends BaseModel {

    private List<PostField> changePassFieldList;

    public List<PostField> getChangePassFieldList() {

        return changePassFieldList;
    }

    public ChangePassBody(String newPassword, String confirmPass) {

        changePassFieldList = new LinkedList<>();
        changePassFieldList.add(new PostField(PostField.NEW_PASSWORD_ID, newPassword));
        changePassFieldList.add(new PostField(PostField.CONFIRM_PASSWORD_ID, confirmPass));
    }
}
