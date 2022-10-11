package com.cipstore.order.service.impl;

import com.cipstore.order.domain.Order;
import com.cipstore.order.domain.User;
import com.cipstore.order.dto.CreateOrderRequestDto;
import com.cipstore.order.dto.OrderDto;
import com.cipstore.order.dto.Response;
import com.cipstore.order.dto.UpdateOrderRequestDto;
import com.cipstore.order.repository.OrderRepository;
import com.cipstore.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response getOrders(Long userId) {

        List<Order> orders = orderRepository.findAll();
        OrderDto[] orderDtos = modelMapper.map(orders, OrderDto[].class);

        return Response
                .builder()
                .statusCode(HttpStatus.OK.toString())
                .statusCode("Success")
                .data(orderDtos)
                .build();
    }

    @Override
    public Response createOrder(CreateOrderRequestDto createOrderRequestDto) {

        Order order = new Order();
        order.setDetail(createOrderRequestDto.getDescription());
        order.setUser(new User(createOrderRequestDto.getUserId()));
        order = orderRepository.save(order);

        return Response
                .builder()
                .statusCode(HttpStatus.CREATED.toString())
                .statusCode("Created")
                .data(order.getId())
                .build();
    }

    @Override
    public Response deleteOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        orderRepository.delete(order);

        return Response
                .builder()
                .statusCode(HttpStatus.OK.toString())
                .statusCode("Deleted")
                .data(order.getId())
                .build();
    }

    @Override
    public Response updateOrder(Long orderId, UpdateOrderRequestDto updateOrderRequestDto) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        order.setDetail(updateOrderRequestDto.getDescription());
        orderRepository.save(order);
        return Response
                .builder()
                .statusCode(HttpStatus.OK.toString())
                .statusCode("Updated")
                .data(order.getId())
                .build();
    }
}
