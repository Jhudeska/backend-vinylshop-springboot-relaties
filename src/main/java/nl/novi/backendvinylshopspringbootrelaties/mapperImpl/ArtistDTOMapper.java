package nl.novi.backendvinylshopspringbootrelaties.mapperImpl;
import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.artist.ArtistResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.ArtistEntity;
import nl.novi.backendvinylshopspringbootrelaties.mapper.DTOMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtistDTOMapper
        implements DTOMapper<ArtistResponseDTO, ArtistRequestDTO, ArtistEntity> {

    @Override
    public ArtistResponseDTO mapToDto(ArtistEntity model) {

        ArtistResponseDTO dto = new ArtistResponseDTO();

        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setBiography(model.getBiography());

        return dto;
    }

    @Override
    public List<ArtistResponseDTO> mapToDto(List<ArtistEntity> models) {

        List<ArtistResponseDTO> result = new ArrayList<>();

        for (ArtistEntity model : models) {
            result.add(mapToDto(model));
        }

        return result;
    }

    @Override
    public ArtistEntity mapToEntity(ArtistRequestDTO dto) {

        ArtistEntity artist = new ArtistEntity();

        artist.setName(dto.getName());
        artist.setBiography(dto.getBiography());

        return artist;
    }
}