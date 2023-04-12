package tests.api;

import config.EndPointUrl;
import models.JsonElementModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ValidateResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tests.utils.UtilsMethods.*;

public class JsonDataValidationTests {

    List<JsonElementModel> json_modelList = ValidateResponse.getListJSON(EndPointUrl.TICKERS.getPath());

    @Test
    public void JSONDataBodyConsistencyTest() {
        for (JsonElementModel element : json_modelList) {
            checkJsonElementConsistency(element);
        }
    }

    @Test
    public void JSONPriceNotNegativeTest() {
        for (JsonElementModel element : json_modelList) {
            checkPricesNotNegative(element);
        }
    }

    @Test
    public void JSONVolumeNotNegativeTest() {
        for (JsonElementModel element : json_modelList) {
            checkVolumeNotNegative(element);
        }
    }

    @Test
    public void JSONDataDuplicationTest() {
        Map<JsonElementModel, Integer> mapWithDuplication = new HashMap<>();
        int count = 1;

        for (int i = 0; i < json_modelList.size(); i++) {
            JsonElementModel element = json_modelList.get(i);
            mapWithDuplication.put(element, mapWithDuplication.getOrDefault(element, 0) + 1);
        }

        for (Map.Entry element : mapWithDuplication.entrySet()) {
            if ((int) element.getValue() > 1) {
                element.toString();
                count++;
            }
        }
        Assertions.assertEquals(1, count);
    }

}
