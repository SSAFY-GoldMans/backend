package com.goldmen.redisdomain.map.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SeoulOpenDataMap {
    private final String hjdongCd;
    private final String sigunguCd;
    private final String hjdongNm;
    private final String sigunguNm;
    private final String bjdongCd;
    private final String applyStrtDay;
    private final String sidoNm;
    private final String applyExpDay;
    private final String bjdongNm;

    @JsonCreator
    public SeoulOpenDataMap(
            @JsonProperty("hjdong_cd") String hjdongCd,
            @JsonProperty("sigungu_cd") String sigunguCd,
            @JsonProperty("hjdong_nm") String hjdongNm,
            @JsonProperty("sigungu_nm") String sigunguNm,
            @JsonProperty("bjdong_cd") String bjdongCd,
            @JsonProperty("apply_strt_day") String applyStrtDay,
            @JsonProperty("sido_nm") String sidoNm,
            @JsonProperty("apply_exp_day") String applyExpDay,
            @JsonProperty("bjdong_nm") String bjdongNm
    ) {
        this.hjdongCd = hjdongCd;
        this.sigunguCd = sigunguCd;
        this.hjdongNm = hjdongNm;
        this.sigunguNm = sigunguNm;
        this.bjdongCd = bjdongCd;
        this.applyStrtDay = applyStrtDay;
        this.sidoNm = sidoNm;
        this.applyExpDay = applyExpDay;
        this.bjdongNm = bjdongNm;
    }
}
