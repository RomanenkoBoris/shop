package com.example.shop14;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class Product {
    @Id
    private Long id;
    private String name;
    BigDecimal price;
    boolean isActive;

    public Product() {
        id = new Random().nextLong();
    }

    public Product(String name, BigDecimal price, boolean isActive) {
        this();
        this.name = name;
        this.price = price;
        this.isActive = isActive;
    }


}
