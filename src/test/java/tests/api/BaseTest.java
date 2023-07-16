package tests.api;

import config.EndPointUrl;
import io.restassured.response.ValidatableResponse;
import models.JsonElementModel;
import org.junit.jupiter.api.Assertions;
import utils.ValidateResponse;

import java.util.List;

public class BaseTest {

    ValidatableResponse response = ValidateResponse.getRequest(EndPointUrl.TICKERS.getPath());
    List<JsonElementModel> json_modelList = ValidateResponse.getListJSON(EndPointUrl.TICKERS.getPath());

    public void checkThatExpectedResultIsEqualActualResult(int expected, int actual){
        Assertions.assertEquals(expected, actual);
    }

}
