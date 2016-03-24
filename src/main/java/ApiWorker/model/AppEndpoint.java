package ApiWorker.model;

import okhttp3.HttpUrl;


public class AppEndpoint {

    private HttpUrl url;
    private String name;
    private Language language;

    public AppEndpoint(Language language, String name, String url) {

        this.url = HttpUrl.parse(url);
        this.name = name;
        this.language = language;
    }

    public HttpUrl getUrl() {

        return url;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setUrl(HttpUrl url) {

        this.url = url;
    }

    public Language getLanguage() {

        return language;
    }

    public void setLanguage(Language language) {

        this.language = language;
    }
}
