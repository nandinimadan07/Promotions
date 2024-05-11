package Repository;
// ServiceRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service save(Service service);

    default void deleteById(Long serviceId) {

    }
}

