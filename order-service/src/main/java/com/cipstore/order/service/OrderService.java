package com.cipstore.order.service;

import com.cipstore.order.dto.CreateOrderRequestDto;
import com.cipstore.order.dto.Response;
import com.cipstore.order.dto.UpdateOrderRequestDto;

public interface OrderService {
    Response getOrders(Long userId);

    Response createOrder(CreateOrderRequestDto createOrderRequestDto);

    Response deleteOrder(Long orderId);

    Response updateOrder(Long orderId, UpdateOrderRequestDto updateOrderRequestDto);
}
