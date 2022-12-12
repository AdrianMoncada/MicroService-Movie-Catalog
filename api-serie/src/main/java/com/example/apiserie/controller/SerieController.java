package com.example.apiserie.controller;

import com.example.apiserie.model.Serie;
import com.example.apiserie.service.SerieService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Long> create(@RequestBody Serie serie) {
        serieService.save(serie);
        return ResponseEntity.ok(serie.getId());
    }

    @GetMapping("/{genre}")
    private ResponseEntity<List<Serie>> findByGenre(@PathVariable String genre){
        return ResponseEntity.ok(serieService.findByGenre(genre));
    }

    /*@PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@RequestBody Serie serie) {
        serieService.update(serie);
        return ResponseEntity.ok().build();
    }*/

    /*@PatchMapping("/addSeason")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity addMusic(@RequestBody AddSeasonDto addSeasonDto) {
        try {
            serieService.addSeason(addSeasonDto.getId(), addSeasonDto.getMusicId());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Getter
    @Setter
    static class AddSeasonDto{
        private Long id;
        private Integer seasonNumber;

        private List<Serie.Season.Chapter> chapters = new ArrayList<>();

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
    }*/
}
