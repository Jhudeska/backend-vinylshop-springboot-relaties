package nl.novi.backendvinylshopspringbootrelaties.services;

import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.ArtistEntity;
import nl.novi.backendvinylshopspringbootrelaties.exceptions.RecordNotFoundException;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.ArtistDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistDTOMapper artistDTOMapper;

    public ArtistService(
            ArtistRepository artistRepository,
            ArtistDTOMapper artistDTOMapper
    ) {
        this.artistRepository = artistRepository;
        this.artistDTOMapper = artistDTOMapper;
    }

    public List<ArtistResponseDTO> findAllArtists() {
        return artistDTOMapper.mapToDto(
                artistRepository.findAll()
        );
    }

    public ArtistResponseDTO findArtistById(Long id) {
        ArtistEntity artist = getArtistEntity(id);

        return artistDTOMapper.mapToDto(artist);
    }

    public ArtistResponseDTO createArtist(
            ArtistRequestDTO artistRequestDTO
    ) {
        ArtistEntity artist =
                artistDTOMapper.mapToEntity(artistRequestDTO);

        artist = artistRepository.save(artist);

        return artistDTOMapper.mapToDto(artist);
    }

    public ArtistResponseDTO updateArtist(
            Long id,
            ArtistRequestDTO artistRequestDTO
    ) {
        ArtistEntity existingArtist = getArtistEntity(id);

        existingArtist.setName(artistRequestDTO.getName());
        existingArtist.setBiography(artistRequestDTO.getBiography());

        existingArtist = artistRepository.save(existingArtist);

        return artistDTOMapper.mapToDto(existingArtist);
    }

    public void deleteArtist(Long id) {
        ArtistEntity artist = getArtistEntity(id);

        artistRepository.delete(artist);
    }

    private ArtistEntity getArtistEntity(Long id) {

        return artistRepository.findById(id)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Artist " + id + " not found"
                        )
                );
    }

    public List<ArtistResponseDTO> getArtistsForAlbum(Long albumId) {

        List<ArtistEntity> artists =
                artistRepository.findArtistsByAlbumsId(albumId);

        return artistDTOMapper.mapToDto(artists);
    }

}