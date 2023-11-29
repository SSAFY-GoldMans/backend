package com.goldmen.home.mapper;

import com.goldmen.home.building.Monthly.cond.Area;
import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.Monthly.cond.Price;
import com.goldmen.home.building.Monthly.cond.Rent;
import com.goldmen.home.house.dto.request.GetHouseRequest;
import org.springframework.stereotype.Component;

@Component
public class ApiMapper {
    public FindAllCondition toFindAllCondition(GetHouseRequest request) {
        return FindAllCondition.builder()
                .buildingType(request.getBuildingEnum().strKorean)
                .price(new Price(request.getPrice().getMax(), request.getPrice().getMin()))
                .rent(new Rent(request.getRent().getMax(), request.getRent().getMin()))
                .area(new Area(request.getArea().getMax(), request.getArea().getMin()))
                .build();
    }
}
