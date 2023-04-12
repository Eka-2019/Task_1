package tests.api;

import config.EndPointUrl;
import models.JsonElementModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.utils.UtilsMethods;
import utils.ValidateResponse;

import java.util.List;
import java.util.Map;

public class TasksTests {
    List<JsonElementModel> json_modelList = ValidateResponse.getListJSON(EndPointUrl.TICKERS.getPath());

    @Test
    public void getElementsWithOpenPriceLessThanLowPriceTest() {
        List<JsonElementModel> openPriceIsLessThanLowPriceList = UtilsMethods.getOpenPriceIsLessThanLowPrice(json_modelList);
        for (JsonElementModel element : openPriceIsLessThanLowPriceList) {
            System.out.println(element);
        }
        Assertions.assertEquals(0, openPriceIsLessThanLowPriceList.size());
    }

    @Test
    public void getElementsWhoseVolumeAreMoreThanAverageOfAllVolumesTest() {
        List<JsonElementModel> baseAssetVolumeHigherThanAverageList = UtilsMethods.getElementsWhoseVolumeAreMoreThanAverageOfAllVolumes(json_modelList);
        for (JsonElementModel element : baseAssetVolumeHigherThanAverageList) {
            System.out.println(element);
        }
        Assertions.assertEquals(8, baseAssetVolumeHigherThanAverageList.size());
    }

    @Test
    public void FiveElementsWhichHasTheLeastDiffBetweenBidPriceAndAskPriceTest() {
        Map<JsonElementModel, Double> assetMapWithBidAsiPriceDiff = UtilsMethods.getDifferencesBetweenBidPriceAndAskPrice(json_modelList);
        Map<JsonElementModel, Double> fiveAssetMap = UtilsMethods.getFiveAssetsWhichHasTheLeastDiffBetweenBidPriceAndAskPrice(assetMapWithBidAsiPriceDiff);

        for (Map.Entry element : fiveAssetMap.entrySet()) {
            System.out.println("Element data/key: " + element.getKey());
            System.out.println("Element difference/value: " + element.getValue());
        }
        Assertions.assertEquals(5, fiveAssetMap.size());

    }

}
