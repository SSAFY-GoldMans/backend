package com.goldmen.home.mapper;

import com.goldmen.home.building.Monthly.domain.Monthly;
import com.goldmen.home.building.building.domain.Building;
import com.goldmen.home.building.global.domain.HouseInfo;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import com.goldmen.home.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.home.dto.request.KakaoAddressAPIRequest;
import com.goldmen.home.house.vo.SeoulOpenDataRentHouse;
import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.legal.domain.Legal;
import com.goldmen.home.map.vo.SeoulOpenDataMap;
import com.goldmen.home.metro.line.domain.Line;
import com.goldmen.home.metro.station.domain.Station;
import com.goldmen.home.station.vo.StationInfo;
import com.goldmen.home.vo.Position;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper {
    public District toDistrict(SeoulOpenDataRentHouse rentHouse) {
        return District.builder()
                .name(rentHouse.sggNm())
                .code(rentHouse.sggCd())
                .build();
    }

    public District toDistrict(SeoulOpenDataMap map) {
        return District.builder()
                .code(map.getSigunguCd())
                .name(map.getSigunguNm())
                .build();
    }

    public Legal toLegal(SeoulOpenDataRentHouse rentHouse, District district) {
        return Legal.builder()
                .code(rentHouse.bjdongCd())
                .name(rentHouse.bjdongNm())
                .district(district)
                .build();
    }

    public Legal toLegal(SeoulOpenDataMap map, District district) {
        return Legal.builder()
                .code(map.getBjdongCd())
                .name(map.getBjdongNm())
                .district(district)
                .build();
    }

    public KakaoAddressAPIRequest toKakaoAddressAPIRequest(SeoulOpenDataRentHouse rentHouse) {
        return KakaoAddressAPIRequest.builder()
                .bobn(rentHouse.bobn())
                .bubn(rentHouse.bubn())
                .bjDongNm(rentHouse.bjdongNm())
                .sggNm(rentHouse.sggNm())
                .build();
    }

    public Building toBuilding(SeoulOpenDataRentHouse rentHouse, Legal legal, Position position) {
        return Building.builder()
                .lng(position.getLongitude())
                .lat(position.getLatitude())
                .mainNumber(rentHouse.bobn())
                .subNumber(rentHouse.bubn())
                .name(rentHouse.bldgNm())
                .constructionYear(rentHouse.buildYear())
                .legal(legal)
                .type(rentHouse.houseGbnNm())
                .build();
    }

    public Jeonse toJeonse(SeoulOpenDataRentHouse rentHouse, Building building) {
        return Jeonse.builder()
                .price(rentHouse.rentGtn())
                .houseInfo(toHouseInfo(rentHouse))
                .building(building)
                .build();
    }

    public Monthly toMonthly(SeoulOpenDataRentHouse rentHouse, Building building) {
        return Monthly.builder()
                .price(rentHouse.rentGtn())
                .rent(rentHouse.rentFee())
                .houseInfo(toHouseInfo(rentHouse))
                .building(building)
                .build();
    }

    private HouseInfo toHouseInfo(SeoulOpenDataRentHouse rentHouse) {
        return HouseInfo.builder()
                .area(rentHouse.rentArea())
                .floor(rentHouse.flrNo())
                .build();
    }

    public KaKaoKeywordAPIRequest toKakaoKeywordAPIRequest(String keyword) {
        return KaKaoKeywordAPIRequest.builder()
                .keyword(keyword)
                .build();
    }

    public Line toLine(StationInfo stationInfo) {
        return Line.builder()
                .name(stationInfo.getLineNum())
                .build();
    }

    public Station toStation(StationInfo stationInfo, Position position, Line line, Legal legal) {
        return Station.builder()
                .name(stationInfo.getStationName())
                .lng(position.getLongitude())
                .lat(position.getLatitude())
                .code(stationInfo.getStationCode())
                .line(line)
                .legal(legal)
                .build();
    }
}
