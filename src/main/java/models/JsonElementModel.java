package models;

import lombok.Data;

import java.math.BigInteger;

@Data
public class JsonElementModel {

    private String symbol;
    String baseAsset;
    String quoteAsset;
    Double openPrice;
    Double lowPrice;
    Double highPrice;
    Double lastPrice;
    Double volume;
    Double bidPrice;
    Double askPrice;
    BigInteger at;
}
