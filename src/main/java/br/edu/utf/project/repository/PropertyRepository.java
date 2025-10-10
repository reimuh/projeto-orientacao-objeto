package br.edu.utf.project.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.utf.project.model.PropertyModel;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyModel, UUID> {
    List<PropertyModel> findByOwnerId(UUID ownerId);
    List<PropertyModel> findByAddressCityAndAddressState(String city, String state);
}
