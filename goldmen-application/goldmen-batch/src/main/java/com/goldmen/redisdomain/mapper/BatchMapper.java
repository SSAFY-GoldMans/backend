package com.goldmen.redisdomain.mapper;

import com.goldmen.jpadomain.building.monthly.domain.Monthly;
import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.global.domain.HouseInfo;
import com.goldmen.jpadomain.building.jeonse.domain.Jeonse;
import com.goldmen.redisdomain.dto.request.KaKaoKeywordAPIRequest;
import com.goldmen.redisdomain.dto.request.KakaoAddressAPIRequest;
import com.goldmen.redisdomain.house.vo.SeoulOpenDataRentHouse;
import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.redisdomain.map.vo.SeoulOpenDataMap;
import com.goldmen.jpadomain.metro.line.domain.Line;
import com.goldmen.jpadomain.metro.station.domain.Station;
import com.goldmen.redisdomain.station.vo.StationInfo;
import com.goldmen.redisdomain.vo.Position;
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
