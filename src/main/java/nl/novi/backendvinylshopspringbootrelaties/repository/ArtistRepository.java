package nl.novi.backendvinylshopspringbootrelaties.repository;

import nl.novi.backendvinylshopspringbootrelaties.entities.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity,Long> {
}
