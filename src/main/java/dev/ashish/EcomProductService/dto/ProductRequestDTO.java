package dev.ashish.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
