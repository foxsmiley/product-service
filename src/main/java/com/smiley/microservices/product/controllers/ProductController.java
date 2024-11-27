package com.smiley.microservices.product.controllers;

import com.smiley.microservices.product.dto.ProductRequest;
import com.smiley.microservices.product.dto.ProductResponse;
import com.smiley.microservices.product.models.Product;
import com.smiley.microservices.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest ){
        System.out.println("im here POST");
    return productService.createProduct(productRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        System.out.println("im here");
        return productService.getAllProducts();
    }

}
