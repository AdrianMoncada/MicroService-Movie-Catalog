package com.dh.catalog.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeasonDTO {

    private Integer seasonId;

    private Integer seasonNumber;

    private List<ChapterDTO> chaptersDTO = new ArrayList<>();
}
