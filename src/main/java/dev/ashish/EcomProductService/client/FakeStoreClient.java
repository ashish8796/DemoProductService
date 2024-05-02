package dev.ashish.EcomProductService.client;

import dev.ashish.EcomProductService.dto.fakeStoreDTOs.FakeStoreCartResponseDTO;
import dev.ashish.EcomProductService.dto.fakeStoreDTOs.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.dto.fakeStoreDTOs.FakeStoreRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseurl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.path}")
    private String fakeStoreAPICartPath;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String url = fakeStoreAPIBaseurl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO[]> allProduct = restTemplate.getForEntity(url, FakeStoreProductResponseDTO[].class);

        return List.of(allProduct.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String url = fakeStoreAPIBaseurl.concat(fakeStoreAPIProductPath + "/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> product =  restTemplate.getForEntity(url, FakeStoreProductResponseDTO.class);
        return product.getBody();
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreRequestDTO updatedProduct) {
        String url = fakeStoreAPIBaseurl.concat(fakeStoreAPIProductPath + "/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(url, updatedProduct);
        FakeStoreProductResponseDTO product = restTemplate.getForObject(url, FakeStoreProductResponseDTO.class);
        return product;
    }

    public boolean deleteProduct(int id) {
        String url = fakeStoreAPIBaseurl.concat(fakeStoreAPIProductPath +"/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();

        restTemplate.delete(url);
        return true;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        String url = fakeStoreAPIBaseurl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductResponseDTO> product =  restTemplate.postForEntity(url, fakeStoreRequestDTO, FakeStoreProductResponseDTO.class);
        return product.getBody();
    }

    public FakeStoreCartResponseDTO getCartById(int cartId) {
        String url = fakeStoreAPIBaseurl.concat(fakeStoreAPICartPath +"/" + cartId);
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreCartResponseDTO> cart = restTemplate.getForEntity(url, FakeStoreCartResponseDTO.class);
        return cart.getBody();
    }
}
