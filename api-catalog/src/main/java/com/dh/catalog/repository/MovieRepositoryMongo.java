package com.dh.catalog.repository;

import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.dto.MovieDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositoryMongo extends MongoRepository<MovieEntity, Long> {

    /*USE AT OFFLINE METHOD*/
    List<MovieDTO> findByGenre(String genre);
}
