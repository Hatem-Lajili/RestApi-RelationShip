package com.lajili.RestApiRelationShip.repository;

import com.lajili.RestApiRelationShip.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
