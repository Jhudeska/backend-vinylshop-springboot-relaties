package nl.novi.backendvinylshopspringbootrelaties.mapperImpl;

import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootrelaties.mapper.DTOMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreDTOMapper implements DTOMapper<GenreResponseDTO, GenreRequestDTO, GenreEntity> {
    @Override
    public GenreResponseDTO mapToDto(GenreEntity model) {
        var result = new GenreResponseDTO();
        result.setId(model.getId());
        result.setDescription(model.getDescription());
        result.setName(model.getName());
        return result;
    }

    @Override
    public List<GenreResponseDTO> mapToDto(List<GenreEntity> models) {
        var result = new ArrayList<GenreResponseDTO>();
        for (GenreEntity model : models) {
            result.add(mapToDto(model));
        }
        return result;
    }

    @Override
    public GenreEntity mapToEntity(GenreRequestDTO dto) {
        var result = new GenreEntity();
        result.setName(dto.getName());
        result.setDescription(dto.getDescription());
        return result;
    }
}
