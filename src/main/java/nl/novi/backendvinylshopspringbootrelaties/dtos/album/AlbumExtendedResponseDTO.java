package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import nl.novi.backendvinylshopspringbootrelaties.dtos.stock.StockResponseDTO;

import java.util.List;

@JsonPropertyOrder({
        "id",
        "title",
        "releaseYear",
        "genre",
        "publisher",
        "stock"
})
public class AlbumExtendedResponseDTO extends AlbumResponseDTO{
    private List<StockResponseDTO> stock;

    public List<StockResponseDTO> getStock() {
        return stock;
    }

    public void setStock(List<StockResponseDTO> stock) {
        this.stock = stock;
    }

}
