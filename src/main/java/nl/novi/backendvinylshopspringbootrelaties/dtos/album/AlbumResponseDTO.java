package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

public class AlbumResponseDTO {

    // DTO Response of album
    private Long id;
    private String title;
    private int releaseYear;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {}
}
