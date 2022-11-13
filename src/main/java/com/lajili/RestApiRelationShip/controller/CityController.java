package com.lajili.RestApiRelationShip.controller;

import com.lajili.RestApiRelationShip.dto.requestDto.CityRequestDto;
import com.lajili.RestApiRelationShip.model.City;
import com.lajili.RestApiRelationShip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = cityService.getCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<City> getCityById(@PathVariable final Long id) {
        City city = cityService.getCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody final CityRequestDto cityRequestDto) {
        City city = cityService.addCity(cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }
    @PutMapping("/edit/id")
    public ResponseEntity<City> editCity(@RequestBody final CityRequestDto cityRequestDto,
                                         @PathVariable final Long id) {
        City city = cityService.editCity(id, cityRequestDto);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable final Long id) {
        City city = cityService.deleteCity(id);
        return new ResponseEntity<>(city, HttpStatus.NO_CONTENT);
    }

}
