package com.cipstore.user.service;

import com.cipstore.user.dto.CreateOrderRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.UpdateOrderRequestDto;

public interface OrderService {
    Response getOrders(Long userId);

    Response createOrder(CreateOrderRequestDto createOrderRequestDto);

    Response deleteOrder(Long orderId);

    Response updateOrder(Long orderId, UpdateOrderRequestDto updateOrderRequestDto);
}
