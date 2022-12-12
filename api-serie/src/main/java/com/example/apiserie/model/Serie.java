package com.example.apiserie.model;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
/*import javax.persistence.*;*/
/*import java.io.Serial;*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SERIE")
public class Serie implements Serializable{

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
