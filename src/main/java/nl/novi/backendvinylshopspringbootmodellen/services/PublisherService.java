package nl.novi.backendvinylshopspringbootrepository.services;


import nl.novi.backendvinylshopspringbootrepository.entities.PublisherEntity;
import nl.novi.backendvinylshopspringbootrepository.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherEntity> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public PublisherEntity findPublisherById(Long id) {
        return getPublisherById(id);
    }

    public PublisherEntity createPublisher(PublisherEntity inputPublisher) {
        return publisherRepository.save(inputPublisher);
    }

    public PublisherEntity updatePublisher(Long id, PublisherEntity input) {
        PublisherEntity publisherEntity = getPublisherById(id);
        if(publisherEntity != null){
            publisherEntity.setAddress(input.getAddress());
            publisherEntity.setName(input.getName());
            publisherEntity.setContactDetails(input.getContactDetails());
            return publisherRepository.save(publisherEntity);
        }
        return null;
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    private PublisherEntity getPublisherById(Long id){
        Optional<PublisherEntity> publisherEntityOptional = publisherRepository.findById(id);

//        De Optional.orElse() methode haalt de waarde uit de optional, of anders... Dit is één variant om met de Optional om te gaan.
        return publisherEntityOptional.orElse(null);
    }
}
