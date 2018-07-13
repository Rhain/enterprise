package com.rhain.enterprise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.dao.ProductDao;
import com.rhain.enterprise.model.Product;
import com.rhain.enterprise.payload.ProductRequest;
import com.rhain.enterprise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest);
        productDao.insertProduct(product);
        return product;
    }

    @Override
    public PageInfo<Product> findProducts(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productDao.selectProducts();
        return new PageInfo<Product>(products);
    }

    @Override
    public PageInfo<Product> findProductsByName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productDao.selectProductsByName(name);
        return new PageInfo<Product>(products);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.deleteProductById(id);
    }
}
