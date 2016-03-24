package ApiWorker.model;

import okhttp3.HttpUrl;
import retrofit2.BaseUrl;

/**
 * Created by artem on 12/9/15.
 */
public class AppRetrofitUrl implements BaseUrl {

    private AppEndpoint endpoint;

    public AppRetrofitUrl(AppEndpoint endpoint) {

        this.endpoint = endpoint;
    }

    public void setEndpoint(AppEndpoint endpoint) {

        this.endpoint = endpoint;
    }

    @Override
    public HttpUrl url() {

        return endpoint.getUrl();
    }
}
