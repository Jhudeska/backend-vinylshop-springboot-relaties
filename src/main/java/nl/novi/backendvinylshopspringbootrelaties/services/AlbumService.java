package nl.novi.backendvinylshopspringbootrelaties.services;

import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumExtendedResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.AlbumEntity;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.AlbumDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.repository.AlbumRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.ArtistRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.GenreEntityRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<AlbumResponseDTO> getAllAlbums() {
        List<AlbumEntity> albums = albumRepository.findAll();
        return albumDTOMapper.mapToDto(albums);
    }

    public AlbumResponseDTO getAlbumById(Long id) {
        AlbumEntity album = albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
        return albumDTOMapper.mapToDto(album);
    }


}
