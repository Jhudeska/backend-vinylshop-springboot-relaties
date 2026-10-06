package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockResponseDTO;

import java.util.List;

public class AlbumExtendedResponseDTO extends AlbumResponseDTO{
    private List<StockResponseDTO> stock;

    public List<StockResponseDTO> getStock() {
        return stock;
    }

    public void setStock(List<StockResponseDTO> stock) {
        this.stock = stock;
    }

}
