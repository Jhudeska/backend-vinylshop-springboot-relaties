package nl.novi.backendvinylshopspringbootrelaties.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class StockEntity extends BaseEntity {

    private String condition;
    private double price;

    @ManyToOne
    private AlbumEntity album;


    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }
}
