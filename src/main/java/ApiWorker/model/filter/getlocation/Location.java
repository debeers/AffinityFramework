package ApiWorker.model.filter.getLocation;

import ApiWorker.model.filter.Filter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 4/2/15.
 */
public class Location extends Filter {

    @SerializedName("children")
    private List<Location> childrenList;

    public Location() {

    }

    public Location(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Location(long id, String name, List<Location> childrenList) {

        this.id = id;
        this.name = name;
        this.childrenList = childrenList;
    }

    public Location(long id) {
        super(id);

    }

    public Location(long id, List<Location> childrenList) {
        super(id);
        this.childrenList = childrenList;
    }


    public Location(List<Location> childrenList) {
        this.childrenList = childrenList;
    }

    public Location(String name, List<Location> childrenList) {
        super(name);
        this.childrenList = childrenList;
    }

    public List<Location> getChildrenList() {

        return childrenList;
    }
}
