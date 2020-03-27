package com.ekviron.rest.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "order")
public class OrderDto {

    @Schema(description = "Unique identifier of the order.", hidden = true)
    private Long id;

    @NotBlank
    @Size(min = 9, max = 9)
    @Schema(description = "Unique identifier of the Seller.", example = "123456789", required = true)
    private String seller;

    @NotBlank
    @Size(min = 9, max = 9)
    @Schema(description = "Unique identifier of the Customer.", example = "123456789", required = true)
    private String customer;

    @NotEmpty
    @Schema(description = "Order products", required = true, minimum = "1")
    private List<ProductDto> products;

}
