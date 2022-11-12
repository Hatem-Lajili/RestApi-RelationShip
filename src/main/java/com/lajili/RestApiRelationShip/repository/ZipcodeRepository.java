package com.lajili.RestApiRelationShip.repository;

import com.lajili.RestApiRelationShip.model.Zipcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode,Long> {
}
