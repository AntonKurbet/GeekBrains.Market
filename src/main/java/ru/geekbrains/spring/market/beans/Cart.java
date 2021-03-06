package ru.geekbrains.spring.market.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.market.exceptions.ProductNotFoundException;
import ru.geekbrains.spring.market.model.entities.OrderItem;
import ru.geekbrains.spring.market.model.entities.Product;
import ru.geekbrains.spring.market.services.ProductService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class Cart {

    @Autowired
    private ProductService productService;
    private List<OrderItem> items;
    private BigDecimal totalPrice;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
        this.totalPrice = new BigDecimal(0);
    }

    public void addToCart(Long id) {
        for (OrderItem o : items) {
            if (o.getProduct().getId().equals(id)) {
                o.incrementQuantity();
                recalculate();
                return;
            }
        }
        Product p = productService.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Unable to find product with id: " + id + " (add to cart)"));
        OrderItem orderItem = new OrderItem(p);
        items.add(orderItem);
        recalculate();
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void recalculate() {
        totalPrice = BigDecimal.ZERO;
        for (OrderItem o : items) {
            totalPrice.add(o.getPrice());
        }
    }

}


