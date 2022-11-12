package com.lajili.RestApiRelationShip.service;

import com.lajili.RestApiRelationShip.dto.requestDto.ZipcodeRequestDto;
import com.lajili.RestApiRelationShip.model.Zipcode;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ZipcodeService {
    List<Zipcode> getZipcodes();
    Zipcode getZipcode(Long zipcodeId);
    Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto);
    Zipcode addCityToZipcode(Long zipcodeId, Long cityId);
    Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
    Zipcode deleteZipcode(Long zipcodeId);
    Zipcode removeCityFromZipcode(Long zipcodeId);
}
