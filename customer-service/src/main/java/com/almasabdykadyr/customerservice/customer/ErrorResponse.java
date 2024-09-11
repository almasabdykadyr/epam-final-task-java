package com.almasabdykadyr.customerservice.customer;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
