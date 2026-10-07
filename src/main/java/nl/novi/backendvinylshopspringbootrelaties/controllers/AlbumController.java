package nl.novi.backendvinylshopspringbootrelaties.controllers;

import jakarta.validation.Valid;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumExtendedResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootrelaties.services.AlbumService;
import nl.novi.backendvinylshopspringbootrelaties.services.ArtistService;
import nl.novi.backendvinylshopspringbootrelaties.services.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final UrlHelper urlHelper;
    private final ArtistService artistService;

    public AlbumController(AlbumService albumService, ArtistService artistService, UrlHelper urlHelper) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.urlHelper = urlHelper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumExtendedResponseDTO> getAlbumById(
            @PathVariable Long id
    ) {
        AlbumExtendedResponseDTO album = albumService.getAlbumById(id);
        return ResponseEntity.ok(album);
    }


    @PostMapping
    public ResponseEntity<AlbumResponseDTO> createAlbum(@Valid @RequestBody AlbumRequestDTO albumDTO){
        AlbumResponseDTO  newAlbum = albumService.createAlbum(albumDTO);
        return ResponseEntity.ok(newAlbum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponseDTO> updateAlbum(
            @PathVariable Long id,
            @Valid @RequestBody AlbumRequestDTO dto
    ) {
        AlbumResponseDTO album = albumService.updateAlbum(id, dto);
        return ResponseEntity.ok(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {

        albumService.deleteAlbum(id);

        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{albumId}/artists/{artistId}")
    public ResponseEntity<Void> linkArtist(
            @PathVariable Long albumId,
            @PathVariable Long artistId
    ) {
        albumService.linkArtist(albumId, artistId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{albumId}/artists/{artistId}")
    public ResponseEntity<Void> unlinkArtist(
            @PathVariable Long albumId,
            @PathVariable Long artistId
    ) {
        albumService.unlinkArtist(albumId, artistId);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}/artists")
    public ResponseEntity<List<ArtistResponseDTO>> getArtistsForAlbum(
            @PathVariable Long id
    ) {
        List<ArtistResponseDTO> artists = artistService.getArtistsForAlbum(id);
        return ResponseEntity.ok(artists);
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponseDTO>> getAllAlbums(
            @RequestParam(required = false) Boolean stock
    ) {

        if (stock != null) {
            return ResponseEntity.ok(
                    albumService.getAlbumsWithStock(stock)
            );
        }

        return ResponseEntity.ok(
                albumService.getAllAlbums()
        );
    }

}
