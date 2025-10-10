package br.edu.utf.project.model;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

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
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false, updatable = true)
	private LocalDateTime updatedAt;
}
