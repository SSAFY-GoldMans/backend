package com.goldmen.home.house.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SeoulOpenDataRentHouse(String accYear, String sggCd, String sggNm, String bjdongCd, String bjdongNm,
                                     String landGbn, String landGbnNm, int bobn, int bubn, Integer flrNo,
                                     String cntrctDe, String rentGbn, Double rentArea, int rentGtn, int rentFee,
                                     String bldgNm, int buildYear, String houseGbnNm, String cntrctPrd,
                                     String newRonSecd, String cntrctUpdtRqestAt, String beforeGrntyAmount,
                                     String beforeMtRentChrge) {
    @JsonCreator
    public SeoulOpenDataRentHouse(
            @JsonProperty("ACC_YEAR") String accYear,
            @JsonProperty("SGG_CD") String sggCd,
            @JsonProperty("SGG_NM") String sggNm,
            @JsonProperty("BJDONG_CD") String bjdongCd,
            @JsonProperty("BJDONG_NM") String bjdongNm,
            @JsonProperty("LAND_GBN") String landGbn,
            @JsonProperty("LAND_GBN_NM") String landGbnNm,
            @JsonProperty("BOBN") int bobn,
            @JsonProperty("BUBN") int bubn,
            @JsonProperty("FLR_NO") Integer flrNo,
            @JsonProperty("CNTRCT_DE") String cntrctDe,
            @JsonProperty("RENT_GBN") String rentGbn,
            @JsonProperty("RENT_AREA") Double rentArea,
            @JsonProperty("RENT_GTN") int rentGtn,
            @JsonProperty("RENT_FEE") int rentFee,
            @JsonProperty("BLDG_NM") String bldgNm,
            @JsonProperty("BUILD_YEAR") int buildYear,
            @JsonProperty("HOUSE_GBN_NM") String houseGbnNm,
            @JsonProperty("CNTRCT_PRD") String cntrctPrd,
            @JsonProperty("NEW_RON_SECD") String newRonSecd,
            @JsonProperty("CNTRCT_UPDT_RQEST_AT") String cntrctUpdtRqestAt,
            @JsonProperty("BEFORE_GRNTY_AMOUNT") String beforeGrntyAmount,
            @JsonProperty("BEFORE_MT_RENT_CHRGE") String beforeMtRentChrge) {
        this.accYear = accYear;
        this.sggCd = sggCd;
        this.sggNm = sggNm;
        this.bjdongCd = bjdongCd;
        this.bjdongNm = bjdongNm;
        this.landGbn = landGbn;
        this.landGbnNm = landGbnNm;
        this.bobn = bobn;
        this.bubn = bubn;
        this.flrNo = flrNo;
        this.cntrctDe = cntrctDe;
        this.rentGbn = rentGbn;
        this.rentArea = rentArea;
        this.rentGtn = rentGtn;
        this.rentFee = rentFee;
        this.bldgNm = bldgNm;
        this.buildYear = buildYear;
        this.houseGbnNm = houseGbnNm;
        this.cntrctPrd = cntrctPrd;
        this.newRonSecd = newRonSecd;
        this.cntrctUpdtRqestAt = cntrctUpdtRqestAt;
        this.beforeGrntyAmount = beforeGrntyAmount;
        this.beforeMtRentChrge = beforeMtRentChrge;
    }
}
