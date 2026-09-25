package nl.novi.backendvinylshopspringbootmodellen.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers")
public class PublisherEntity extends BasisEntity  {

    @Column(name = "name",  nullable = false, length = 63)
    private String name;

    @Column(name = "address", nullable = true, length = 255)
    private String address;

    private String contactDetails;

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
}
