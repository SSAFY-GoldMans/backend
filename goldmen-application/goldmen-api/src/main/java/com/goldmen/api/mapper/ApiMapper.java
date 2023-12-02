package com.goldmen.api.mapper;

import com.goldmen.api.house.dto.request.GetHouseRequest;
import com.goldmen.jpadomain.building.monthly.cond.Area;
import com.goldmen.jpadomain.building.monthly.cond.FindAllCondition;
import com.goldmen.jpadomain.building.monthly.cond.Price;
import com.goldmen.jpadomain.building.monthly.cond.Rent;
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
