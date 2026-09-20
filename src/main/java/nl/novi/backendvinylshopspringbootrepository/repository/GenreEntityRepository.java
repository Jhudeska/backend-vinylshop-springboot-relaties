package nl.novi.backendvinylshopspringbootrepository.repository;


import nl.novi.backendvinylshopspringbootrepository.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreEntityRepository extends JpaRepository<GenreEntity, Long> {
}
