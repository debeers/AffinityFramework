package ApiWorker.model.filter;

import ApiWorker.model.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by artem on 4/2/15.
 */
public class Filter extends BaseModel {

    @SerializedName("id")
    protected long id;

    @SerializedName("name")
    protected String name;

    @SerializedName("has_children")
    protected long children;

    protected long parentId;

    public Filter(long id) {

        this.id = id;
    }

    public Filter(long id, String name, long children, long parentId) {
        this.id = id;
        this.name = name;
        this.children = children;
        this.parentId = parentId;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getParent() {

        return parentId;
    }

    public void setParent(long parentId) {

        this.parentId = parentId;
    }

    public String getName() {

        return name;
    }

    public boolean hasChildren() {

        return children > 0;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Filter() {

    }

    public Filter(String name) {

        this.name = name;
    }
}
