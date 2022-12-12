package com.dh.catalog.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Series")
public class SerieEntity implements Serializable {

     /*@Serial
    private static final long serialVersionUID = 1L;*/

    @Id
    private Long id;
    private String name;
    private String genre;
    private List<Season> seasons = new ArrayList<>();


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Season {


        private Long id;
        private Integer seasonNumber;

        private List<Chapter> chapters = new ArrayList<>();

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



}
