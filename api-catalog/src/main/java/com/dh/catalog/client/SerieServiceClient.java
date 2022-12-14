package com.dh.catalog.client;

import com.dh.catalog.model.SerieEntity;
import com.dh.catalog.model.dto.SerieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name="api-series")
public interface SerieServiceClient {

    @GetMapping("/api/v1/series/{genre}")
    List<SerieDTO> findByGenre(@PathVariable(value = "genre") String genre);

    /*@Getter
    @Setter
    class SerieDto{
        private Long id;

        private String name;

        private String genre;

        private List<SerieServiceClient.SerieDto.Season> seasons = new ArrayList<>();


        @Getter
        @Setter
        *//*@NoArgsConstructor
        @AllArgsConstructor*//*
        public static class Season {


            private Long id;
            private Integer seasonNumber;

            private List<SerieServiceClient.SerieDto.Season.Chapter> chapters = new ArrayList<>();

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Chapter {


                private Long id;
                private String name;

                private Integer number;

                private String urlStream;

            }
        }
    }*/

}
