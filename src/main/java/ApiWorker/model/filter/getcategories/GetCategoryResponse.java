package ApiWorker.model.filter.getcategories;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import classifieds.yalla.model.BaseResponse;

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