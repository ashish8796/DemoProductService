package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.client.FakeStoreClient;
import dev.ashish.EcomProductService.dto.FakeStoreCartResponseDTO;
import dev.ashish.EcomProductService.exception.CartController.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreCartServiceImpl implements CartService{
    @Autowired
    FakeStoreClient fakeStoreClient;
    @Override
    public FakeStoreCartResponseDTO getCartById(int cartId) {
        FakeStoreCartResponseDTO cart = fakeStoreClient.getCartById(cartId);

        if(cart == null) {
            throw new CartNotFoundException("Cart is not found with id: " + cartId);
        }

        return cart;
    }
}