package com.example.orders_service.service

import com.example.orders_service.dto.OrderResponse
import com.example.orders_service.dto.toResponse
import com.example.orders_service.repository.CustomerRepository
import com.example.orders_service.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository
) {
    // Fast path -> Normal fetch
    @Transactional(readOnly = true)
    fun getAllOrders(): List<OrderResponse> =
        orderRepository.findAll().map { it.toResponse() }

    // Slow path -> Simulates latency spike for eBPF to catch
    @Transactional(readOnly = true)
    fun getAllOrdersSlow(): List<OrderResponse> =
        orderRepository.findAllSlow().map { it.toResponse() }

    // N + 1 problem -> Each order triggers a separate customer query
    @Transactional(readOnly = true)
    fun getOrdersWithN1Problem(): List<Map<String, Any?>> {
        val orders = orderRepository.findAll()
        return orders.map { order ->
            val customer = customerRepository.findById(order.customer.id).orElse(null)
            mapOf(
                "orderId" to order.id,
                "product" to order.product,
                "amount" to order.amount,
                "customerName" to customer?.name
            )
        }
    }
}