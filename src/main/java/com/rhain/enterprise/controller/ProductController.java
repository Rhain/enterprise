package com.rhain.enterprise.controller;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.Product;
import com.rhain.enterprise.payload.ApiResponse;
import com.rhain.enterprise.payload.PayloadResponse;
import com.rhain.enterprise.payload.ProductRequest;
import com.rhain.enterprise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest product){
        Product p = productService.addProduct(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/products/{id}")
                .buildAndExpand(p.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Product create successfully"));
    }

    @GetMapping
    public PayloadResponse<?> getAllProducts(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                                          @RequestParam(name = "limit", required = false, defaultValue = "10") int pageSize) {
        PageInfo<Product> products = productService.findProducts(pageNum, pageSize);
        return new PayloadResponse(true, products);
    }

    @GetMapping("/search")
    public PayloadResponse<?> getAllProductsByName(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                                             @RequestParam(name = "limit", required = false, defaultValue = "10") int pageSize,
                                                   @RequestParam(name = "name", required = false, defaultValue = "")String name) {
        PageInfo<Product> products = productService.findProductsByName(pageNum, pageSize, name);
        return new PayloadResponse(true, products);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.ok(new ApiResponse(true, "Update Carousel successfully"));
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(name = "id")Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(new ApiResponse(true, "Delete Carousel successfully"));
    }
}
