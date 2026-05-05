package com.example.orders_service.dto

import com.example.orders_service.model.Order

fun Order.toResponse() = OrderResponse(
    id = id,
    product = product,
    amount = amount,
    createdAt = createdAt,
    customer = CustomerSummary(
        id = customer.id,
        name = customer.name
    )
)