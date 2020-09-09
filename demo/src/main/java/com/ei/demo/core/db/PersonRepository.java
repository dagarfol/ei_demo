package com.ei.demo.core.db;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ei.demo.core.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
