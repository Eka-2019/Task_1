package tests.api;

import config.EndPointUrl;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import utils.ValidateResponse;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class APITests {
    ValidatableResponse response = ValidateResponse.getRequest(EndPointUrl.TICKERS.getPath());

    @Test
    public void JSONStatusTest() {
        response.statusCode(200);
        response.statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void TimeLoadFileTest() {
        response.time(lessThan(20L), TimeUnit.SECONDS);
    }

    @Test
    public void JSONHeaderTest() {
        response.headers("Content-Type", "application/json; charset=utf-8");
        response.headers("Transfer-Encoding", "chunked");
        response.headers("Connection", "keep-alive");
        response.headers("Server", "openresty");
        response.headers("Access-Control-Allow-Credentials", "true");
        response.headers("Access-Control-Max-Age", "1728000");
        response.headers("Access-Control-Allow-Headers", "User-Agent,Keep-Alive,Content-Type,access-key,api-key,signature,tonce,username,Recaptcha-Token,Recaptcha-Type,fingerPrint,timezone,platform,isBrowser");
        response.headers("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT, PATCH");
    }
}
