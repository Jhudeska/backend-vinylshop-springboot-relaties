package nl.novi.backendvinylshopspringbootrelaties.repository;

import nl.novi.backendvinylshopspringbootrelaties.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
