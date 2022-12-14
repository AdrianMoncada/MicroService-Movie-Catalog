package com.dh.series.events;

import com.dh.series.config.RabbitMQConfig;
import com.dh.series.model.Chapter;
import com.dh.series.model.Season;
import com.dh.series.model.Serie;
import com.dh.series.model.dto.ChapterDTO;
import com.dh.series.model.dto.SeasonDTO;
import com.dh.series.model.dto.SerieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewSeriesEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public NewSeriesEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void execute(Serie serie) {
        System.out.print("Se ejecutó el metodo Execute en Serie");
        SerieDTO serieDTO = new SerieDTO();
        BeanUtils.copyProperties(serie, serieDTO);
        System.out.print(serieDTO.getName());
        /*for (Season s :
                serie.getSeasons()) {
            SeasonDTO sDTO = new SeasonDTO();
            BeanUtils.copyProperties(s, sDTO);
            for (Chapter c :
                    s.getChapters()) {
                ChapterDTO cDTO = new ChapterDTO();
                BeanUtils.copyProperties(c, cDTO);
                sDTO.getChapters().add(cDTO);
            }

            serieDTO.getSeasons().add(sDTO);
        }*/

        /*if (serieDTO.getSeasons().get(0).getChapters().get(0) != null && serie.getSeasons().get(0).getChapters().get(0) != null) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIES, serieDTO);
        }*/

            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIES, serieDTO);

    }

    /*public void execute(Serie serie) {
        System.out.print("Se ejecutó el metodo Execute en Serie. Implementacion reciente");
        *//*Data data = new Data();*//*
        NewSeriesEventProducer.Data data = new NewSeriesEventProducer.Data();
        BeanUtils.copyProperties(serie, data.getSerie());
        System.out.print("LOG DE DATA");
        System.out.print("Serie LOGEADA: " + data.getSerie().getGenre());
        *//*if (data.getSerie().getSeasons() != null && serie.getSeasons() != null) {
            BeanUtils.copyProperties(serie.getSeasons(), data.getSerie().getSeasons());
        }*//*

        BeanUtils.copyProperties(serie, data.getSerie());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIES, data);
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