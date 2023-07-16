package tests.api;

import models.JsonElementModel;
import org.junit.jupiter.api.Test;
import tests.utils.UtilsMethods;

import java.util.List;
import java.util.Map;

public class FunctionalTests extends BaseTest {
    @Test
    public void getElementsWithOpenPriceLessThanLowPriceTest() {
        List<JsonElementModel> openPriceIsLessThanLowPriceList = UtilsMethods.getOpenPriceIsLessThanLowPrice(json_modelList);
        for (JsonElementModel element : openPriceIsLessThanLowPriceList) {
            System.out.println(element);
        }
        checkThatExpectedResultIsEqualActualResult(0, openPriceIsLessThanLowPriceList.size());
    }

    @Test
    public void getElementsWhoseVolumeAreMoreThanAverageOfAllVolumesTest() {
        List<JsonElementModel> baseAssetVolumeHigherThanAverageList = UtilsMethods.getElementsWhoseVolumeAreMoreThanAverageOfAllVolumes(json_modelList);
        for (JsonElementModel element : baseAssetVolumeHigherThanAverageList) {
            System.out.println(element);
        }
        checkThatExpectedResultIsEqualActualResult(11, baseAssetVolumeHigherThanAverageList.size());
    }

    @Test
    public void FiveElementsWhichHasTheLeastDiffBetweenBidPriceAndAskPriceTest() {
        Map<JsonElementModel, Double> assetMapWithBidAsiPriceDiff = UtilsMethods.getDifferencesBetweenBidPriceAndAskPrice(json_modelList);
        Map<JsonElementModel, Double> fiveAssetMap = UtilsMethods.getFiveAssetsWhichHasTheLeastDiffBetweenBidPriceAndAskPrice(assetMapWithBidAsiPriceDiff);

        for (Map.Entry element : fiveAssetMap.entrySet()) {
            System.out.println("Element data/key: " + element.getKey());
            System.out.println("Element difference/value: " + element.getValue());
        }
        checkThatExpectedResultIsEqualActualResult(5, fiveAssetMap.size());

    }

}
