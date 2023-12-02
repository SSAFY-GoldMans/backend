package com.goldmen.api.global;

import com.goldmen.api.metro.dto.NearMetroResponse;
import com.goldmen.jpadomain.metro.station.domain.Station;

import java.util.List;

import static com.goldmen.common.mapper.PriceMapper.priceToStr;

public class Mapper {
    static public NearMetroResponse stationToNearMetroResponse(Station station, int price, int time, int count, List<Integer> lines) {
        return new NearMetroResponse(station.getName() + "역", time + "분", station.getLegal().getDistrict().getName() + " " + station.getLegal().getName(), priceToStr(price, 10000), station.getLat(), station.getLng(), count, lines);
    }
}
