package nl.novi.backendvinylshopspringbootrepository.repository;


import nl.novi.backendvinylshopspringbootrepository.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {

}
