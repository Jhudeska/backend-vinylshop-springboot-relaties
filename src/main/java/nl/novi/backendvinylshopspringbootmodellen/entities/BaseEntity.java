package nl.novi.backendvinylshopspringbootmodellen.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at" , updatable = false)
    private LocalDateTime createDate;

    @Column(name = "updated_at")
    private LocalDateTime editDate;

    @PrePersist
    protected void onCreate() {
         createDate = LocalDateTime.now();
        editDate = createDate;
    }

    @PreUpdate
    protected void onUpdate() {
        editDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getCreatedAt() {
        return createDate;
    }
    public LocalDateTime getUpdatedAt() {
        return editDate;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.editDate = updatedAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createDate = createdAt;
    }
}
