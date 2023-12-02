package com.goldmen.redisdomain;

import com.goldmen.redisdomain.house.service.RentHouseService;
import com.goldmen.redisdomain.map.service.MapService;
import com.goldmen.redisdomain.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BatchApplicationRunner implements ApplicationRunner {

    private final MapService mapService;
    private final StationService stationService;
    private final RentHouseService rentHouseService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        mapService.saveMap();
//        stationService.saveStation();
//        rentHouseService.saveHouseDatas(50);
    }
}
