package com.goldmen.home;

import com.goldmen.home.house.service.RentHouseService;
import com.goldmen.home.map.service.MapService;
import com.goldmen.home.station.service.StationService;
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
