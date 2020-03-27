package com.ekviron.rest.mapper;

import com.ekviron.rest.api.dto.ProductDto;
import com.ekviron.rest.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto(Product order);

    Product productDtoToProduct(ProductDto orderDto);

}
