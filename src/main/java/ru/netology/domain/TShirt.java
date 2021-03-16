package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class TShirt extends Product {
    private String brand;

    public TShirt() {
        super();
    }

    public TShirt(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }
}