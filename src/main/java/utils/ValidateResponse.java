package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import models.JsonElementModel;
import org.apache.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.BaseURL.BASE_URI;

public class ValidateResponse {

    private static final Logger LOGGER = Logger.getLogger(ValidateResponse.class);

    public static ValidatableResponse getRequest(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .when()
                .get(path)
                .then();
    }

    public static List<JsonElementModel> getListJSON(String path) {
        LOGGER.info("Getting Json");
        return getRequest(path).extract()
                .jsonPath().getList(".", JsonElementModel.class);
    }

}
