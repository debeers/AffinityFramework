package ApiWorker.model.ads.getads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ApiWorker.model.ads.Ad;

import java.util.List;

/**
 * Created by artem on 4/4/15.
 */
public class GetAdsData   {

    public GetAdsData(long countPages, List<Ad> adList) {
        this.countPages = countPages;
        this.adList = adList;
    }

    @SerializedName("ads")
    @Expose
    private List<Ad> adList;

    @SerializedName("countPages")
    @Expose
    private long countPages;

    public GetAdsData() {

    }

    public GetAdsData(List<Ad> adList) {

        this.adList = adList;
    }



    public List<Ad> getAdList() {

        return adList;
    }

    public void setAdList(List<Ad> adList) {

        this.adList = adList;
    }

    @Override
    public String toString() {

        return "GetAdsData{" +
                "adList=" + adList +
                '}';
    }

    public long getCountPages() {

        return countPages;
    }

    public void setCountPages(long countPages) {

        this.countPages = countPages;
    }
}
