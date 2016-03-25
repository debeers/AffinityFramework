package ApiWorker.model;

import org.apache.http.util.TextUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by artem on 12/8/15.
 */
public class Country {

    public static final int DEFAULT_PHONE_NUM_LENGTH = 9;

    private final String name;
    private final String code;
    private final List<AppEndpoint> endpoints;
    private final AppEndpoint defaultEndpoint;
    private final String siteUrl;
    private final String emailAddress;
    private final int phoneNumLength;
    private final String propertyIdGA;

    private Country(String code, String name, List<AppEndpoint> endpoints,
                    AppEndpoint defaultEndpoint, String siteUrl, String emailAddress, int phoneNumLength, String propertyIdGA) {

        this.code = code;
        this.name = name;
        this.endpoints = endpoints;
        this.defaultEndpoint = defaultEndpoint;
        this.siteUrl = siteUrl;
        this.emailAddress = emailAddress;
        this.phoneNumLength = phoneNumLength;
        this.propertyIdGA = propertyIdGA;
    }

    public String getName() {

        return name;
    }

    public String getCode() {

        return code;
    }

    public CharSequence[] getLanguageNames() {

        CharSequence[] names = new CharSequence[endpoints.size()];
        int index = 0;
        for (AppEndpoint endpoint : endpoints) {

            names[index] = endpoint.getLanguage().getName();
            index++;
        }

        return names;
    }

    public int getPhoneNumLength() {

        return phoneNumLength;
    }

    public CharSequence[] getLanguageCodes() {

        CharSequence[] codes = new CharSequence[endpoints.size()];
        int index = 0;
        for (AppEndpoint endpoint : endpoints) {

            codes[index] = endpoint.getLanguage().getCode();
            index++;
        }

        return codes;
    }

    public List<Language> getLanguages() {

        List<Language> languages = new LinkedList<>();
        for (AppEndpoint endpoint : endpoints) {

            languages.add(endpoint.getLanguage());
        }

        return languages;
    }

    public String getSiteUrl() {

        return siteUrl;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public AppEndpoint getDefaultEndpoint() {

        return defaultEndpoint;
    }

    public String getPropertyIdGA() {

        return propertyIdGA;
    }

    public boolean isDefaultLanguage(Language language) {

        for (AppEndpoint endpoint : endpoints) {

            if (endpoint.getLanguage().getCode().equalsIgnoreCase(language.getCode()))
                return true;
        }

        return false;
    }

    public Language getDefaultLanguage() {

        return defaultEndpoint.getLanguage();
    }

    public AppEndpoint getEndpointByLanguageCode(String code) {

        if (TextUtils.isEmpty(code))
            return null;

        for (AppEndpoint endpoint : endpoints) {

            if (code.equalsIgnoreCase(endpoint.getLanguage().getCode()))
                return endpoint;
        }

        return null;
    }

    public static class Builder {

        private String name;
        private String code;
        private List<AppEndpoint> endpoints;
        private AppEndpoint defaultEndpoint;
        private String siteUrl;
        private String emailAddress;
        private int phoneNumLength;
        private String propertyIdGA;

        public Builder() {

            endpoints = new LinkedList<>();
        }

        public Builder addEndpoint(AppEndpoint endpoint) {

            this.endpoints.add(endpoint);

            return this;
        }

        public Builder setDefaultEndpoint(AppEndpoint endpoint) {

            this.defaultEndpoint = endpoint;

            return this;
        }

        public Builder setName(String name) {

            this.name = name;

            return this;
        }

        public Builder setCode(String code) {

            this.code = code;

            return this;
        }

        public Builder setSiteUrl(String siteUrl) {

            this.siteUrl = siteUrl;

            return this;
        }

        public Builder setPropertyIdGA(String propertyIdGA) {

            this.propertyIdGA = propertyIdGA;

            return this;
        }

        public Builder setEmailAddress(String emailAddress) {

            this.emailAddress = emailAddress;

            return this;
        }

        public Builder setPhoneNumLength(int phoneNumLength) {

            this.phoneNumLength = phoneNumLength;

            return this;
        }

        public Country build() {

            return new Country(code, name, endpoints, defaultEndpoint, siteUrl, emailAddress, phoneNumLength, propertyIdGA);
        }
    }

    @Override
    public String toString() {

        return name;
    }
}
