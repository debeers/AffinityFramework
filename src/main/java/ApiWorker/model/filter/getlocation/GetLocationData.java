package ApiWorker.model.filter.getLocation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by artem on 4/2/15.
 */
public class GetLocationData {

    @SerializedName("popular_regions")
    private List<Location> popularRegionsList;
    @SerializedName("popular_cities")
    private List<Location> popularCitiesList;
    @SerializedName("all_location")
    private List<Location> allLocationList;

    public GetLocationData() {

    }

    public List<Location> getPopularRegionsList() {

        return popularRegionsList;
    }

    public void setPopularRegionsList(List<Location> popularRegionsList) {

        this.popularRegionsList = popularRegionsList;
    }

    public List<Location> getPopularCitiesList() {

        return popularCitiesList;
    }

    public void setPopularCitiesList(List<Location> popularCitiesList) {

        this.popularCitiesList = popularCitiesList;
    }

    public List<Location> getAllLocationList() {

        return allLocationList;
    }

    public void setAllLocationList(List<Location> allLocationList) {

        this.allLocationList = allLocationList;
    }
}
