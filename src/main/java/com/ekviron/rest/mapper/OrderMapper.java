package com.ekviron.rest.mapper;

import com.ekviron.rest.api.dto.OrderDto;
import com.ekviron.rest.model.Order;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);

    List<OrderDto> ordersToOrderDtos(List<Order> order);

}
