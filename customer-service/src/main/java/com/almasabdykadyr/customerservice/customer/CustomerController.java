package com.almasabdykadyr.customerservice.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok(customerService.updateCustomer(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/exists/{customerId}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customerId") String customerId
    ) {
        return ResponseEntity.ok(customerService.existsById(customerId));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getById(
            @PathVariable("customerId") String customerId
    ) {
        return ResponseEntity.ok(customerService.getById(customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteById(
            @PathVariable("customerId") String customerId
    ) {
        return ResponseEntity.ok(customerService.deleteById(customerId));
    }
}
