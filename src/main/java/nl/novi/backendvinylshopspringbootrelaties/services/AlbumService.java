package nl.novi.backendvinylshopspringbootrelaties.services;

import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumExtendedResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.AlbumDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.repository.AlbumRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.ArtistRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.GenreEntityRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final AlbumDTOMapper albumDTOMapper;
    private final PublisherRepository publisherRepository;
    private final GenreEntityRepository genreRepository;

    public AlbumService(
            AlbumRepository albumRepository,
            ArtistRepository artistRepository,
            AlbumDTOMapper albumDTOMapper,
            PublisherRepository publisherRepository,
            GenreEntityRepository genreRepository
    ) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.albumDTOMapper = albumDTOMapper;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
    }
}
