package br.edu.utf.project.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.utf.project.model.PropertyModel;
import br.edu.utf.project.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PropertyService {

	private final PropertyRepository propertyRepository;

	public List<PropertyModel> findAll() {
		return propertyRepository.findAll();
	}

	public Optional<PropertyModel> findById(UUID id) {
		return propertyRepository.findById(id);
	}

	public PropertyModel save(PropertyModel property) {
		return propertyRepository.save(property);
	}

	public boolean delete(UUID id) {
		if (!propertyRepository.existsById(id))
			return false;
		propertyRepository.deleteById(id);
		return true;
	}
}
