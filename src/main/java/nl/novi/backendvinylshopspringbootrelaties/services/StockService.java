package nl.novi.backendvinylshopspringbootrelaties.services;

import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.entities.AlbumEntity;
import nl.novi.backendvinylshopspringbootrelaties.entities.StockEntity;
import nl.novi.backendvinylshopspringbootrelaties.exceptions.RecordNotFoundException;
import nl.novi.backendvinylshopspringbootrelaties.mapperImpl.StockDTOMapper;
import nl.novi.backendvinylshopspringbootrelaties.repository.AlbumRepository;
import nl.novi.backendvinylshopspringbootrelaties.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockDTOMapper stockDTOMapper;
    private final AlbumRepository albumRepository;

    public StockService(
            StockRepository stockRepository,
            StockDTOMapper stockDTOMapper,
            AlbumRepository albumRepository
    ) {
        this.stockRepository = stockRepository;
        this.stockDTOMapper = stockDTOMapper;
        this.albumRepository = albumRepository;
    }

    public List<StockResponseDTO> findAllStock(Long albumId) {

        getAlbumEntity(albumId);

        List<StockEntity> stock = stockRepository.findByAlbumId(albumId);

        return stockDTOMapper.mapToDto(stock);
    }

    public StockResponseDTO findStockById(Long albumId, Long stockId) {

        getAlbumEntity(albumId);

        StockEntity stock = stockRepository
                .findByIdAndAlbumId(stockId, albumId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Stock " + stockId + " niet gevonden voor album " + albumId
                        )
                );

        return stockDTOMapper.mapToDto(stock);
    }

    public StockResponseDTO createStock(
            Long albumId,
            StockRequestDTO stockRequestDTO
    ) {

        AlbumEntity album = getAlbumEntity(albumId);

        StockEntity stock = stockDTOMapper.mapToEntity(stockRequestDTO);

        stock.setAlbum(album);

        stock = stockRepository.save(stock);

        return stockDTOMapper.mapToDto(stock);
    }

    public StockResponseDTO updateStock(
            Long albumId,
            Long stockId,
            StockRequestDTO stockRequestDTO
    ) {

        getAlbumEntity(albumId);

        StockEntity existingStock = stockRepository
                .findByIdAndAlbumId(stockId, albumId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Stock " + stockId + " niet gevonden voor album " + albumId
                        )
                );

        existingStock.setCondition(stockRequestDTO.getCondition());
        existingStock.setPrice(stockRequestDTO.getPrice());

        existingStock = stockRepository.save(existingStock);

        return stockDTOMapper.mapToDto(existingStock);
    }

    public void deleteStock(Long albumId, Long stockId) {

        getAlbumEntity(albumId);

        StockEntity stock = stockRepository
                .findByIdAndAlbumId(stockId, albumId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Stock " + stockId + " niet gevonden voor album " + albumId
                        )
                );

        stockRepository.delete(stock);
    }

    private AlbumEntity getAlbumEntity(Long albumId) {

        return albumRepository.findById(albumId)
                .orElseThrow(() ->
                        new RecordNotFoundException(
                                "Album " + albumId + " not found"
                        )
                );
    }
}