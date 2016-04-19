package ApiWorker.model.ads.getPostFields;

import java.util.List;

/**
 * Created by artem on 4/5/15.
 */
public class Field extends BaseField {

    public Field() {

    }

    public Field(String id, String name, String hint, String type, int isRequired, String suffix, List<Range> rangeList) {
        super(id, name, hint, type, isRequired, suffix, rangeList);
    }

    public int describeContents() {

        return 0;
    }
}
