package nl.novi.backendvinylshopspringbootrelaties.mapperImpl;

import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.AlbumEntity;
import nl.novi.backendvinylshopspringbootrelaties.entities.GenreEntity;
import nl.novi.backendvinylshopspringbootrelaties.mapper.DTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumDTOMapper implements DTOMapper<AlbumResponseDTO, AlbumRequestDTO, AlbumEntity> {
    @Override
    public AlbumResponseDTO mapToDto(AlbumEntity model) {
        AlbumResponseDTO dto = new AlbumResponseDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        return dto;
    }

    @Override
    public List<AlbumResponseDTO> mapToDto(List<AlbumEntity> models) {
        return models.stream()
                .map(this::mapToDto)
                .toList();
    }


    @Override
    public AlbumEntity mapToEntity(AlbumRequestDTO dto) {
        AlbumEntity album = new AlbumEntity();

        album.setTitle(dto.getTitle());
        album.setReleaseYear(dto.getReleaseYear());

        return album;
    }
}
