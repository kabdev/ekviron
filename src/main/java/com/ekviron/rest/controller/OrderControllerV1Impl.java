package com.ekviron.rest.controller;

import com.ekviron.rest.api.OrderControllerV1;
import com.ekviron.rest.api.dto.OrderDto;
import com.ekviron.rest.mapper.OrderMapper;
import com.ekviron.rest.model.Order;
import com.ekviron.rest.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1Impl implements OrderControllerV1 {

    private final OrderService service;
    private final OrderMapper mapper;

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = service.getOrders();
        return mapper.ordersToOrderDtos(orders);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = service.findById(id);
        return mapper.orderToOrderDto(order);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = mapper.orderDtoToOrder(orderDto);
        Order savedOrder = service.create(order);
        return mapper.orderToOrderDto(savedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        service.delete(id);
    }

}
