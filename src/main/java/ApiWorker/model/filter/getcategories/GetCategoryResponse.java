package ApiWorker.model.filter.getCategories;

import ApiWorker.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 4/2/15.
 */
public class GetCategoryResponse extends BaseResponse {

    @SerializedName("data")
    private List<Category> categoryList;

    public GetCategoryResponse() {

    }

    public GetCategoryResponse(List<Category> categoryList) {

        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {

        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {

        this.categoryList = categoryList;
    }
}