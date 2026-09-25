package nl.novi.backendvinylshopspringbootrelaties.dtos.album;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AlbumRequestDTO {
    @NotBlank(message = "Titel mag niet  leeg zijn")
    @Size(min = 2, max = 100, message = "Titel moet tussen 2 en 100 karakters lang zijn")
    private String title;

    @Past
    @NotBlank
    @Pattern(
            regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Datum moet het formaat yyyy-MM-dd hebben"
    )
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
    public void setReleaseYear(int releaseYear) {}
}
