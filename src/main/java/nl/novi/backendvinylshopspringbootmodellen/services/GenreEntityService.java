package nl.novi.backendvinylshopspringbootmodellen.services;


import nl.novi.backendvinylshopspringbootmodellen.dtos.genre.GenreRequestDTO;
import nl.novi.backendvinylshopspringbootmodellen.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootmodellen.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootmodellen.mapperImpl.GenreDTOMapper;
import nl.novi.backendvinylshopspringbootmodellen.repository.GenreEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .orElseThrow(() -> new RecordNotFoundException("Genre " + id +" not found"));
        return existingGenreEntity;
    }

    public void deleteGenre(Long id) {
        genreEntityRepository.deleteById(id);
    }

    private GenreEntity getGenreById(Long id){
        Optional<GenreEntity> genreEntityOptional = genreEntityRepository.findById(id);

//        Een if-statement waar je expliciet de Optional.isPresent() of Optional.isEmpty() checkt, is één variant om met de optional om te gaan.
        if(genreEntityOptional.isPresent()){
            return genreEntityOptional.get();
        } else {
            throw new RecordNotFoundException("Genre " + id +" not found");
        }
    }

}


