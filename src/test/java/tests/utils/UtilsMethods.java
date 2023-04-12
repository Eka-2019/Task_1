package tests.utils;

import models.JsonElementModel;
import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class UtilsMethods {

    public static List<JsonElementModel> getOpenPriceIsLessThanLowPrice(List<JsonElementModel> inputList) {
        List<JsonElementModel> outputList = new ArrayList<>();
        for (JsonElementModel element : inputList) {
            if (element.getOpenPrice() < element.getLowPrice()) {
                outputList.add(element);
            }
        }
        return outputList;
    }

    public static List<String> getListOfSymbolsWhereOpenPriceIsLessThanLowPrice(List<JsonElementModel> inputList) {
        List<String> outputList = new ArrayList<>();
        for (JsonElementModel element : inputList) {
            if (element.getOpenPrice() < element.getLowPrice()) {
                outputList.add(element.getSymbol());
            }
        }
        return outputList;
    }

    public static List<JsonElementModel> getElementsWhoseVolumeAreMoreThanAverageOfAllVolumes(List<JsonElementModel> inputList) {
        List<JsonElementModel> outputList = new ArrayList<>();
        for (JsonElementModel element : inputList) {
            if (element.getVolume() > getBaseAssetsVolumeAverageOfAllVolumes(inputList)) {
                outputList.add(element);
            }
        }
        return outputList;
    }

    public static List<String> getBaseAssetsWhoseVolumeAreMoreThanAverageOfAllVolumes(List<JsonElementModel> inputList) {
        List<String> outputList = new ArrayList<>();
        for (JsonElementModel element : inputList) {
            if (element.getVolume() > getBaseAssetsVolumeAverageOfAllVolumes(inputList)) {
                outputList.add(element.getBaseAsset());
            }
        }
        return outputList;
    }

    public static Double getBaseAssetsVolumeAverageOfAllVolumes(List<JsonElementModel> inputList) {
        Double baseAssetVolumeAverage;
        Double sum = 0.0;
        for (JsonElementModel element : inputList) {
            sum = sum + element.getVolume();
        }
        baseAssetVolumeAverage = sum / inputList.size();
        return baseAssetVolumeAverage;
    }

    public static Map<JsonElementModel, Double> getDifferencesBetweenBidPriceAndAskPrice(List<JsonElementModel> inputList) {
        Map<JsonElementModel, Double> json_modelMap = new HashMap<>();
        Double difference;

        for (JsonElementModel element : inputList) {
            difference = element.getBidPrice() - element.getAskPrice();
            json_modelMap.put(element, difference);
        }

        return json_modelMap;
    }

    public static Map<JsonElementModel, Double> getFiveAssetsWhichHasTheLeastDiffBetweenBidPriceAndAskPrice(Map<JsonElementModel, Double> inputMap) {
        Map<JsonElementModel, Double> outputMap = inputMap
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

        return outputMap;
    }
    public static void checkJsonElementConsistency(JsonElementModel element) {
        Assertions.assertNotNull(element.getSymbol(), element.toString());
        Assertions.assertFalse(element.getSymbol().isEmpty());
        Assertions.assertNotNull(element.getBaseAsset(), element.toString());
        Assertions.assertFalse(element.getBaseAsset().isEmpty());
        Assertions.assertNotNull(element.getQuoteAsset(), element.toString());
        Assertions.assertFalse(element.getQuoteAsset().isEmpty());
        Assertions.assertNotNull(element.getOpenPrice(), element.toString());
        Assertions.assertFalse(element.getOpenPrice().isNaN());
        Assertions.assertNotNull(element.getLowPrice(), element.toString());
        Assertions.assertFalse(element.getLowPrice().isNaN());
        Assertions.assertNotNull(element.getHighPrice(), element.toString());
        Assertions.assertFalse(element.getHighPrice().isNaN());
        Assertions.assertNotNull(element.getLastPrice(), element.toString());
        Assertions.assertFalse(element.getLastPrice().isNaN());
        Assertions.assertNotNull(element.getVolume(), element.toString());
        Assertions.assertFalse(element.getVolume().isNaN());
        Assertions.assertNotNull(element.getBidPrice(), element.toString());
        Assertions.assertFalse(element.getBidPrice().isNaN());
        Assertions.assertNotNull(element.getAskPrice(), element.toString());
        Assertions.assertFalse(element.getAskPrice().isNaN());
        Assertions.assertNotNull(element.getAt(), element.toString());
    }
    public static void checkPricesNotNegative(JsonElementModel element) {
        Assertions.assertTrue(element.getOpenPrice() > 0, element.toString());
        Assertions.assertTrue(element.getLowPrice() > 0, element.toString());
        Assertions.assertTrue(element.getHighPrice() > 0, element.toString());
        Assertions.assertTrue(element.getLastPrice() > 0, element.toString());
        Assertions.assertTrue(element.getBidPrice() > 0, element.toString());
        Assertions.assertTrue(element.getAskPrice() > 0, element.toString());
    }

    public static void checkVolumeNotNegative(JsonElementModel element) {
        Assertions.assertTrue(element.getVolume() >= 0, element.toString());
    }

}
