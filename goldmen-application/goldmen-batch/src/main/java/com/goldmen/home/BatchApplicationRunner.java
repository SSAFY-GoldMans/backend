package com.goldmen.home;

import com.goldmen.home.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BatchApplicationRunner implements ApplicationRunner {
    private final StationService stationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
