package com.dh.catalog.repository;

import com.dh.catalog.model.SerieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SerieRepositoryMongo extends MongoRepository<SerieEntity, Long> {
}
