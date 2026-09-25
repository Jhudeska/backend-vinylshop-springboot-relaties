package nl.novi.backendvinylshopspringbootrelaties.repository;


import nl.novi.backendvinylshopspringbootrelaties.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreEntityRepository extends JpaRepository<GenreEntity, Long> {
}
