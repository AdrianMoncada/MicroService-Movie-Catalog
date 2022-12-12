package com.dh.catalog.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDTO implements Serializable {

    private String movieId;
    private String name;
    private String genre;
    private String urlStream;
}
