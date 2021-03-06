package ApiWorker.model;

/**
 * Created by artem on 12/8/15.
 */
public class Language {

    private String code;
    private String name;

    public Language(String code, String name) {

        this.code = code;
        this.name = name;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }
}
