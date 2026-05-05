package com.example.orders_service.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @Column(nullable = false)
    val product: String,

    @Column(nullable = false)
    val amount: BigDecimal,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now()
)