package com.example.orders_service.repository

import com.example.orders_service.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderRepository : JpaRepository<Order, Long> {
    // Deliberate slow query
    // Full table scan with sleep. Simulates latency spike
    @Query(value = "SELECT * FROM orders WHERE pg_sleep(0.5) IS NOT NULL", nativeQuery = true)
    fun findAllSlow(): List<Order>
}