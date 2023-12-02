package com.goldmen.redisdomain.house.service;

import com.goldmen.jpadomain.building.monthly.service.MonthlyService;
import com.goldmen.jpadomain.building.building.domain.Building;
import com.goldmen.jpadomain.building.building.service.BuildingService;
import com.goldmen.jpadomain.building.jeonse.service.JeonseService;
import com.goldmen.redisdomain.house.dto.request.SeoulOpenDataRentHouseAPIRequest;
import com.goldmen.redisdomain.mapper.BatchMapper;
import com.goldmen.redisdomain.house.vo.SeoulOpenDataRentHouse;
import com.goldmen.redisdomain.house.vo.SeoulOpenDataRentHouseData;
import com.goldmen.jpadomain.map.district.domain.District;
import com.goldmen.jpadomain.map.district.service.DistrictService;
import com.goldmen.jpadomain.map.legal.domain.Legal;
import com.goldmen.jpadomain.map.legal.service.LegalService;
import com.goldmen.redisdomain.service.KakaoMapService;
import com.goldmen.redisdomain.vo.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RentHouseService {
    private final SeoulOpenDataRentHouseClient seoulOpenDataRentHouseClient;
    private final DistrictService districtService;
    private final LegalService legalService;
    private final BuildingService buildingService;
    private final KakaoMapService kakaoMapClient;
    private final JeonseService jeonseService;
    private final MonthlyService monthlyService;
    private final BatchMapper batchMapper;

    /**
     * 전세집 데이터를 추출 및 DB에 저장한다.
     * @param devide HouseData를 어느 정도로 줄인건지에 대한 param
     */
    public void saveHouseDatas(int devide) {
        SeoulOpenDataRentHouseData healthCheckResponse = seoulOpenDataRentHouseClient.fetchAPI(SeoulOpenDataRentHouseAPIRequest.healthCheckRequest());
        int totalCount = healthCheckResponse.listTotalCount() / devide;

        for (int i = 1; i < totalCount; i += 999) {
            SeoulOpenDataRentHouseData seoulOpenDataRentHouseData = seoulOpenDataRentHouseClient.fetchAPI(SeoulOpenDataRentHouseAPIRequest.toRequest(i, 999));
            saveHouseData(seoulOpenDataRentHouseClient.filteringHouse(seoulOpenDataRentHouseData.seoulOpenDataRentHouseList()));
            log.info("data search {}%", (float) i / totalCount * 100);
        }
        log.info("fetchHouseData method end");
    }

    /**
     * 전세집 데이터를 DB에 저장한다. 저장 테이블은 region, houseGeo, houseDetail 이다.
     *
     * @param rentHouseList 공공데이터에서 뽑은 전세집 데이터들
     */
    private void saveHouseData(List<SeoulOpenDataRentHouse> rentHouseList) {
        for (SeoulOpenDataRentHouse rentHouse : rentHouseList) {
            try {
                District district = districtService.saveDistrict(batchMapper.toDistrict(rentHouse));
                Legal legal = legalService.saveLegal(batchMapper.toLegal(rentHouse,district));
                Position position = kakaoMapClient.getPosition(batchMapper.toKakaoAddressAPIRequest(rentHouse));
                Building building = buildingService.save(batchMapper.toBuilding(rentHouse,legal,position));

                if(rentHouse.rentGbn().equals("전세")){
                    jeonseService.save(batchMapper.toJeonse(rentHouse,building));
                }else if(rentHouse.rentGbn().equals("월세")){
                    monthlyService.save(batchMapper.toMonthly(rentHouse,building));
                }
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
    }
}