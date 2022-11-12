package com.lajili.RestApiRelationShip.repository;

import com.lajili.RestApiRelationShip.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
