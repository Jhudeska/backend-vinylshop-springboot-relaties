package nl.novi.backendvinylshopspringbootrelaties.mapperImpl;

import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumExtendedResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.album.AlbumResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.AlbumEntity;
import org.springframework.stereotype.Component;

@Component
public class AlbumExtendedDTOMapper extends AlbumDTOMapper {
    private final StockDTOMapper stockDTOMapper;

    public AlbumExtendedDTOMapper(
            GenreDTOMapper genreDTOMapper,
            PublisherDTOMapper publisherDTOMapper,
            StockDTOMapper stockDTOMapper
    ) {
        super(genreDTOMapper, publisherDTOMapper);
        this.stockDTOMapper = stockDTOMapper;
    }

    @Override
    public AlbumExtendedResponseDTO mapToDto(AlbumEntity model) {

        AlbumResponseDTO baseDto = super.mapToDto(model);

        AlbumExtendedResponseDTO result = new AlbumExtendedResponseDTO();

        result.setId(baseDto.getId());
        result.setTitle(baseDto.getTitle());
        result.setReleaseYear(baseDto.getReleaseYear());
        result.setGenre(baseDto.getGenre());
        result.setPublisher(baseDto.getPublisher());

        if (model.getStockItems() != null) {
            result.setStock(
                    stockDTOMapper.mapToDto(model.getStockItems())
            );
        }

        return result;
    }
}
