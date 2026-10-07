package nl.novi.backendvinylshopspringbootrelaties.controllers;

import jakarta.validation.Valid;
import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockRequestDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.helpers.UrlHelper;
import nl.novi.backendvinylshopspringbootrelaties.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums/{albumId}/stock")
public class StockController {
    private final StockService stockService;
    private final UrlHelper urlHelper;

    public StockController(
            StockService stockService,
            UrlHelper urlHelper
    ) {
        this.stockService = stockService;
        this.urlHelper = urlHelper;
    }

    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getAllStock(
            @PathVariable Long albumId
    ) {
        List<StockResponseDTO> stock = stockService.findAllStock(albumId);

        return ResponseEntity.ok(stock);
    }

    @GetMapping("/{stockId}")
    public ResponseEntity<StockResponseDTO> getStockById(
            @PathVariable Long albumId,
            @PathVariable Long stockId
    ) {
        StockResponseDTO stock = stockService.findStockById(albumId, stockId);

        return ResponseEntity.ok(stock);
    }

    @PostMapping
    public ResponseEntity<StockResponseDTO> createStock(
            @PathVariable Long albumId,
            @Valid @RequestBody StockRequestDTO stockRequestDTO
    ) {
        StockResponseDTO newStock =
                stockService.createStock(albumId, stockRequestDTO);

        return ResponseEntity
                .created(urlHelper.getCurrentUrlWithId(newStock.getId()))
                .body(newStock);
    }

    @PutMapping("/{stockId}")
    public ResponseEntity<StockResponseDTO> updateStock(
            @PathVariable Long albumId,
            @PathVariable Long stockId,
            @Valid @RequestBody StockRequestDTO stockRequestDTO
    ) {
        StockResponseDTO updatedStock =
                stockService.updateStock(
                        albumId,
                        stockId,
                        stockRequestDTO
                );

        return ResponseEntity.ok(updatedStock);
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<Void> deleteStock(
            @PathVariable Long albumId,
            @PathVariable Long stockId
    ) {
        stockService.deleteStock(albumId, stockId);

        return ResponseEntity.noContent().build();
    }

}
