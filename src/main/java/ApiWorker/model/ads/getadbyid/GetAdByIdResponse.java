package ApiWorker.model.ads.getadbyid;

import ApiWorker.model.BaseResponse;
import ApiWorker.model.ads.Ad;

import java.util.List;

/**
 * Created by artem on 4/2/15.
 */
public class GetAdByIdResponse extends BaseResponse {

    private List<Ad> adList;

    public GetAdByIdResponse() {

    }

    public GetAdByIdResponse(List<Ad> adList) {

        this.adList = adList;
    }

    public List<Ad> getAdList() {

        return adList;
    }

    public void setAdList(List<Ad> adList) {

        this.adList = adList;
    }
}
