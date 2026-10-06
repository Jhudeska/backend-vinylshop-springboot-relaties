package nl.novi.backendvinylshopspringbootrelaties.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "publishers")
public class PublisherEntity extends BaseEntity {

    @Column(name = "name",  nullable = false, length = 63)
    private String name;

    @Column(name = "address", nullable = true, length = 255)
    private String address;

    private String contactDetails;

    @OneToMany(mappedBy = "publisher")
    private List<AlbumEntity> albums;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {}

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }
}
