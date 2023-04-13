package config;

import lombok.Getter;

@Getter
public enum EndPointUrl {

    TICKERS(String.format("/sapi/v1/tickers/24hr"));

    String path;

    EndPointUrl(String path) {
        this.path = path;
    }

}
