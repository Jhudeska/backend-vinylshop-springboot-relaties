package nl.novi.backendvinylshopspringbootrelaties.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootrelaties.exceptions.RecordNotFoundException;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.GenreDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.repository.GenreEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreEntityService {

    private final GenreEntityRepository genreEntityRepository;
    private final GenreDTOMapper genreDTOMapper;

    public GenreEntityService(GenreEntityRepository genreRepository, GenreDTOMapper genreDTOMapper) {
        this.genreEntityRepository = genreRepository;
        this.genreDTOMapper = genreDTOMapper;
    }


    public List<GenreResponseDTO> findAllGenres() {
        return genreDTOMapper.mapToDto(genreEntityRepository.findAll());
    }


    public GenreResponseDTO findGenreById(Long id) throws EntityNotFoundException {
        GenreEntity genreEntity = getGenreEntity(id);
        return genreDTOMapper.mapToDto(genreEntity);
    }


    public GenreResponseDTO createGenre(GenreRequestDTO genreDTO) {
        GenreEntity genreEntity = genreDTOMapper.mapToEntity(genreDTO);
        genreEntity = genreEntityRepository.save(genreEntity);
        return genreDTOMapper.mapToDto(genreEntity);
    }


    public GenreResponseDTO updateGenre(Long id, GenreRequestDTO requestDto) throws EntityNotFoundException {
        GenreEntity existingGenreEntity = getGenreEntity(id);

        existingGenreEntity.setName(requestDto.getName());
        existingGenreEntity.setDescription(requestDto.getDescription());

        existingGenreEntity = genreEntityRepository.save(existingGenreEntity);
        return genreDTOMapper.mapToDto(existingGenreEntity);
    }

    private GenreEntity getGenreEntity(Long id) {
        GenreEntity existingGenreEntity = genreEntityRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Genre " + id + " not found"));
        return existingGenreEntity;
    }

    public void deleteGenre(Long id) {
        GenreEntity genreEntity = getGenreEntity(id);
        genreEntityRepository.delete(genreEntity);
    }

}