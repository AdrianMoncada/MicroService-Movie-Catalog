package com.example.apiserie.service;
import com.example.apiserie.model.Serie;
import com.example.apiserie.event.NewSerieEventProducer;
import com.example.apiserie.repository.SerieRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepositoryMongo serieRepositoryMongo;

    private final NewSerieEventProducer newSerieEventProducer;

    /*private final Feign feign;*/

    public SerieService(SerieRepositoryMongo serieRepositoryMongo, NewSerieEventProducer newSerieEventProducer) {
        this.serieRepositoryMongo = serieRepositoryMongo;
        this.newSerieEventProducer = newSerieEventProducer;
    }

    public void save(Serie serie) {
        serieRepositoryMongo.save(serie);
        newSerieEventProducer.execute(serie);
    }

    public List<Serie> getAll() {
        return serieRepositoryMongo.findAll();
    }

    public Serie getById(Long id) {
        return serieRepositoryMongo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        serieRepositoryMongo.deleteById(id);
    }

    public void update(Serie serie) {
        if (serieRepositoryMongo.existsById(serie.getId())) {
            serieRepositoryMongo.save(serie);
        }
    }

    /*public void addSeason(Long idSerie, Long idSeason) throws Exception {
        var serie = serieRepository.findById(idSerie);
        if (serie.isPresent()) {
            var result = musicFeign.getById(idSeason);
            if (result == null) {
                throw new Exception("Season not found");
            }
            serie.get().getMusics().add(new PlayListMusic(null, playList.get(),result.getMusicId(),result.getName()));
            serieRepository.save(playList.get());

            newSerieEventProducer.execute(playList.get());
        }else{
            throw new Exception("Serie not found");
        }
    }*/

}
