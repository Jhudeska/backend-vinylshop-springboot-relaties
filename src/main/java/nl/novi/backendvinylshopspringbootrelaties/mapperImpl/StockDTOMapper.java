package nl.novi.backendvinylshopspringbootrelaties.mapperImpl;

import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.StockEntity;
import nl.novi.backendvinylshopspringbootrelaties.mapper.DTOMapper;

import java.util.List;

public class StockDTOMapper implements DTOMapper<StockResponseDTO, StockRequestDTO, StockEntity> {

    @Override
    public StockResponseDTO mapToDto(StockEntity model) {
        StockResponseDTO dto = new StockResponseDTO();

        dto.setId(model.getId());
        dto.setCondition(model.getCondition());
        dto.setPrice(model.getPrice());

        return dto;
    }

    @Override
    public List<StockResponseDTO> mapToDto(List<StockEntity> models) {
        return models.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public StockEntity mapToEntity(StockRequestDTO dto) {
        StockEntity stock = new StockEntity();

        stock.setCondition(dto.getCondition());
        stock.setPrice(dto.getPrice());

        return stock;
    }
}
