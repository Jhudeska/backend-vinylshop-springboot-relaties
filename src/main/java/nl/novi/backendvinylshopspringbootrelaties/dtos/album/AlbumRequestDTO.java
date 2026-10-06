package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

import jakarta.validation.constraints.*;

public class AlbumRequestDTO {
    @NotBlank(message = "Titel mag niet  leeg zijn")
    @Size(min = 2, max = 100, message = "Titel moet tussen 2 en 100 karakters lang zijn")
    private String title;

    @Min(1877)
    @Max(2100)
    private int releaseYear;

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
}
