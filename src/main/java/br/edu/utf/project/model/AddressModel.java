package br.edu.utf.project.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 20)
    private String zipCode;
    
    @Column(nullable = false, length = 100)
    private String country;
    
    @Column(nullable = false, length = 100)
    private String state;
    
    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(length = 20, nullable = true)
    private String number;

    @Column(length = 255, nullable = true)
    private String complement;

    @Column(nullable = false)
    @Builder.Default()
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(nullable = false)
    @Builder.Default()
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
