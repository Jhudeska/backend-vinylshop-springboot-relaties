package nl.novi.backendvinylshopspringbootrelaties.controllers;

import nl.novi.backendvinylshopspringbootrelaties.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootrelaties.services.ArtistService;
import nl.novi.backendvinylshopspringbootrelaties.services.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {

    private final ArtistService artistService;
    private final UrlHelper urlHelper;

    public ArtistController(ArtistService artistService, UrlHelper urlHelper) {
        this.artistService = artistService;
        this.urlHelper = urlHelper;
    }

}
