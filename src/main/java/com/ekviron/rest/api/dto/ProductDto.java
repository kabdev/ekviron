package com.ekviron.rest.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "product")
public class ProductDto {

    @Schema(description = "Unique identifier of the product.", hidden = true)
    private Long id;

    @NotBlank
    @Schema(description = "product name", example = "milk")
    private String name;

    @NotBlank
    @Size(min = 13, max = 13)
    @Schema(description = "product code", example = "1234567890123", minLength = 13, maxLength = 13)
    private String code;

}
