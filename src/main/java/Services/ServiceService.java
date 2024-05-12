// ServiceService.java

package Services;

import Models.Service;
import Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import Exception.ResourceNotFoundException;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    public Service updateService(Long serviceId, Service newService) {
        Optional<Service> optionalExistingService = serviceRepository.findById(serviceId);
        if (optionalExistingService.isPresent()) {
            Service existingService = (Service) optionalExistingService.get();
            existingService.setName(newService.getName());
            existingService.setDescription(newService.getDescription());
            existingService.setPrice(newService.getPrice());
            // Set other attributes as needed
            return serviceRepository.save(existingService);
        } else {
            throw new ResourceNotFoundException("Service not found with id: " + serviceId);
        }
    }
}
