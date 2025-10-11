package br.edu.utf.project.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utf.project.model.UserModel;
import br.edu.utf.project.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserModel> getAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getById(@PathVariable UUID id) {
		return userService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
		return ResponseEntity.ok(userService.save(user));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserModel> update(@PathVariable UUID id, @RequestBody UserModel user) {
		return userService.update(id, user)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		boolean deleted = userService.delete(id);

		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
