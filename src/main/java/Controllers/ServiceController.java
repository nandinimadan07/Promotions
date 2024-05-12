package Controllers;
// ServiceController.java

import Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        Service addedService = (Service) serviceService.addService((Models.Service) service);
        return new ResponseEntity<>(addedService, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        serviceService.deleteService(serviceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<Service> updateService(@PathVariable Long serviceId, @RequestBody Service service) {
        Service updatedService = (Service) serviceService.updateService(serviceId, (Models.Service) service);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }
}
