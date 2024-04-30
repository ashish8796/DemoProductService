package dev.ashish.EcomProductService.service;


import dev.ashish.EcomProductService.dto.FakeStoreCartResponseDTO;
import org.springframework.stereotype.Service;


public interface CartService {
    FakeStoreCartResponseDTO getCartById(int cartId);
}
