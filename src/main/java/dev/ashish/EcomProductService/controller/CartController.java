package dev.ashish.EcomProductService.controller;

import dev.ashish.EcomProductService.dto.fakeStoreDTOs.FakeStoreCartResponseDTO;
import dev.ashish.EcomProductService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity getCartById(@PathVariable("id") int cartId) {
        FakeStoreCartResponseDTO cart = cartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }
}
