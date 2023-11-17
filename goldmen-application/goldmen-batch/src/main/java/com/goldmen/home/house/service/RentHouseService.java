package com.goldmen.home.house.service;

import com.goldmen.home.house.dto.request.SeoulOpenDataRentHouseAPIRequest;
import com.goldmen.home.house.dto.response.SeoulOpenDataRentHouseDataResponse;
import com.goldmen.home.house.vo.SeoulOpenDataRentHouseData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RentHouseService {
//    private final SeoulOpenDataRentHouseClient seoulOpenDataRentHouseClient;
//
//    /**
//     * 전세집 데이터를 추출 및 DB에 저장한다.
//     * @param devide HouseData를 어느 정도로 줄인건지에 대한 param
//     */
//    public void fetchHouseData(int devide) {
//        SeoulOpenDataRentHouseData healthCheckResponse = seoulOpenDataRentHouseClient.fetchAPI(SeoulOpenDataRentHouseAPIRequest.healthCheckRequest());
//        int totalCount = healthCheckResponse.listTotalCount() / devide;
//
//        for (int i = 1; i < totalCount; i += 999) {
//            SeoulOpenDataRentHouseData rentHouseAPIResponse = seoulOpenDataRentHouseClient.fetchAPI(SeoulOpenDataRentHouseAPIRequest.toRequest(i, 999));
//            saveHouseData(seoulOpenDataRentHouseClient.filteringHouse(rentHouseAPIResponse.seoulOpenDataRentHouseList());
//            log.info("data search {}%", (float) i / totalCount * 100);
//        }
//        log.info("fetchHouseData method end");
//    }
//
//    /**
//     * 전세집 데이터를 DB에 저장한다. 저장 테이블은 region, houseGeo, houseDetail 이다.
//     *
//     * @param rentHouseDataList 공공데이터에서 뽑은 전세집 데이터들
//     */
//    private void saveHouseData(List<SeoulOpenDataRentHouseData> rentHouseDataList) {
//        for (SeoulOpenDataRentHouseData rentHouseData : rentHouseDataList) {
//            try {
//                Region region = regionService.getRegion(row);
//                HouseGeo houseGeo = houseGeoService.getHouseGeo(row, region);
//                Optional<HouseDetail> optionalHouseDetail =
//                        houseDetailService.findByDataCond(ExistByDetailCond.from(row));
//                if (optionalHouseDetail.isPresent()) {
//                    optionalHouseDetail.get().modifyUpdateDateByNow();
//                    continue;
//                }
//                houseDetailService.saveHouseDetail(row, houseGeo);
//            } catch (IndexOutOfBoundsException ignored) {
//            }
//        }
//    }
}
