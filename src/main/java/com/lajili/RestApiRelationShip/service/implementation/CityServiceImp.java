package com.lajili.RestApiRelationShip.service.implementation;

import com.lajili.RestApiRelationShip.dto.requestDto.CityRequestDto;
import com.lajili.RestApiRelationShip.model.City;
import com.lajili.RestApiRelationShip.repository.CityRepository;
import com.lajili.RestApiRelationShip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImp implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities :: add);
        return cities;
    }

    @Override
    public City getCity(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() ->
                new IllegalArgumentException("city with cityId: " + cityId + "could not be found" ));
    }

    @Override
    public City addCity(CityRequestDto cityRequestDto) {
        City city = new City();
        city.setName(cityRequestDto.getName());
        return cityRepository.save(city);
    }

    @Transactional
    @Override
    public City editCity(Long cityId, CityRequestDto cityRequestDto) {
        City cityToEdit = getCity(cityId);
        cityToEdit.setName(cityRequestDto.getName());
        return cityToEdit;
    }

    @Override
    public City deleteCity(Long cityId) {
        City city = getCity(cityId);
        cityRepository.delete(city);
        return city;
    }

}
