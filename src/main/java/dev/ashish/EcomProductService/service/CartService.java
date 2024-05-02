package dev.ashish.EcomProductService.service;


import dev.ashish.EcomProductService.dto.fakeStoreDTOs.FakeStoreCartResponseDTO;


public interface CartService {
    FakeStoreCartResponseDTO getCartById(int cartId);
}
