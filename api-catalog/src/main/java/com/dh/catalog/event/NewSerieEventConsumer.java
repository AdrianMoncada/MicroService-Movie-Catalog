package com.dh.catalog.event;


import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.model.SerieEntity;
import com.dh.catalog.repository.SerieRepositoryMongo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewSerieEventConsumer {

    private final SerieRepositoryMongo serieRepositoryMongo;


    public NewSerieEventConsumer(SerieRepositoryMongo serieRepositoryMongo) {
        this.serieRepositoryMongo = serieRepositoryMongo;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIES)
    public void execute(SerieEntity series) {
        series.setSerieId(12L);
        System.out.print("Se ejecutó el metodo Execute en Catalog");
        System.out.print(series.getName());
        serieRepositoryMongo.deleteById(series.getSerieId());
        serieRepositoryMongo.save(series);
    }

    /*@RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIES)
    public void execute(NewSerieEventConsumer.Data data) {
        SerieEntity serieNew= new SerieEntity();
        BeanUtils.copyProperties(data.getSerie(),serieNew);
        if (data.getSerie().getSeasons() != null && serieNew.getSeasons() != null) {
            BeanUtils.copyProperties(data.getSerie().getSeasons(),serieNew.getSeasons());
        }
        serieRepositoryMongo.deleteById(data.getSerie().getId());
        serieRepositoryMongo.save(serieNew);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {

        *//*@Serial
        private static final long serialVersionUID = 1L;*//*
        private SerieDto serie = new SerieDto();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SerieDto implements Serializable {

            *//*@Serial
            private static final long serialVersionUID = 1L;*//*
            private Long id;
            private String name;
            private String genre;
            private List<SeasonDto> seasons = new ArrayList<>();

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SeasonDto implements Serializable {

                *//*@Serial
                private static final long serialVersionUID = 1L;*//*
                private Long id;
                private Integer seasonNumber;

                private List<ChapterDto> chapters = new ArrayList<>();

                @Getter
                @Setter
                @NoArgsConstructor
                @AllArgsConstructor
                public static class ChapterDto implements Serializable {

                    private Long id;
                    private String name;

                    private Integer number;

                    private String urlStream;

                }
            }
        }

    }*/
}
