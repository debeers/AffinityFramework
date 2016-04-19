package ApiWorker.model.filter.getParams;

import ApiWorker.model.BaseModel;

/**
 * Created by artem on 2/12/16.
 */
public class Currency extends BaseModel {

    private String key;
    private String name;

    public Currency() {

    }

    public Currency(String key, String name) {

        this.key = key;
        this.name = name;
    }

    public String getKey() {

        return key;
    }

    public String getName() {

        return name;
    }
}
