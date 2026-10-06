package nl.novi.backendvinylshopspringbootrelaties.controllers;

import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootrelaties.services.AlbumService;
import nl.novi.backendvinylshopspringbootrelaties.services.ArtistService;
import nl.novi.backendvinylshopspringbootrelaties.services.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping
//    public ResponseEntity<List<AlbumResponseDTO>> getAllAlbums(){
////        List<AlbumResponseDTO> albums = albumService.
//    }

}
