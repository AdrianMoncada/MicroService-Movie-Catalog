package com.dh.catalog.repository;

import com.dh.catalog.model.SerieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SerieRepositoryMongo extends MongoRepository<SerieEntity, Long> {

    /*USE AT OFFLINE METHOD*/
    List<SerieEntity> findByGenre(String genre);
}
