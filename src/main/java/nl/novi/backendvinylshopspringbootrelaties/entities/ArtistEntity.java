package nl.novi.backendvinylshopspringbootrelaties.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {
    private String name;
    private String biography;

    @ManyToMany(mappedBy = "artists")
    private List<ArtistEntity> artists;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }


}