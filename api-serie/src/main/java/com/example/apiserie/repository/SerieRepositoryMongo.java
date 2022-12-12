package com.example.apiserie.repository;

import com.example.apiserie.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepositoryMongo extends MongoRepository<Serie, Long> {
    List<Serie> findByGenre(String genre);
}
