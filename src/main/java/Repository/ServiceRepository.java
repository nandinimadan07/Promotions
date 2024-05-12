package Repository;

import Models.Service; // Import the Service class from your Models package
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Optional<Service> findById(Long id);

    void deleteById(Long serviceId);

    Service save(Service existingService);
}
