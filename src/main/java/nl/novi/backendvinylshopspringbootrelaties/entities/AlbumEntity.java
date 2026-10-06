package nl.novi.backendvinylshopspringbootrelaties.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {
    private String title;
    private int releaseYear;

    @ManyToMany
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<ArtistEntity> artists;


    @OneToMany(mappedBy = "album")
    private List<StockEntity> stock;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<ArtistEntity> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistEntity> artists) {
        this.artists = artists;
    }

    public List<StockEntity> getStock() {
        return stock;
    }

    public void setStock(List<StockEntity> stock) {
        this.stock = stock;
    }
}
