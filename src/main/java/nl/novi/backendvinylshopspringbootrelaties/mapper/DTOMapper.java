package nl.novi.backendvinylshopspringbootrelaties.mapper;

import java.util.List;
import nl.novi.backendvinylshopspringbootrelaties.entities.BaseEntity;

public interface DTOMapper<RESPONSE, REQUEST , T extends BaseEntity> {
    RESPONSE mapToDto(T model);

    List<RESPONSE> mapToDto(List<T> models);

    T mapToEntity(REQUEST dto);
}
