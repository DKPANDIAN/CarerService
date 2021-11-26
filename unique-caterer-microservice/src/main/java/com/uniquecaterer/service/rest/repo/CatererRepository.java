package com.uniquecaterer.service.rest.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uniquecaterer.service.rest.entity.Caterer;

@Repository
public interface CatererRepository extends MongoRepository<Caterer, String>,PagingAndSortingRepository<Caterer, String> {
	

    @Query(value = "{ 'location.city' : ?0 }", fields = "{ 'location.city' : ?0 }")
    List<Caterer> findByLocationCityName(String cityName);

}
