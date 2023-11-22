package com.goldmen.home.mapper;

import com.goldmen.home.building.Monthly.cond.Area;
import com.goldmen.home.building.Monthly.cond.FindAllCondition;
import com.goldmen.home.building.Monthly.cond.Price;
import com.goldmen.home.building.Monthly.cond.Rent;
import com.goldmen.home.house.dto.request.GetHouseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiMapper {
    public FindAllCondition toFindAllCondition(GetHouseRequest request){
        log.info(request.toString());
        return FindAllCondition.builder()
                .buildingType(request.getBuildingType())
                .price(new Price(request.getPrice().getMax(),request.getPrice().getMin()))
                .rent(new Rent(request.getRent().getMax(),request.getRent().getMin()))
                .area(new Area(request.getArea().getMax(),request.getArea().getMin()))
                .build();
    }
}
