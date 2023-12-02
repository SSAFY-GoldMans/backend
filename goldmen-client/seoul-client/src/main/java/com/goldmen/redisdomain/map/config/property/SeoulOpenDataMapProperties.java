package com.goldmen.redisdomain.map.config.property;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class SeoulOpenDataMapProperties {

    private final String mapPath = "lagalAndDistrictInformation.json";
}
