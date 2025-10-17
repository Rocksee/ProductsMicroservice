package com.products.ws.ProductsMicroservice.rest;

import com.products.ws.ProductsMicroservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products") //http://localhost:9092/products
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreatedProductRestModel product) {
        String productID = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productID);
    }

}
