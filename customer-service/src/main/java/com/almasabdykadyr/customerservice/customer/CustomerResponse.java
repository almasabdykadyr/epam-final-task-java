package com.almasabdykadyr.customerservice.customer;

public record CustomerResponse(
        String firstname,
        String lastname,
        String email,
        Address address) {
}
