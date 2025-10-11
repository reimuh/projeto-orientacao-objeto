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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, length = 255)
	private String name;

	@Column(nullable = false, length = 255)
	private String password;

	@Column(nullable = false, unique = true, length = 255)
	private String email;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Builder.Default()
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "updated_at", nullable = false, updatable = true)
	@Builder.Default()
	private LocalDateTime updatedAt = LocalDateTime.now();

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
