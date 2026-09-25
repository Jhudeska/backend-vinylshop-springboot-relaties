package nl.novi.backendvinylshopspringbootmodellen.repository;


import nl.novi.backendvinylshopspringbootmodellen.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreEntityRepository extends JpaRepository<GenreEntity, Long> {
}
