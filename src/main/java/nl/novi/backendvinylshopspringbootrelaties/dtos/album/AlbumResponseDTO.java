package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

import nl.novi.backendvinylshopspringbootrelaties.dtos.genre.GenreResponseDTO;
import nl.novi.backendvinylshopspringbootrelaties.dtos.publisher.PublisherResponseDTO;

public class AlbumResponseDTO {

    // DTO Response of album
    private Long id;
    private String title;
    private Integer releaseYear;

    private GenreResponseDTO genre;
    private PublisherResponseDTO publisher;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public GenreResponseDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreResponseDTO genre) {
        this.genre = genre;
    }

    public PublisherResponseDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherResponseDTO publisher) {
        this.publisher = publisher;
    }

}
