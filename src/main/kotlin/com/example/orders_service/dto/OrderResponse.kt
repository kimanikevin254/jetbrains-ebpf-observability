package com.example.orders_service.dto

import java.math.BigDecimal
import java.time.Instant

data class OrderResponse(
    val id: Long,
    val product: String,
    val amount: BigDecimal,
    val createdAt: Instant,
    val customer: CustomerSummary
)