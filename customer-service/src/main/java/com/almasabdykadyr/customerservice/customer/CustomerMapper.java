package com.almasabdykadyr.customerservice.customer;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Customer customerRequestToCustomer(CustomerRequest customerRequest);
    CustomerResponse customerToCustomerResponse(Customer customer);
}
