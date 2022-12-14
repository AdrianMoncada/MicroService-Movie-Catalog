package com.dh.catalog.controller;

import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import com.dh.catalog.model.Genre;
import com.dh.catalog.model.SerieEntity;
import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.repository.MovieRepositoryMongo;
import com.dh.catalog.repository.SerieRepositoryMongo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static org.aeonbits.owner.util.Util.system;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

	private final MovieServiceClient movieServiceClient;
	private final SerieServiceClient serieServiceClient;

	private final MovieRepositoryMongo movieRepositoryMongo;

	private final SerieRepositoryMongo serieRepositoryMongo;

	public CatalogController(MovieServiceClient movieServiceClient, SerieServiceClient serieServiceClient, MovieRepositoryMongo movieRepositoryMongo, SerieRepositoryMongo serieRepositoryMongo) {
		this.movieServiceClient = movieServiceClient;
		this.serieServiceClient = serieServiceClient;
		this.movieRepositoryMongo = movieRepositoryMongo;
		this.serieRepositoryMongo = serieRepositoryMongo;
	}


	/*@Retry(name = "retryCatalog")*/
	@CircuitBreaker(name = "clientCatalog", fallbackMethod = "getAllByGenreFallBack")
	@GetMapping("/online/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Genre> getAllByGenre(@PathVariable String genre) {
		Genre response = new Genre();

		response.setMovies(movieServiceClient.findByGenre(genre));
		response.setSeries(serieServiceClient.findByGenre(genre));
		response.setGenre(genre);

		return ResponseEntity.ok().body(response);
	}

	/*TO DO*/
	public ResponseEntity<Genre> getAllByGenreFallBack(@PathVariable String genre, Throwable t) {
		System.out.println("Fall back method activated.");
		Genre response = new Genre();

		response.setMovies(movieRepositoryMongo.findByGenre(genre));
		response.setSeries(serieRepositoryMongo.findByGenre(genre));
		response.setGenre(genre);

		return ResponseEntity.ok().body(response);
	}


	/*TO DO*/
	/*@Retry(name = "retryCatalog")*/
	/*@CircuitBreaker(name = "clientCatalog", fallbackMethod = "getAllByGenreOfflineFallBack")*/
	@GetMapping("/offline/{genre}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Genre> getAllByGenreOffline(@PathVariable String genre) {
		Genre response = new Genre();

		response.setMovies(movieRepositoryMongo.findByGenre(genre));
		response.setSeries(serieRepositoryMongo.findByGenre(genre));
		response.setGenre(genre);

		return ResponseEntity.ok().body(response);
	}

	/*public ResponseEntity<Genre> getAllByGenreOfflineFallBack(@PathVariable String genre, Throwable t) {
		PASTE OFFLINE METHOD (BD)
	}*/



}
