package com.goldmen.home.map.legal.fixture;

import com.goldmen.home.map.district.domain.District;
import com.goldmen.home.map.district.fixture.DistrictFixture;
import com.goldmen.home.map.legal.domain.Legal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LegalFixture {
    legal1("강남동", "1234"),
    legal2("역삼동", "4321");

    private String name;
    private String code;

    public Legal createLegal(District district) {
        return Legal.builder()
                .code(code)
                .name(name)
                .district(district)
                .build();
    }

    public Legal createLegal() {
        return Legal.builder()
                .code(code)
                .name(name)
                .district(DistrictFixture.district1.createDistrict())
                .build();
    }
}
