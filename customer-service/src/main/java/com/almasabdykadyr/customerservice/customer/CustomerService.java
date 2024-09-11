package com.almasabdykadyr.customerservice.customer;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {

        var result = customerRepository.save(mapper.customerRequestToCustomer(request));

        return result.getId();
    }

    public String updateCustomer(CustomerRequest request) {

        var result = customerRepository
                .findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                    String.format("Cannot update customer:: No customer found with given id:: %s", request.id())
                ));

        mergeCustomerWithRequest(result, request);

        customerRepository.save(result);

        return "Customer with id:: %s updated".formatted(result.getId());
    }

    private void mergeCustomerWithRequest(Customer customer, CustomerRequest request)  {

        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }

        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }

        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }

        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }


    public List<CustomerResponse> getAll() {

        return customerRepository.findAll().stream().map(mapper::customerToCustomerResponse).collect(Collectors.toList());
    }

    public Boolean existsById(String id) {

        return customerRepository.existsById(id);
    }

    public CustomerResponse getById(String id) {

        return mapper.customerToCustomerResponse(
                customerRepository.
                        findById(id)
                        .orElseThrow(() ->
                                new CustomerNotFoundException(
                                    String.format("Cannot get customer:: No customer found with given id:: %s", id)
                )));
    }

    public String deleteById(String id) {

        customerRepository.deleteById(id);

        return "Customer with id:: %s deleted".formatted(id);
    }
}

