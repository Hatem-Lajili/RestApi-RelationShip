package com.lajili.RestApiRelationShip.service.implementation;

import com.lajili.RestApiRelationShip.dto.requestDto.ZipcodeRequestDto;
import com.lajili.RestApiRelationShip.model.City;
import com.lajili.RestApiRelationShip.model.Zipcode;
import com.lajili.RestApiRelationShip.repository.ZipcodeRepository;
import com.lajili.RestApiRelationShip.service.CityService;
import com.lajili.RestApiRelationShip.service.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ZipcodeImp implements ZipcodeService {

    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Autowired
    CityService cityService;

    @Override
    public List<Zipcode> getZipcodes() {
        return StreamSupport
                .stream(zipcodeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Zipcode getZipcode(Long zipcodeId) {
        return zipcodeRepository.findById(zipcodeId).orElseThrow(() ->
                new IllegalArgumentException(
                        "zipcode with id: " + zipcodeId + " could not be found"));
    }

    @Transactional
    @Override
    public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcode = new Zipcode();
        zipcode.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() == null) {
            return zipcodeRepository.save(zipcode);
        }
        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcode.setCity(city);
        return zipcodeRepository.save(zipcode);
    }

    @Transactional
    @Override
    public Zipcode addCityToZipcode(Long zipcodeId, Long cityId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        City city = cityService.getCity(cityId);
        if (Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zipcode already has a city");
        }
        zipcode.setCity(city);
        return zipcode;    }

    @Transactional
    @Override
    public Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToEdit = getZipcode(zipcodeId);
        zipcodeToEdit.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() != null) {
            return zipcodeToEdit;
        }
        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcodeToEdit.setCity(city);
        return zipcodeToEdit;    }

    @Override
    public Zipcode deleteZipcode(Long zipcodeId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        zipcodeRepository.delete(zipcode);
        return zipcode;
    }

    @Override
    public Zipcode removeCityFromZipcode(Long zipcodeId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        if (!Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zipcode does not have a city");
        }
        zipcode.setCity(null);
        return zipcode;
    }
}
