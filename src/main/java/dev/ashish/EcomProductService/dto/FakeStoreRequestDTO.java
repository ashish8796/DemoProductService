package dev.ashish.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreRequestDTO {
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;

    @Override
    public String toString() {
        return "FakeStoreRequestDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
