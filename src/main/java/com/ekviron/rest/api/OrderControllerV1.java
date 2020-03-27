package com.ekviron.rest.api;

import com.ekviron.rest.api.dto.OrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order", description = "the Order API")
@RestController
@RequestMapping("/api/v1")
public interface OrderControllerV1 {

    @Operation(summary = "Show all orders", description = "Return all exists orders", tags = {"Order"})
    @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderDto.class))))
    @GetMapping("/orders")
    List<OrderDto> getOrders();

    @Operation(summary = "Find order by ID", description = "Returns a single order", tags = {"Order"})
    @ApiResponse(content = @Content(schema = @Schema(implementation = OrderDto.class)))
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Not found")
    @GetMapping("/orders/{id}")
    OrderDto getOrderById(
        @Parameter(description = "Id to search for an order. Cannot be empty.", required = true)
        @PathVariable("id") Long id
    );

    @Operation(summary = "Create new order", description = "Returns created order", tags = {"Order"})
    @ApiResponse(content = @Content(schema = @Schema(implementation = OrderDto.class)))
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "400", description = "Validation errors")
    @ApiResponse(responseCode = "409", description = "Order already exist")
    @PostMapping(value = "/orders", consumes = {"application/json"})
    OrderDto createOrder(
        @Parameter(description = "Order entity for creating. Cannot be empty.", required = true)
        @Valid @RequestBody OrderDto order
    );

    @Operation(summary = "Delete order by id", description = "Just delete order", tags = {"Order"})
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Order not found")
    @DeleteMapping("/orders/{id}")
    void deleteOrder(
        @Parameter(description = "Id of the order to be delete. Cannot be empty.", required = true)
        @PathVariable("id")
            Long id
    );

}
