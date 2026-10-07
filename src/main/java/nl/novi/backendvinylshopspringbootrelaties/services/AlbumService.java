package nl.novi.backendvinylshopspringbootrelaties.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumExtendedResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.AlbumEntity;
import nl.novi.backendvinylshopspringbootrelaties.entities.ArtistEntity;
import nl.novi.backendvinylshopspringbootrelaties.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootrelaties.entities.PublisherEntity;
import nl.novi.backendvinylshopspringbootrelaties.exceptions.RecordNotFoundException;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.AlbumDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.AlbumExtendedDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.repository.AlbumRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.ArtistRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.GenreEntityRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumRequestDTO;


import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final AlbumDTOMapper albumDTOMapper;
    private final AlbumExtendedDTOMapper albumExtendedDTOMapper;
    private final PublisherRepository publisherRepository;
    private final GenreEntityRepository genreRepository;

    public AlbumService(
            AlbumRepository albumRepository,
            ArtistRepository artistRepository,
            AlbumDTOMapper albumDTOMapper,
            AlbumExtendedDTOMapper albumExtendedDTOMapper,
            PublisherRepository publisherRepository,
            GenreEntityRepository genreRepository
    ) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.albumDTOMapper = albumDTOMapper;
        this.albumExtendedDTOMapper = albumExtendedDTOMapper;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
    }

    public List<AlbumResponseDTO> getAllAlbums() {
        List<AlbumEntity> albums = albumRepository.findAll();
        return albumDTOMapper.mapToDto(albums);
    }

    public AlbumExtendedResponseDTO getAlbumById(Long id) {
        AlbumEntity album = albumRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Album not found"));
        return albumExtendedDTOMapper.mapToDto(album);
    }

    public AlbumResponseDTO createAlbum(AlbumRequestDTO albumDTO) {

        AlbumEntity albumEntity = albumDTOMapper.mapToEntity(albumDTO);

        if (albumDTO.getGenreId() != null) {
            GenreEntity genre = genreRepository.findById(albumDTO.getGenreId())
                    .orElseThrow(() ->
                            new EntityNotFoundException(
                                    "Genre " + albumDTO.getGenreId() + " not found"
                            )
                    );

            albumEntity.setGenre(genre);
        }

        if (albumDTO.getPublisherId() != null) {
            PublisherEntity publisher = publisherRepository.findById(albumDTO.getPublisherId())
                    .orElseThrow(() ->
                            new EntityNotFoundException(
                                    "Publisher " + albumDTO.getPublisherId() + " not found"
                            )
                    );

            albumEntity.setPublisher(publisher);
        }

        albumEntity = albumRepository.save(albumEntity);

        return albumDTOMapper.mapToDto(albumEntity);
    }

    public AlbumResponseDTO updateAlbum(Long id, AlbumRequestDTO dto) {

        AlbumEntity album = albumRepository.findById(id)
                .orElseThrow(() ->
                        new RecordNotFoundException("Album " + id + " not found")
                );

        album.setTitle(dto.getTitle());
        album.setReleaseYear(dto.getReleaseYear());

        GenreEntity genre = genreRepository.findById(dto.getGenreId())
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Genre " + dto.getGenreId() + " not found"
                        )
                );

        album.setGenre(genre);

        PublisherEntity publisher = publisherRepository.findById(dto.getPublisherId())
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Publisher " + dto.getPublisherId() + " not found"
                        )
                );

        album.setPublisher(publisher);

        AlbumEntity savedAlbum = albumRepository.save(album);

        return albumDTOMapper.mapToDto(savedAlbum);
    }


    public void deleteAlbum(Long id) {

        AlbumEntity album = albumRepository.findById(id)
                .orElseThrow(() ->
                        new RecordNotFoundException("Album " + id + " not found")
                );

        if (album.getStockItems() != null && !album.getStockItems().isEmpty()) {
            throw new IllegalStateException(
                    "Album kan niet verwijderd worden omdat er nog stock aanwezig is"
            );
        }

        albumRepository.delete(album);
    }


    public void linkArtist(Long albumId, Long artistId) {

        AlbumEntity album = albumRepository.findById(albumId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Album " + albumId + " not found"
                        )
                );

        ArtistEntity artist = artistRepository.findById(artistId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Artist " + artistId + " not found"
                        )
                );

        album.getArtists().add(artist);

        albumRepository.save(album);
    }

    public void unlinkArtist(Long albumId, Long artistId) {

        AlbumEntity album = albumRepository.findById(albumId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Album " + albumId + " not found"
                        )
                );

        ArtistEntity artist = artistRepository.findById(artistId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Artist " + artistId + " not found"
                        )
                );

        album.getArtists().remove(artist);

        albumRepository.save(album);
    }


    public List<AlbumResponseDTO> getAlbumsWithStock(Boolean stock) {

        List<AlbumEntity> albums;

        if (stock) {
            albums = albumRepository.findByStockItemsNotEmpty();
        } else {
            albums = albumRepository.findByStockItemsEmpty();
        }

        return albumDTOMapper.mapToDto(albums);
    }

}
