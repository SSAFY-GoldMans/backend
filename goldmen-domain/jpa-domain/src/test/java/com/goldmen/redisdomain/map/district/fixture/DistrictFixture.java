package com.goldmen.redisdomain.map.district.fixture;

import com.goldmen.jpadomain.map.district.domain.District;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DistrictFixture {
    district1("강남구", "1100"),
    district2("역삼구", "0011"),
    district3("은평구", "11380"),
    districtBlankCode("서구", ""),
    districtTooLongCode("서구", "123456789098765432");

    private String name;
    private String code;

    public District createDistrict() {
        return District.builder()
                .name(name)
                .code(code)
                .build();
    }
}
