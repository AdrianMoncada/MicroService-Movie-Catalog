package com.dh.catalog.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Movies")
public class MovieEntity implements Serializable {

    /*@Serial
    private static final long serialVersionUID = 1L;*/

    @Id
    private Long id;
    private String name;
    private String genre;
    private Integer urlStream;



}
