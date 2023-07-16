package tests.api;

import models.JsonElementModel;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static tests.utils.UtilsMethods.*;

public class JsonDataValidationTests extends BaseTest{

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
        checkThatExpectedResultIsEqualActualResult(1, count);
    }

}
