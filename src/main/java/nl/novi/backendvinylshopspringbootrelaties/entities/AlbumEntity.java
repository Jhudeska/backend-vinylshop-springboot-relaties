package nl.novi.backendvinylshopspringbootrelaties.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {

    // Erft id van BaseEntity
    private String title;
    private int releaseYear;

    @ManyToMany
    @JoinTable(
            name = "album_artists",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<ArtistEntity> artists;


    @OneToMany(mappedBy = "album")
    private List<StockEntity> stockItems;


    @ManyToOne
    private PublisherEntity publisher;

    //Unidirectional
    @ManyToOne
    private GenreEntity genre;



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

    public List<StockEntity> getStockItems() {
        return stockItems;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public void setStockItems(List<StockEntity> stockItems) {
        this.stockItems = stockItems;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

}
