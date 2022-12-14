package com.dh.catalog.repository;

import com.dh.catalog.model.SerieEntity;
import com.dh.catalog.model.dto.SerieDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SerieRepositoryMongo extends MongoRepository<SerieDTO, Long> {

    /*USE AT OFFLINE METHOD*/
    List<SerieEntity> findByGenre(String genre);
}
