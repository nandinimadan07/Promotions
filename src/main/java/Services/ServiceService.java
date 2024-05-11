package Services;
// ServiceService.java

import Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    public Service updateService(Long serviceId, Service service) {
        service.setId(serviceId); // Ensure ID consistency
        return serviceRepository.save(service);
    }
}

