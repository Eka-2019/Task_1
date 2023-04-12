package config;

import lombok.Getter;
import org.apache.log4j.Logger;
import utils.ValidateResponse;

@Getter
public enum EndPointUrl {

    TICKERS(String.format("/sapi/v1/tickers/24hr"));

    String path;

    EndPointUrl(String path) {
        this.path = path;
    }

}
