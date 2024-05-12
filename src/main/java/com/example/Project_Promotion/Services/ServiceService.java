package com.example.Project_Promotion.Services;

import com.example.Project_Promotion.Models.Service;
import com.example.Project_Promotion.Repository.ServiceRepository;
import com.example.Project_Promotion.dtos.ServiceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Project_Promotion.Exception.ResourceNotFoundException;

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

    public ServiceResponseDTO updateService(Long serviceId, Service newService) {
        Optional<Service> optionalExistingService = serviceRepository.findById(serviceId);
        if (optionalExistingService.isPresent()) {
            Service existingService = optionalExistingService.get();
            existingService.setName(newService.getName());
            existingService.setDescription(newService.getDescription());
            existingService.setPrice(newService.getPrice());
            // Set other attributes as needed
            Service updatedService = serviceRepository.save(existingService);
            return new ServiceResponseDTO(updatedService.getId(), updatedService.getName(), updatedService.getDescription(), updatedService.getPrice());
        } else {
            throw new ResourceNotFoundException("Service not found with id: " + serviceId);
        }
    }
}
