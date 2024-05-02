package dev.ashish.EcomProductService.dto.fakeStoreDTOs;

import dev.ashish.EcomProductService.dto.fakeStoreDTOs.FakeStoreProductRatingDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private FakeStoreProductRatingDTO rating;

    @Override
    public String toString() {
        return "FakeStoreProductResponseDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", rating=" + rating +
                '}';
    }
}
