package com.cipstore.user.controller;

import com.cipstore.user.dto.CreateOrderRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.UpdateOrderRequestDto;
import com.cipstore.user.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @ApiOperation(value = "Get orders", notes = "Get order")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public @ResponseBody
    Response getOrders(@RequestParam(name = "userId") Long userId) {
        return orderService.getOrders(userId);
    }

    @ApiOperation(value = "Create order", notes = "Get order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public @ResponseBody
    Response createOrder(@RequestBody @Valid CreateOrderRequestDto createOrderRequestDto) {
        return orderService.createOrder(createOrderRequestDto);
    }

    @ApiOperation(value = "Delete order", notes = "Get order")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{orderId}")
    public @ResponseBody
    Response deleteOrder(@PathVariable Long orderId) {
        return orderService.deleteOrder(orderId);
    }

    @ApiOperation(value = "Update order", notes = "Update order")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{orderId}")
    public @ResponseBody
    Response updateOrder(@PathVariable Long orderId,
                         @RequestBody @Valid UpdateOrderRequestDto updateOrderRequestDto) {
        return orderService.updateOrder(orderId, updateOrderRequestDto);
    }

}
