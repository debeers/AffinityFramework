package ApiWorker.model.ads.getPostFields;

import java.util.List;

/**
 * Created by artem on 8/23/15.
 */
public class UserInfoField extends BaseField {

    public UserInfoField() {

    }

    public UserInfoField(String id, String name, String hint, String type, int isRequired, String suffix, List<Range> rangeList) {
        super(id, name, hint, type, isRequired, suffix, rangeList);
    }
}
