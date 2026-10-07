package nl.novi.backendvinylshopspringbootrelaties.controllers;

import jakarta.validation.Valid;
import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootrelaties.services.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {

    private final ArtistService artistService;
    private final UrlHelper urlHelper;

    public ArtistController(ArtistService artistService, UrlHelper urlHelper) {
        this.artistService = artistService;
        this.urlHelper = urlHelper;
    }

    @GetMapping
    public ResponseEntity<List<ArtistResponseDTO>> getAllArtists() {
        List<ArtistResponseDTO> artists = artistService.findAllArtists();

        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponseDTO> getArtistById(
            @PathVariable Long id
    ) {
        ArtistResponseDTO artist = artistService.findArtistById(id);

        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ArtistResponseDTO> createArtist(
            @RequestBody @Valid ArtistRequestDTO artistInput
    ) {
        ArtistResponseDTO newArtist =
                artistService.createArtist(artistInput);

        return ResponseEntity
                .created(urlHelper.getCurrentUrlWithId(newArtist.getId()))
                .body(newArtist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistResponseDTO> updateArtist(
            @PathVariable Long id,
            @RequestBody @Valid ArtistRequestDTO artistInput
    ) {
        ArtistResponseDTO updatedArtist =
                artistService.updateArtist(id, artistInput);

        return new ResponseEntity<>(updatedArtist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(
            @PathVariable Long id
    ) {
        artistService.deleteArtist(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}