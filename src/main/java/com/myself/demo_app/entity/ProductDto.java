package com.myself.demo_app.entity;

import javax.validation.constraints.NotEmpty;

public class ProductDto {
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "Price is Mandatory")
    private Double price;
    private String description;
}
