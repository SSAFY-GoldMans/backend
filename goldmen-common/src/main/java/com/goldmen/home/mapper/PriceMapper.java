package com.goldmen.home.mapper;

import java.text.DecimalFormat;

public class PriceMapper {
    public static String priceToStr(int price, int unit) {
        long unitPrice = (long) price * unit;
        if (unitPrice >= 1e8) {
            return new DecimalFormat("#,##0.##억원").format(unitPrice / 1e8);
        } else {
            return new DecimalFormat("#,##0.##만원").format(unitPrice / 1e4);
        }
    }
}
