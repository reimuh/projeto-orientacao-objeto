package br.edu.utf.project.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.utf.project.model.AddressModel;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, UUID> {
}
