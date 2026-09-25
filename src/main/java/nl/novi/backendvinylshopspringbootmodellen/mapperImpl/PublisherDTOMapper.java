package nl.novi.backendvinylshopspringbootmodellen.mapperImpl;

import nl.novi.backendvinylshopspringbootmodellen.dtos.publisher.PublisherRequestDTO;
import nl.novi.backendvinylshopspringbootmodellen.dtos.publisher.PublisherResponseDTO;
import nl.novi.backendvinylshopspringbootmodellen.entities.BaseEntity;
import nl.novi.backendvinylshopspringbootmodellen.mapper.DTOMapper;
import org.springframework.stereotype.Component;
import nl.novi.backendvinylshopspringbootmodellen.entities.PublisherEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherDTOMapper implements DTOMapper<PublisherResponseDTO, PublisherRequestDTO, PublisherEntity> {

    @Override
    public PublisherResponseDTO mapToDto(PublisherEntity model) {
        PublisherResponseDTO dto = new PublisherResponseDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setAddress(model.getAddress());
        dto.setContactDetails(model.getContactDetails());
        return dto;
    }

    @Override
    public List<PublisherResponseDTO> mapToDto(List<PublisherEntity> publishers) {
        List<PublisherResponseDTO> result = new ArrayList<>();
        for (PublisherEntity publisher : publishers) {
            result.add(mapToDto(publisher));
        }
        return result;
    }

    @Override
    public PublisherEntity mapToEntity(PublisherRequestDTO dto) {
        PublisherEntity publisher = new PublisherEntity();
        publisher.setName(dto.getName());
        publisher.setAddress(dto.getAddress());
        publisher.setContactDetails(dto.getContactDetails());
        return publisher;
    }
}
