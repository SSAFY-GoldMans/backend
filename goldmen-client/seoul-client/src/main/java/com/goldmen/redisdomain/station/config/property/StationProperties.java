package com.goldmen.redisdomain.station.config.property;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class StationProperties {
    private final String StationPath = "stationInformation.json";
}
