package nl.novi.backendvinylshopspringbootmodellen.repository;


import nl.novi.backendvinylshopspringbootmodellen.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {

}
