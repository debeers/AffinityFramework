package TESTResources;

/**
 * Created by DeBeers on 13.04.2016.
 */
public enum LOCAL {

    AZ_RU("http://lalafo.az/ru"   ),     AZ_AZ("http://beta.lalafo.az/"        ),
    KG_RU("http://lalafo.kg/"     ),     KG_KY("http://lalafo.kg/ky"     ),
    TJ_RU("http://lalafo.tj/"     ),     TJ_TG("http://lalafo.tj/tg"     ),
    AF_EN("http://lalafo.af/en"   ),     NP_EN("http://lalafo.com.np"    ),
    RS_EN("http://lalafo.rs/en"   ),     GR_GR("http://lalafo.gr/"       ),
    GR_EN("http://lalafo.gr/en"   ),     AF_Dari("http://lalafo.af"      ),
    AF_PS("http://lalafo.af/ps"   ),     NP_NE("http://lalafo.com.np/ne" ),
    RS_RS("http://lalafo.rs/"     ),     CZ_CZ("http://lalafo.cz" );


    private String URL;

    LOCAL() {
    }

    LOCAL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

}
