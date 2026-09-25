package nl.novi.backendvinylshopspringbootrepository.services;


import nl.novi.backendvinylshopspringbootrepository.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootrepository.repository.GenreEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreEntityService {

    private final GenreEntityRepository genreEntityRepository;

    public GenreEntityService(GenreEntityRepository genreRepository) {
        this.genreEntityRepository = genreRepository;
    }


    public List<GenreEntity> findAllGenres() {
        return genreEntityRepository.findAll();
    }


    public GenreEntity findGenreById(Long id) {
        return getGenreById(id);
    }


    public GenreEntity createGenre(GenreEntity input) {
        return genreEntityRepository.save(input);
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


