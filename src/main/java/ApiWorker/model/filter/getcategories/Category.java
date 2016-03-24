package ApiWorker.model.filter.getcategories;

import ApiWorker.model.ads.Ad;
import ApiWorker.model.filter.Filter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 4/2/15.
 */
public class Category extends Filter {

    private static final String LINEAR_LIST_TYPE = "table";

    @SerializedName("children")
    private List<Category> childrenList;

    @SerializedName("ad")
    private List<Ad> adList;

    @SerializedName("api_list_type")
    private String listType;

    @SerializedName("alias")
    private String alias;

    public Category() {

    }

    public Category(long id) {
        super(id);

    }

    public Category(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Category(long id, List<Category> childrenList,
                    List<Ad> adList, String listType, String alias) {
        super(id);
        this.childrenList = childrenList;
        this.adList = adList;
        this.listType = listType;
        this.alias = alias;
    }

    public Category(List<Category> childrenList, List<Ad> adList,
                    String listType, String alias) {
        this.childrenList = childrenList;
        this.adList = adList;
        this.listType = listType;
        this.alias = alias;
    }

    public Category(String name, List<Category> childrenList,
                    List<Ad> adList, String listType, String alias) {
        super(name);
        this.childrenList = childrenList;
        this.adList = adList;
        this.listType = listType;
        this.alias = alias;
    }

    public Category(long id, String name, List<Category> mChildrenList) {
        this.id = id;
        this.name = name;
        this.childrenList = mChildrenList;
    }

    public String getListType() {

        return listType;
    }

    public void setListType(String listType) {

        this.listType = listType;
    }

    public String getAlias() {

        return alias;
    }

    public List<Ad> getAdList() {

        return adList;
    }

    public void setAdList(List<Ad> adList) {

        this.adList = adList;
    }

    public boolean isAdListEmpty() {

        return adList == null || adList.isEmpty();
    }

    public boolean isLinearListType() {

        return LINEAR_LIST_TYPE.equals(listType);
    }

    public boolean hasChildren() {

        return childrenList != null && childrenList.size() > 0;
    }

    public List<Category> getChildrenList() {

        return childrenList;
    }
}
