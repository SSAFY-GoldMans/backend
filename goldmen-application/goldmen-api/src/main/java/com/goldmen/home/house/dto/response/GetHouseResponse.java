package com.goldmen.home.house.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goldmen.home.building.monthly.domain.Monthly;
import com.goldmen.home.building.global.domain.Saleable;
import com.goldmen.home.building.jeonse.domain.Jeonse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetHouseResponse {
    @JsonProperty
    private final List<GetHouse> houseList;

    public GetHouseResponse(List<GetHouse> list) {
        this.houseList = list;
    }

    public static GetHouseResponse from(List<Saleable> list) {
        if (list.isEmpty()) return new GetHouseResponse(new ArrayList<>());
        if (list.get(0) instanceof Jeonse) {
            return new GetHouseResponse(toJeonse(list));
        } else {
            return new GetHouseResponse(toMonthly(list));
        }
    }

    private static List<GetHouse> toJeonse(List<Saleable> list) {
        return list.stream().filter(value -> value instanceof Jeonse)
                .map(value -> (Jeonse) value)
                .toList().stream()
                .map(jeonse -> GetHouse.builder()
                        .id(jeonse.getId())
                        .position(GetHousePosition.saleableToGetHouseResponse(jeonse))
                        .address(convertAddress(jeonse))
                        .year(jeonse.getBuilding().getConstructionYear() + " 년")
                        .floor(jeonse.getHouseInfo().getFloor())
                        .price(convertPrice(jeonse.getPrice()))
                        .area(convertArea(jeonse.getHouseInfo().getArea()))
                        .build()).toList();
    }

    private static List<GetHouse> toMonthly(List<Saleable> list) {
        return list.stream().filter(value -> value instanceof Monthly)
                .map(value -> (Monthly) value).toList()
                .stream().map(monthly -> GetHouse.builder()
                        .id(monthly.getId())
                        .position(GetHousePosition.saleableToGetHouseResponse(monthly))
                        .address(convertAddress(monthly))
                        .year(monthly.getBuilding().getConstructionYear() + " 년")
                        .floor(monthly.getHouseInfo().getFloor())
                        .price(convertPrice(monthly.getPrice()) + " / " + convertPrice(monthly.getRent()))
                        .area(convertArea(monthly.getHouseInfo().getArea()))
                        .build())
                .toList();
    }

    private static String convertAddress(Jeonse jeonse) {
        return jeonse.getBuilding().getLegal().getDistrict().getName() + " "
                + jeonse.getBuilding().getLegal().getName() + " "
                + jeonse.getBuilding().getMainNumber() + " - "
                + jeonse.getBuilding().getSubNumber();
    }

    private static String convertAddress(Monthly monthly) {
        return monthly.getBuilding().getLegal().getDistrict().getName() + " "
                + monthly.getBuilding().getLegal().getName() + " "
                + monthly.getBuilding().getMainNumber() + " - "
                + monthly.getBuilding().getSubNumber();
    }

    private static String convertArea(double area) {
        return String.format("%d평", Math.round(area / 3.3));
    }

    private static String convertPrice(int price) {
        if (price >= 1e4) return Math.round(price / 1e4) + "억원";
        else return price + "만원";
    }
}
