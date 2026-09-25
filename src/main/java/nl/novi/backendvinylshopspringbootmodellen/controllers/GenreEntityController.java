package nl.novi.backendvinylshopspringbootmodellen.controllers;

import jakarta.validation.Valid;
import nl.novi.backendvinylshopspringbootmodellen.dtos.genre.GenreRequestDTO;
import nl.novi.backendvinylshopspringbootmodellen.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootmodellen.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootmodellen.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootmodellen.services.GenreEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreEntityController {

    private final GenreEntityService genreService;
    private final UrlHelper urlHelper;

    public GenreEntityController(GenreEntityService genreService, UrlHelper urlHelper) {
        this.genreService = genreService;
        this.urlHelper = urlHelper;
    }

    @GetMapping
    public ResponseEntity<List<GenreResponseDTO>> getAllGenres() {
        List<GenreResponseDTO> genres = genreService.findAllGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDTO> getGenreById(@PathVariable Long id) {
        GenreResponseDTO genre = genreService.findGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenreResponseDTO> createGenre(@RequestBody @Valid GenreRequestDTO genreInput) {
        GenreResponseDTO newGenre = genreService.createGenre(genreInput);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newGenre.getId())).body(newGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDTO> updateGenre(@PathVariable Long id, @RequestBody @Valid GenreRequestDTO genreInput) {
        GenreResponseDTO updatedGenre = genreService.updateGenre(id, genreInput);;
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}