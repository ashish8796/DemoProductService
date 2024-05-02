package dev.ashish.EcomProductService.dto.productDTOs;

import dev.ashish.EcomProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private double price;
    private String description;
    private UUID categoryId;
    private String imageURL;
    private double rating;
}
