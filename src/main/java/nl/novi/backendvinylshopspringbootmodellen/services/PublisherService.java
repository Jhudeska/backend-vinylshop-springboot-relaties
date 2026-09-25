package nl.novi.backendvinylshopspringbootmodellen.services;


import nl.novi.backendvinylshopspringbootmodellen.dtos.publisher.PublisherRequestDTO;
import nl.novi.backendvinylshopspringbootmodellen.dtos.publisher.PublisherResponseDTO;
import nl.novi.backendvinylshopspringbootmodellen.entities.PublisherEntity;
import nl.novi.backendvinylshopspringbootmodellen.exceptions.RecordNotFoundException;
import nl.novi.backendvinylshopspringbootmodellen.mapperImpl.PublisherDTOMapper;
import nl.novi.backendvinylshopspringbootmodellen.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherDTOMapper publisherDtoMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherDTOMapper publisherDtoMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherDtoMapper = publisherDtoMapper;
    }

    public List<PublisherResponseDTO> findAllPublishers() {
        return publisherDtoMapper.mapToDto(publisherRepository.findAll());
    }

    public PublisherResponseDTO findPublisherById(Long id) throws RecordNotFoundException {
        PublisherEntity publisherEntity = getPublisherEntity(id);
        return publisherDtoMapper.mapToDto(publisherEntity);
    }

    public PublisherResponseDTO createPublisher(PublisherRequestDTO publisherDTO) {
        PublisherEntity publisherEntity = publisherDtoMapper.mapToEntity(publisherDTO);
        publisherEntity = publisherRepository.save(publisherEntity);
        return publisherDtoMapper.mapToDto(publisherEntity);
    }

    public PublisherResponseDTO updatePublisher(Long id, PublisherRequestDTO publisherModel) throws RecordNotFoundException {
        PublisherEntity existingPublisherEntity = getPublisherEntity(id);

        existingPublisherEntity.setName(publisherModel.getName());
        existingPublisherEntity.setAddress(publisherModel.getAddress());
        existingPublisherEntity.setContactDetails(publisherModel.getContactDetails());

        existingPublisherEntity = publisherRepository.save(existingPublisherEntity);
        return publisherDtoMapper.mapToDto(existingPublisherEntity);
    }


    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    private PublisherEntity getPublisherById(Long id){
        Optional<PublisherEntity> publisherEntityOptional = publisherRepository.findById(id);

//        De Optional.orElse() methode haalt de waarde uit de optional, of anders... Dit is één variant om met de Optional om te gaan.
        return publisherEntityOptional.orElse(null);
    }

    //    Deze helper methode haalt de Entity uit de Repository en valideert het. Deze actie werd op meerdere plekken gedaan, daarom is er een helper methode voor gemaakt.
    private PublisherEntity getPublisherEntity(Long id) {
        PublisherEntity publisherEntity = publisherRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Publisher " + id +" not found"));
        return publisherEntity;
    }
}
