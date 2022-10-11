package com.cipstore.user.client;


import com.cipstore.user.dto.CreateOrderRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.UpdateOrderRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("/order-service/order")
    @ResponseBody
    Response getOrders(@RequestParam(name = "userId") Long userId);

    @PostMapping("/order-service/order")
    @ResponseBody
    Response createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto);

    @DeleteMapping("/order-service/order/{orderId}")
    @ResponseBody
    Response deleteOrder(@PathVariable("orderId") Long orderId);

    @PatchMapping("/order-service/order/{orderId}")
    @ResponseBody
    Response updateOrder(@PathVariable("orderId") Long orderId,
                         @RequestBody UpdateOrderRequestDto updateOrderRequestDto);
}
