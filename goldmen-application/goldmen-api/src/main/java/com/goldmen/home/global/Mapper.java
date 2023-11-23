package com.goldmen.home.global;

import com.goldmen.home.metro.dto.NearMetroResponse;
import com.goldmen.home.metro.station.domain.Station;

import java.util.List;

import static com.goldmen.home.mapper.PriceMapper.priceToStr;

public class Mapper {
    static public NearMetroResponse stationToNearMetroResponse(Station station, int price, int time, int count, List<Integer> lines) {
        return new NearMetroResponse(station.getName() + "역", time + "분", station.getLegal().getDistrict().getName() + " " + station.getLegal().getName(), priceToStr(price, 10000), station.getLat(), station.getLng(), count, lines);
    }
}
