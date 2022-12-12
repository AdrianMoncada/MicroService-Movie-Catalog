package com.dh.catalog.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SerieDTO implements Serializable {

    private String serieId;

    private String name;

    private String genre;

    private List<SeasonDTO> seasonsDTO = new ArrayList<>();
}
