package com.cipstore.user.service.impl;

import com.cipstore.user.client.OrderClient;
import com.cipstore.user.dto.CreateOrderRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.UpdateOrderRequestDto;
import com.cipstore.user.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderClient orderClient;

    @Override
    public Response getOrders(Long userId) {
        return orderClient.getOrders(userId);
    }

    @Override
    public Response createOrder(CreateOrderRequestDto createOrderRequestDto) {
        return orderClient.createOrder(createOrderRequestDto);
    }

    @Override
    public Response deleteOrder(Long orderId) {
        return orderClient.deleteOrder(orderId);
    }

    @Override
    public Response updateOrder(Long orderId, UpdateOrderRequestDto updateOrderRequestDto) {
        return orderClient.updateOrder(orderId, updateOrderRequestDto);
    }
}
