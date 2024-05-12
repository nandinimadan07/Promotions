package com.example.Project_Promotion.Controllers;

import com.example.Project_Promotion.dtos.ServiceRequestDTO;
import com.example.Project_Promotion.dtos.ServiceResponseDTO;
import com.example.Project_Promotion.Models.Service;
import com.example.Project_Promotion.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceResponseDTO> addService(@RequestBody ServiceRequestDTO serviceRequestDTO) {
        Service service = new Service(serviceRequestDTO.getName(), serviceRequestDTO.getDescription(), serviceRequestDTO.getPrice());
        Service addedService = serviceService.addService(service);
        ServiceResponseDTO responseDTO = new ServiceResponseDTO(addedService.getId(), addedService.getName(), addedService.getDescription(), addedService.getPrice());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        serviceService.deleteService(serviceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceResponseDTO> updateService(@PathVariable Long serviceId, @RequestBody ServiceRequestDTO serviceRequestDTO) {
        Service service = new Service(serviceRequestDTO.getName(), serviceRequestDTO.getDescription(), serviceRequestDTO.getPrice());
        ServiceResponseDTO updatedService = serviceService.updateService(serviceId, service);
        ServiceResponseDTO responseDTO = new ServiceResponseDTO(updatedService.getId(), updatedService.getName(), updatedService.getDescription(), updatedService.getPrice());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
