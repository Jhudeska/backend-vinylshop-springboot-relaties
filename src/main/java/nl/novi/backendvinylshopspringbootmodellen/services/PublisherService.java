package nl.novi.backendvinylshopspringbootmodellen.services;


import nl.novi.backendvinylshopspringbootmodellen.dtos.publisher.PublisherRequestDTO;
import nl.novi.backendvinylshopspringbootmodellen.dtos.publisher.PublisherResponseDTO;
import nl.novi.backendvinylshopspringbootmodellen.entities.PublisherEntity;
import nl.novi.backendvinylshopspringbootmodellen.mapperImpl.GenreDTOMapper;
import nl.novi.backendvinylshopspringbootmodellen.mapperImpl.PublisherDTOMapper;
import nl.novi.backendvinylshopspringbootmodellen.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherDTOMapper publisherDTOMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherDTOMapper publisherDTOMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherDTOMapper = publisherDTOMapper;
    }

    public List<PublisherEntity> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public PublisherEntity findPublisherById(Long id) {
        return getPublisherById(id);
    }

    public PublisherResponseDTO createPublisher(PublisherRequestDTO publisherDTO) {
        PublisherEntity publisherEntity = publisherDTOMapper.mapToEntity(publisherDTO);
        publisherEntity = publisherRepository.save(publisherEntity);
        return publisherDTOMapper.mapToDto(publisherEntity);
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
