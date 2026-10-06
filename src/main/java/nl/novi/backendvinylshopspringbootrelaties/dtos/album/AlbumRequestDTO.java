package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

import jakarta.validation.constraints.*;

public class AlbumRequestDTO {
    @NotBlank(message = "Titel mag niet  leeg zijn")
    @Size(min = 3, max = 100, message = "Titel moet tussen 3 en 100 karakters lang zijn")
    private String title;

    @NotNull(message = "Releasejaar is verplicht")
    @Min(value = 1877, message = "Releasejaar moet minimaal 1877 zijn")
    @Max(value = 2100, message = "Releasejaar mag maximaal 2100")
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
