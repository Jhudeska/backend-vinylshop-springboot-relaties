package nl.novi.backendvinylshopspringbootrelaties.repository;

import nl.novi.backendvinylshopspringbootrelaties.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
