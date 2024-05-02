package dev.ashish.EcomProductService.dto.fakeStoreDTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FakeStoreCartResponseDTO {
    private int id;
    private int userId;
    private LocalDateTime dateTime;
    private List<FakeStoreProductResponseDTO> products;
}
