package com.example.orders_service.controller

import com.example.orders_service.dto.OrderResponse
import com.example.orders_service.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {
    @GetMapping
    fun getOrders(): ResponseEntity<List<OrderResponse>> =
        ResponseEntity.ok(orderService.getAllOrders())

    @GetMapping("/slow")
    fun getOrdersSlow(): ResponseEntity<List<OrderResponse>> =
        ResponseEntity.ok(orderService.getAllOrdersSlow())

    @GetMapping("/n1")
    fun getOrdersN1(): ResponseEntity<List<Map<String, Any?>>> =
        ResponseEntity.ok(orderService.getOrdersWithN1Problem())
}