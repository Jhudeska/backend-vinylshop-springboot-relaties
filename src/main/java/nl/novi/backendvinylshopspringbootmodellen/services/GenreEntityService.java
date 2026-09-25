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


    public List<GenreEntity> findAllGenres() {
        return genreEntityRepository.findAll();
    }


    public GenreEntity findGenreById(Long id) {
        return getGenreById(id);
    }


public GenreResponseDTO createGenre(GenreRequestDTO genreDTO) {
        GenreEntity genreEntity = genreDTOMapper.mapToEntity(genreDTO);
        genreEntity = genreEntityRepository.save(genreEntity);
        return genreDTOMapper.mapToDto(genreEntity);
    }


    public GenreEntity updateGenre(Long id, GenreEntity input) {
        GenreEntity genre = getGenreById(id);
        if(genre != null) {
            genre.setDescription(input.getDescription());
            genre.setName(input.getName());
            return genreEntityRepository.save(genre);
        }

        return null;
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
            return null;
        }
    }

}


