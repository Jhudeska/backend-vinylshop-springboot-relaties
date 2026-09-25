import nl.novi.backendvinylshopspringbootrelaties.entities.Genre;
import nl.novi.backendvinylshopspringbootrelaties.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootrelaties.services.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

    private final GenreService genreService;
    private final UrlHelper urlHelper;

    public GenreController(GenreService genreService, UrlHelper urlHelper) {
        this.genreService = genreService;
        this.urlHelper = urlHelper;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        var genres = genreService.findAllGenres();
        return ResponseEntity.ok(genres);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        var genre = genreService.findGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genreInput) {
        var newGenre = genreService.createGenre(genreInput);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newGenre.getId())).body(newGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genreInput) {
        var updatedGenre = genreService.updateGenre(id, genreInput);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}