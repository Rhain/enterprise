package com.rhain.enterprise.service;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.Product;
import com.rhain.enterprise.payload.ProductRequest;

public interface ProductService {
    Product addProduct(ProductRequest product);

    PageInfo<Product> findProducts(int pageNum, int pageSize);

    PageInfo<Product> findProductsByName(int pageNum, int pageSize, String name);

    int updateProduct(Product product);

    void deleteProduct(Integer id);
}
