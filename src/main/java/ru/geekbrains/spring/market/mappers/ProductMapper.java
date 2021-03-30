package ru.geekbrains.spring.market.mappers;

//import org.mapstruct.Mapper;
import ru.geekbrains.spring.market.model.dtos.ProductDto;
import ru.geekbrains.spring.market.model.entities.Product;

//@Mapper
public interface ProductMapper {
    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto dto);
}
