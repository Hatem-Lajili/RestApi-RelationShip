package com.lajili.RestApiRelationShip.service;

import com.lajili.RestApiRelationShip.dto.requestDto.CityRequestDto;
import com.lajili.RestApiRelationShip.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> getCities();
    City getCity(Long cityId);
    City addCity(CityRequestDto cityRequestDto);
    City editCity(Long cityId, CityRequestDto cityRequestDto);
    City deleteCity(Long cityId);
}
