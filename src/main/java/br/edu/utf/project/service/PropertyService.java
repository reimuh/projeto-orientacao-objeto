// RF09 - atualizar os dados

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

//////
	public Optional<PropertyModel> update(UUID id, PropertyModel propertyDetails) {
        return propertyRepository.findById(id).map(existingProperty -> {
            existingProperty.setTitle(propertyDetails.getTitle());
            existingProperty.setDescription(propertyDetails.getDescription());
            existingProperty.setDailyRate(propertyDetails.getDailyRate());
            existingProperty.setType(propertyDetails.getType());
            existingProperty.setStatus(propertyDetails.getStatus());

            return propertyRepository.save(existingProperty);
        });
    }


	public boolean delete(UUID id) {

	public boolean delete(UUID id) {
		if (!propertyRepository.existsById(id))
			return false;
		propertyRepository.deleteById(id);
		return true;
	}
}

}
