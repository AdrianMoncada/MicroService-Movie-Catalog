package com.dh.catalog.model;


import lombok.*;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SerieDTO;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

    private String genre;
    private List<MovieDTO> movies;
    private List<SerieDTO> series;

}
