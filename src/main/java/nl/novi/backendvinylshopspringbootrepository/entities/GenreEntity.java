package nl.novi.backendvinylshopspringbootrepository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres")
public class GenreEntity extends BasisEntity{

    @Column(name = "name",  nullable = false, length = 63)
    private String name;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
