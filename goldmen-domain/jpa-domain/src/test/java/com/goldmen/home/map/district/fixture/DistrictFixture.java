package com.goldmen.home.map.district.fixture;

import com.goldmen.home.map.district.domain.District;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DistrictFixture {
    district1("강남구","1100"),
    district2("역삼구","0011"),
    districtBlankCode("서구",""),
    districtTooLongCode("서구","123456789098765432");

    private String name;
    private String code;

    public District createDistrict(){
        return District.builder()
                .name(name)
                .code(code)
                .build();
    }
}
