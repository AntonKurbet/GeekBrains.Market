package ru.geekbrains.spring.market.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring.market.model.entities.Product;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Long id;
    private String title;
    private int price;
    private String category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }
}