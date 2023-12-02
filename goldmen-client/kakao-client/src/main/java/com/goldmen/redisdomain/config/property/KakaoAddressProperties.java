package com.goldmen.redisdomain.config.property;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@Getter
public class KakaoAddressProperties {
    private final HttpMethod method = HttpMethod.GET;
    private final String addressPath = "v2/local/search/address.json";
    private final String keywordPath = "v2/local/search/keyword.json";
}
