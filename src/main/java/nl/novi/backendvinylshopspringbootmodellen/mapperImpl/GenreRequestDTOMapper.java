package nl.novi.backendvinylshopspringbootmodellen.mapperImpl;

import nl.novi.backendvinylshopspringbootmodellen.dtos.genre.GenreRequestDTO;
import nl.novi.backendvinylshopspringbootmodellen.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootmodellen.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootmodellen.mapper.DTOMapper;

import java.util.ArrayList;
import java.util.List;

public class GenreRequestDTOMapper implements DTOMapper<GenreResponseDTO, GenreRequestDTO, GenreEntity> {
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
